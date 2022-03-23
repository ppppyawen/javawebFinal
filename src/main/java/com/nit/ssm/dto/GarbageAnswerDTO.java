package com.nit.ssm.dto;

public class GarbageAnswerDTO {
    private Integer garbageId;
    private Integer sortId;
    private String sortName;

    public GarbageAnswerDTO(){

    }

    public GarbageAnswerDTO(Integer garbageId, Integer sortId, String sortName) {
        this.garbageId = garbageId;
        this.sortId = sortId;
        this.sortName = sortName;
    }

    public Integer getGarbageId() {
        return garbageId;
    }

    public void setGarbageId(Integer garbageId) {
        this.garbageId = garbageId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
