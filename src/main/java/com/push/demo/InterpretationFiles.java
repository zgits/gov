package com.push.demo;

public class InterpretationFiles {

    private String fileno;


    private String title;


    private String fileName;


    private String filecontent;

    private String fileurl;

    @Override
    public String toString() {
        return "InterpretationFiles{" +
                "fileno='" + fileno + '\'' +
                ", title='" + title + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filecontent='" + filecontent + '\'' +
                ", fileurl='" + fileurl + '\'' +
                '}';
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilecontent() {
        return filecontent;
    }

    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent;
    }
}
