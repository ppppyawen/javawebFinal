package com.nit.ssm.dto;

public class ExamTableReqDTO {
    private Integer pageSize;
    private Integer currentPage;
    private Integer userId;
    private String examSn;

    public ExamTableReqDTO() {
    }

    public ExamTableReqDTO(Integer pageSize, Integer currentPage, Integer userId, String examSn) {
        this.pageSize = pageSize == null ? 5 : pageSize;
        this.currentPage =  currentPage == null ? 1 : currentPage;
        this.userId = userId;
        this.examSn = examSn;
    }

    public String getExamSn() {
        return examSn;
    }

    public void setExamSn(String examSn) {
        this.examSn = examSn;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //根据pageSize和currentPage计算起始条数用户表格查询
    public Integer getStart() {
        return (this.currentPage - 1) * this.pageSize;
    }

    @Override
    public String toString() {
        return "ExamTableReqDTO{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }

}

