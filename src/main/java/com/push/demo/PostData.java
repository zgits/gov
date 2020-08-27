package com.push.demo;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class PostData {

    private String documentTitle;
    private String releaseDate;
    private String pulishDate;
    private String postNumber;
    private String agencyWord;
    private String year;
    private String sequenceNo;
    private String keyword;
    private String documentType;
    private String publisher;
    private String themeCategory;
    private String documentSource;
    private String documentContent;
    private List<AppendFile> appendFile;
    private List<Interpretation> interpretation;
    private List<InterpretationFiles> interpretationFiles;
    private List<RelevantDocument> relevantDocument;
    private String materialData;
    private String abolitionDate;
    private String validity;
    private String status;
    private String aritcleid;
    private String documentDepartment;
    private String documentCount;
    private String sequenceCount;
    private String otherInfo1;
    private String otherInfo2;
    private String otherInfo3;


    @Override
    public String toString() {
        return "PostData{" +
                "documentTitle='" + documentTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", pulishDate='" + pulishDate + '\'' +
                ", postNumber='" + postNumber + '\'' +
                ", agencyWord='" + agencyWord + '\'' +
                ", year='" + year + '\'' +
                ", sequenceNo='" + sequenceNo + '\'' +
                ", keyword='" + keyword + '\'' +
                ", documentType='" + documentType + '\'' +
                ", publisher='" + publisher + '\'' +
                ", themeCategory='" + themeCategory + '\'' +
                ", documentSource='" + documentSource + '\'' +
                ", documentContent='" + documentContent + '\'' +
                ", appendFile=" + JSON.toJSONString(appendFile) +
                ", interpretation=" + JSON.toJSONString(interpretation) +
                ", interpretationFiles=" + JSON.toJSONString(interpretationFiles) +
                ", relevantDocument=" + JSON.toJSONString(relevantDocument) +
                ", materialData='" + materialData + '\'' +
                ", abolitionDate='" + abolitionDate + '\'' +
                ", validity='" + validity + '\'' +
                ", status='" + status + '\'' +
                ", aritcleid='" + aritcleid + '\'' +
                ", documentDepartment='" + documentDepartment + '\'' +
                ", documentCount='" + documentCount + '\'' +
                ", sequenceCount='" + sequenceCount + '\'' +
                ", otherInfo1='" + otherInfo1 + '\'' +
                ", otherInfo2='" + otherInfo2 + '\'' +
                ", otherInfo3='" + otherInfo3 + '\'' +
                '}';
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(String pulishDate) {
        this.pulishDate = pulishDate;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public String getAgencyWord() {
        return agencyWord;
    }

    public void setAgencyWord(String agencyWord) {
        this.agencyWord = agencyWord;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getThemeCategory() {
        return themeCategory;
    }

    public void setThemeCategory(String themeCategory) {
        this.themeCategory = themeCategory;
    }

    public String getDocumentSource() {
        return documentSource;
    }

    public void setDocumentSource(String documentSource) {
        this.documentSource = documentSource;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public List<AppendFile> getAppendFile() {
        return appendFile;
    }

    public void setAppendFile(List<AppendFile> appendFile) {
        this.appendFile = appendFile;
    }

    public List<Interpretation> getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(List<Interpretation> interpretation) {
        this.interpretation = interpretation;
    }

    public List<InterpretationFiles> getInterpretationFiles() {
        return interpretationFiles;
    }

    public void setInterpretationFiles(List<InterpretationFiles> interpretationFiles) {
        this.interpretationFiles = interpretationFiles;
    }

    public List<RelevantDocument> getRelevantDocument() {
        return relevantDocument;
    }

    public void setRelevantDocument(List<RelevantDocument> relevantDocument) {
        this.relevantDocument = relevantDocument;
    }

    public String getMaterialData() {
        return materialData;
    }

    public void setMaterialData(String materialData) {
        this.materialData = materialData;
    }

    public String getAbolitionDate() {
        return abolitionDate;
    }

    public void setAbolitionDate(String abolitionDate) {
        this.abolitionDate = abolitionDate;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAritcleid() {
        return aritcleid;
    }

    public void setAritcleid(String aritcleid) {
        this.aritcleid = aritcleid;
    }

    public String getDocumentDepartment() {
        return documentDepartment;
    }

    public void setDocumentDepartment(String documentDepartment) {
        this.documentDepartment = documentDepartment;
    }

    public String getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(String documentCount) {
        this.documentCount = documentCount;
    }

    public String getSequenceCount() {
        return sequenceCount;
    }

    public void setSequenceCount(String sequenceCount) {
        this.sequenceCount = sequenceCount;
    }

    public String getOtherInfo1() {
        return otherInfo1;
    }

    public void setOtherInfo1(String otherInfo1) {
        this.otherInfo1 = otherInfo1;
    }

    public String getOtherInfo2() {
        return otherInfo2;
    }

    public void setOtherInfo2(String otherInfo2) {
        this.otherInfo2 = otherInfo2;
    }

    public String getOtherInfo3() {
        return otherInfo3;
    }

    public void setOtherInfo3(String otherInfo3) {
        this.otherInfo3 = otherInfo3;
    }
}
