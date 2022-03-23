package com.nit.ssm.dto;

import java.util.List;

public class ExamListRspDTO {
    private List resultList;

    public ExamListRspDTO(){

    }

    public ExamListRspDTO(List resultList) {
        this.resultList = resultList;
    }

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }
}
