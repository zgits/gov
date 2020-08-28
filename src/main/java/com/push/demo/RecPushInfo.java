package com.push.demo;


import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/service")
public class RecPushInfo {

    private static Logger logger = LoggerFactory.getLogger(RecPushInfo.class);

    private int flag = 1;

    private String key = "123456789";


    @PostMapping("/postDeptPolicyMessageInfo")
    public Map<String, String> getSendInfo(@RequestBody RecData recData) {
        logger.warn("_______________________________________________________________________________________________");
        logger.warn("_______________________________________________________________________________________________");
        String msg = "";
        String resultStatus = Boolean.TRUE.toString();
        try {
            String postDataSerc = recData.getPostData();
//            logger.warn("获取到的加密数据：" + recData);
//            logger.warn("_______________________________________________________________________________________________");
            String decryptPostData = Sm4Util.decryptEcb(key, postDataSerc);
//            logger.warn("解密后的数据：" + decryptPostData);
//            logger.warn("_______________________________________________________________________________________________");
            PostData postData = JSON.parseObject(decryptPostData, PostData.class);
            logger.warn(postData.getStatus());
            String docContent = postData.getDocumentContent();
            postData.setDocumentContent("");
            List<AppendFile> appendFiles = postData.getAppendFile();
            int i = 0;
            if (appendFiles!=null){

                for (int j = 0; j < appendFiles.size(); j++) {
                    AppendFile appendFile = appendFiles.get(j);
                    String fileName = appendFile.getFileName(); //生成的新文件
                    String string = appendFile.getFilecontent();
                    try {
                        // 解码，然后将字节转换为文件
                        byte[] bytes = new BASE64Decoder().decodeBuffer(string);   //将字符串转换为byte数组
                        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
                        byte[] buffer = new byte[1024];
                        FileOutputStream out = new FileOutputStream(fileName);
                        int bytesum = 0;
                        int byteread = 0;
                        while ((byteread = in.read(buffer)) != -1) {
                            bytesum += byteread;
                            out.write(buffer, 0, byteread); //文件写操作
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
            List<AppendFile> newappendFile = new ArrayList<>();

            if (appendFiles!=null){
                for (AppendFile appendFile : appendFiles) {
                    appendFile.setDocumentTitle(null);
                    appendFile.setFilecontent(null);
                    appendFile.setFileno(null);
                    appendFile.setFileurl(null);
                    newappendFile.add(appendFile);
                }
            }
            postData.setAppendFile(newappendFile);
            logger.warn("解密后转换成实体类之后：" + postData);
            logger.warn("_______________________________________________________________________________________________");
            String title = postData.getDocumentTitle();
            String status = postData.getStatus();
            String sqNo = postData.getSequenceNo();




            String deDocContent = new String(new BASE64Decoder().decodeBuffer(docContent), "UTF-8");
            logger.warn("正文内容：" + deDocContent);
            if (flag == 1) {
                resultStatus = Boolean.TRUE.toString();
                msg = "在" + new Date() + "成功接收到顺序号为" + sqNo + ",状态为" + status + ",标题为" + title + "的政策文件！";
            } else {
                resultStatus = Boolean.FALSE.toString();
                msg = "消息接收数据失败，请重新检查推送内容！";
            }
            sendToHy(postData);
//            logger.warn("接收的数据：" + postData.toString());
        }catch (IOException e){
            logger.error("保存海云出错",e);
        }
        catch (Exception e) {
            logger.error("获取数据出错", e);
            resultStatus = Boolean.FALSE.toString();
            msg = "消息接收数据失败，请重新检查推送内容！";
        }

        Map<String, String> result = new HashMap<>();
        result.put("status", resultStatus);
//        flag = flag * -1;
        result.put("msg", msg);
        return result;
    }


    private String sendToHy(PostData postData) throws IOException {
        MediaType contentType = MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8");
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("DOCHTMLCON", "postData.toString()");
        map.put("DOCTITLE", "postData.getDocumentTitle()");
        map.put("methodname", "saveDocumentInWeb");
        map.put("serviceid", "gov_webdocument");
        map.put("CHANNELID", "19918");
        map.put("DOCTYPE", "20");
        map.put("ObjectId", "0");
        map.put("CurrUserName", "autoadmin");

        String param = "CHANNELID=19918&DOCTYPE=20&serviceid=gov_webdocument&methodname=saveDocumentInWeb&ObjectId=0&CurrUserName=autoadmin&DOCHTMLCON="+postData.toString()+"&DOCTITLE="+postData.getDocumentTitle();

        okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(contentType, param);

        Request request = new Request.Builder()
                .url("http://192.168.200.171/gov/gov.do")
                .post(requestBody)
                .build();


        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return response.toString();
        }
    }
}
