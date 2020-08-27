package com.push.demo;

public class RelevantDocument {

    private String fileContent;

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "RelevantDocument{" +
                "fileContent='" + fileContent + '\'' +
                '}';
    }
}
