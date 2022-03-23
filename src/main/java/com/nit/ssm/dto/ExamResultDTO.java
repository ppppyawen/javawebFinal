package com.nit.ssm.dto;
/*用来传输答题详情的DTO*/
public class ExamResultDTO {
    private String garbageName;
    private String answerName;
    private String trueName;
    private String sortInfo;

    public ExamResultDTO() {
    }

    public ExamResultDTO(String garbageName, String answerName, String trueName, String sortInfo) {
        this.garbageName = garbageName;
        this.answerName = answerName;
        this.trueName = trueName;
        this.sortInfo = sortInfo;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(String sortInfo) {
        this.sortInfo = sortInfo;
    }
}
