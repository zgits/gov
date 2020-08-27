package com.push.demo;

public class Interpretation {

    private String title;
    private String source;
    private String fileurl;
    private String filecontent;

    @Override
    public String toString() {
        return "Interpretation{" +
                "title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", fileurl='" + fileurl + '\'' +
                ", filecontent='" + filecontent + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
