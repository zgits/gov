package com.push.demo;

public class RecData {

    private String postDept;
    private String postTime;
    private String postData;

    @Override
    public String toString() {
        return "recData{" +
                "postDept='" + postDept + '\'' +
                ", postTime='" + postTime + '\'' +
                ", postData=" + postData +
                '}';
    }

    public String getPostDept() {
        return postDept;
    }

    public void setPostDept(String postDept) {
        this.postDept = postDept;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }
}
