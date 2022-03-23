package com.nit.ssm.entity;

public class ExamEntity {
    private Integer examId;
    private String examSn;
    private Integer garbageId;
    private Integer userId;
    private Integer sortId;
    private Integer answerId;
    private String createTime;

    public ExamEntity(){

    }

    public ExamEntity(Integer examId, String examSn, Integer garbageId, Integer userId, Integer sortId, Integer answerId, String createTime) {
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

    public Integer getGarbageId() {
        return garbageId;
    }

    public void setGarbageId(Integer garbageId) {
        this.garbageId = garbageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

