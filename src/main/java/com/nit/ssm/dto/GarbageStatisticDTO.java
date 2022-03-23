package com.nit.ssm.dto;

/**
 * TODO
 *
 * @author pyw
 * @version 1.0
 * @Description

 */
public class GarbageStatisticDTO {
    private Integer garbage_id;
    private Integer sortId;
    private String garbageName;
    private String sortInfo;
    private String sortName;
    private Integer rightCount;
    private Integer count;

    public GarbageStatisticDTO() {
    }

    public GarbageStatisticDTO(Integer garbage_id, Integer sortId, String garbageName, String sortInfo, String sortName, Integer rightCount, Integer count) {
        this.garbage_id = garbage_id;
        this.sortId = sortId;
        this.garbageName = garbageName;
        this.sortInfo = sortInfo;
        this.sortName = sortName;
        this.rightCount = rightCount;
        this.count = count;
    }

    public Integer getGarbage_id() {
        return garbage_id;
    }

    public void setGarbage_id(Integer garbage_id) {
        this.garbage_id = garbage_id;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public String getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(String sortInfo) {
        this.sortInfo = sortInfo;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public Integer getRightCount() {
        return rightCount;
    }

    public void setRightCount(Integer rightCount) {
        this.rightCount = rightCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GarbageStatisticDTO{" +
                "garbage_id=" + garbage_id +
                ", sortId=" + sortId +
                ", garbageName='" + garbageName + '\'' +
                ", sortInfo='" + sortInfo + '\'' +
                ", sortName='" + sortName + '\'' +
                ", rightCount=" + rightCount +
                ", count=" + count +
                '}';
    }
}
