package com.nit.ssm.dto;

import java.util.List;

public class ExamListReqDTO {
    private  String examSn;
    private  List garbageIdList;
    private  List garbageAnswerList;

    public ExamListReqDTO(){

    }

    public String getExamSn() {
        return examSn;
    }

    public void setExamSn(String examSn) {
        this.examSn = examSn;
    }

    public List getGarbageIdList() {
        return garbageIdList;
    }

    public void setGarbageIdList(List garbageIdList) {
        this.garbageIdList = garbageIdList;
    }

    public List getGarbageAnswerList() {
        return garbageAnswerList;
    }

    public void setGarbageAnswerList(List garbageAnswerList) {
        this.garbageAnswerList = garbageAnswerList;
    }
}
