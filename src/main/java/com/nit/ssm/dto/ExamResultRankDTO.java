package com.nit.ssm.dto;
/*排行情况的DTO*/
public class ExamResultRankDTO {
    private String userName;
    private String trueAnswer;
    private String totalAnswer;

    public ExamResultRankDTO() {
    }

    public ExamResultRankDTO(String userName, String trueAnswer, String totalAnswer) {
        this.userName = userName;
        this.trueAnswer = trueAnswer;
        this.totalAnswer = totalAnswer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getTotalAnswer() {
        return totalAnswer;
    }

    public void setTotalAnswer(String totalAnswer) {
        this.totalAnswer = totalAnswer;
    }
}
