package com.sonder.as1.entity;

import java.util.Collection;

public class PageC<T> {
    private int size;
    private int page;
    private int totalPage;
    private Collection<T> ts;

    public PageC() {
    }

    public PageC(int size, int page, int totalPage, Collection<T> ts) {
        this.size = size;
        this.page = page;
        this.totalPage = totalPage;
        this.ts = ts;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Collection<T> getTs() {
        return ts;
    }

    public void setTs(Collection<T> ts) {
        this.ts = ts;
    }
}
