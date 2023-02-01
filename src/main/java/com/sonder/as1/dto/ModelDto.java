package com.sonder.as1.dto;

import java.util.Collection;

public class ModelDto<T>{
    private String status;
    private String note;
    private Collection<T> data;
    private Integer page;
    private Integer size;
    private Integer totalPage;

    public ModelDto() {
    }

    public ModelDto(String status, String note, Collection<T> data, Integer page, Integer size, Integer totalPage) {
        this.status = status;
        this.note = note;
        this.data = data;
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
