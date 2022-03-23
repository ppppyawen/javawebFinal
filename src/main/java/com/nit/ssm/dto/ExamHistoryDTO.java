package com.nit.ssm.dto;
/*用来查看历史答题记录条数的DTO*/
public class ExamHistoryDTO {
    private String examSn;
    private String userName;
    private String createTime;

    public ExamHistoryDTO() {

    }

    public ExamHistoryDTO(String examSn, String userName, String createTime) {
        this.examSn = examSn;
        this.userName = userName;
        this.createTime = createTime;
    }

    public String getExamSn() {
        return examSn;
    }

    public void setExamSn(String examSn) {
        this.examSn = examSn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
