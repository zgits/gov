package com.push.demo;

public class AppendFile {

    private String fileno;
    private String documentTitle;
    private String fileName;
    private String fileurl;
    private String filecontent;

    @Override
    public String toString() {
        return "AppendFile{" +
                "fileno='" + fileno + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileurl='" + fileurl + '\'' +
                ", filecontent='" + filecontent + '\'' +
                '}';
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent;
    }
}
