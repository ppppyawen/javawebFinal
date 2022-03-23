package com.nit.ssm.dto;

import java.util.List;

public class ExamTableRspDTO {
    private Integer total;
    private List examTable;

    public ExamTableRspDTO() {
    }

    public ExamTableRspDTO(List examTable) {
        this.examTable = examTable;
    }

    public ExamTableRspDTO(Integer total, List examTable) {
        this.total = total;
        this.examTable = examTable;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getExamTable() {
        return examTable;
    }

    public void setExamTable(List examTable) {
        this.examTable = examTable;
    }

    @Override
    public String toString() {
        return "ExamTableRspDTO{" +
                "total=" + total +
                ", examTable=" + examTable +
                '}';
    }
}
