package com.nit.ssm.dto;

public class OpResultDTO {

    //该对象添加一个code字段
    private Integer intResult;
    private Object objResult;
    private String strResult;
    private Integer code;


    public OpResultDTO() {
        this.intResult = 0;
        this.code = 200;
    }

    public OpResultDTO(Integer intResult, Object objResult, String strResult, Integer code) {
        this.intResult = intResult;
        this.objResult = objResult;
        this.strResult = strResult;
        this.code = code;
    }

    public Integer getIntResult() {
        return intResult;
    }

    public void setIntResult(Integer intResult) {
        this.intResult = intResult;
    }

    public Object getObjResult() {
        return objResult;
    }

    public void setObjResult(Object objResult) {
        this.objResult = objResult;
    }

    public String getStrResult() {
        return strResult;
    }

    public void setStrResult(String strResult) {
        this.strResult = strResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "OpResultDTO{" +
                "intResult=" + intResult +
                ", objResult=" + objResult +
                ", strResult='" + strResult + '\'' +
                ", code=" + code +
                '}';
    }
}
