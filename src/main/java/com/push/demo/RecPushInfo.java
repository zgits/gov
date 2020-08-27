package com.push.demo;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class RecPushInfo {

    private static Logger logger = LoggerFactory.getLogger(RecPushInfo.class);

    private int flag = 1;

    private String key = "123456789";


    @PostMapping("/postDeptPolicyMessageInfo")
    public Map<String, String> getSendInfo(@RequestBody RecData recData) {
        String msg = "";
        String resultStatus = Boolean.TRUE.toString();
        try {
            String postDataSerc = recData.getPostData();
            logger.warn("获取到的加密数据：" + recData);
            logger.warn("-----" + Sm4Util.encryptEcb(key, "werwer"));
            String decryptPostData = Sm4Util.decryptEcb(key, postDataSerc);
            logger.warn("解密后的数据：" + decryptPostData);
            PostData postData = JSON.parseObject(decryptPostData, PostData.class);

            logger.warn("解密后转换成实体类之后：" + postData);
            String title = postData.getDocumentTitle();
            String status = postData.getStatus();
            String sqNo = postData.getSequenceNo();
            String docContent = postData.getDocumentContent();
            String deDocContent = new String(new BASE64Decoder().decodeBuffer(docContent),"UTF-8");
            logger.warn("正文内容："+deDocContent);
            if (flag == 1) {
                resultStatus = Boolean.TRUE.toString();
                msg = "在" + new Date() + "成功接收到顺序号为" + sqNo + ",状态为" + status + ",标题为" + title + "的政策文件！";
            } else {
                resultStatus = Boolean.FALSE.toString();
                msg = "消息接收数据失败，请重新检查推送内容！";
            }
        } catch (Exception e) {
            logger.error("获取数据出错",e);
            resultStatus = Boolean.FALSE.toString();
            msg = "消息接收数据失败，请重新检查推送内容！";
        }

        Map<String, String> result = new HashMap<>();
        result.put("status", resultStatus);
        flag = flag * -1;
        result.put("msg", msg);
        logger.warn("接收的数据："+recData.toString());
        return result;
    }
}
