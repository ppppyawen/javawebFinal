package com.nit.ssm.dto;

public class ExamLineResultDTO {
    private int trueCount;
    private int wrongCount;
    private String createTime;

    public ExamLineResultDTO() {
    }

    public ExamLineResultDTO(int trueCount, int wrongCount, String createTime) {
        this.trueCount = trueCount;
        this.wrongCount = wrongCount;
        this.createTime = createTime;
    }

    public int getTrueCount() {
        return trueCount;
    }

    public void setTrueCount(int trueCount) {
        this.trueCount = trueCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
