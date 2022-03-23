package com.nit.ssm.entity;

public class GarbageEntity {
    private Integer garbageId;
    private String garbageName;
    private String imageUrl;
    private Integer sortId;
    private String createTime;

    public GarbageEntity(){

    }

    public GarbageEntity(Integer garbageId, String garbageName, String imageUrl, Integer sortId, String createTime) {
        this.garbageId = garbageId;
        this.garbageName = garbageName;
        this.imageUrl = imageUrl;
        this.sortId = sortId;
        this.createTime = createTime;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}