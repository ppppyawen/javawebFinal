package com.nit.ssm.dto;
/*饼图正确错误数的DTO*/
public class ExamResultPieDTO {
    private String wrongCount;
    private String trueCount;

    public ExamResultPieDTO() {
    }

    public ExamResultPieDTO(String wrongCount, String trueCount) {
        this.wrongCount = wrongCount;
        this.trueCount = trueCount;
    }

    public String getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(String wrongCount) {
        this.wrongCount = wrongCount;
    }

    public String getTrueCount() {
        return trueCount;
    }

    public void setTrueCount(String trueCount) {
        this.trueCount = trueCount;
    }
}
