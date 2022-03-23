package com.nit.ssm.dto;

/**
 * TODO
 *
 * @author pyw
 * @version 1.0

 */
public class ExamInfoDTP {

    String examSn;  //用来查找题目
    String createTime;
    String userName;
    String correctNum;

    public ExamInfoDTP() {
    }

    public ExamInfoDTP(String examSn, String createTime, String userName, String correctNum) {
        this.examSn = examSn;
        this.createTime = createTime;
        this.userName = userName;
        this.correctNum = correctNum;
    }

    public String getExamSn() {
        return examSn;
    }

    public void setExamSn(String examSn) {
        this.examSn = examSn;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(String correctNum) {
        this.correctNum = correctNum;
    }

    @Override
    public String toString() {
        return "ExamInfoDTP{" +
                "examSn='" + examSn + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userName='" + userName + '\'' +
                ", correctNum='" + correctNum + '\'' +
                '}';
    }
}
