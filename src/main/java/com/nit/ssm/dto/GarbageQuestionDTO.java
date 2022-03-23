package com.nit.ssm.dto;

public class GarbageQuestionDTO {
    private Integer garbageId;
    private String garbageName;



    public GarbageQuestionDTO(){

    }

    public GarbageQuestionDTO(Integer garbageId, String garbageName) {
        this.garbageId = garbageId;
        this.garbageName = garbageName;
    }


    public Integer getGarbageId() {
        return garbageId;
    }

    public void setGarbageId(Integer garbageId) {
        this.garbageId = garbageId;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

}

