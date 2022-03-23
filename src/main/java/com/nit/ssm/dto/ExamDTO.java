package com.nit.ssm.dto;

public class ExamDTO {
    private Integer examId;
    private String examSn;
    private String garbageId;
    private Integer userId;
    private String sortId;
    private String answerId;
    private String createTime;

    public ExamDTO(){

    }

    public ExamDTO(Integer examId, String examSn, String garbageId, Integer userId, String sortId, String answerId, String createTime) {
        this.examId = examId;
        this.examSn = examSn;
        this.garbageId = garbageId;
        this.userId = userId;
        this.sortId = sortId;
        this.answerId = answerId;
        this.createTime = createTime;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamSn() {
        return examSn;
    }

    public void setExamSn(String examSn) {
        this.examSn = examSn;
    }

    public String getGarbageId() {
        return garbageId;
    }

    public void setGarbageId(String garbageId) {
        this.garbageId = garbageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

