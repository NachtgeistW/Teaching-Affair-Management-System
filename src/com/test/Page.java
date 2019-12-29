package com.test;

import java.util.List;

public class Page<T> {
    //当前是第几页
    private int pageNo;
    //当前页的List
    private List<T> list;

    //每页显示多少条记录
    private int pageSize = 0;

    //共有多少条记录
    private long totalItemNumber;


    //构造器中需要对 pageNo 进行初始化
    public Page(int pageNo) {
        super();
        this.pageNo = pageNo;
    }

    //需要校验一下
    public int getPageNo() {
        if (pageNo < 0)
            pageNo = 1;
        if (getTotalItemNumber() == 0) {
            return 1;
        }
        if (pageNo > getTotalPageNumber()) {
            pageNo = getTotalPageNumber();
        }

        return pageNo;
    }


    public long getTotalItemNumber() {
        return totalItemNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    //获取总页数
    public int getTotalPageNumber() {

        int totalPageNumber = (int) totalItemNumber / pageSize;

        if (totalItemNumber % pageSize != 0) {
            totalPageNumber++;
        }

        return totalPageNumber;
    }

    public void setTotalItemNumber(long totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }

    public boolean isHasNext() {
        return getPageNo() < getTotalPageNumber();
    }

    public boolean isHasPrev() {
        return getPageNo() > 1;
    }

    public int getPrevPage() {
        if (isHasPrev()) {
            return getPageNo() - 1;
        }
        return getPageNo();
    }

    public int getNextPage() {
        if (isHasNext()) {
            return getPageNo() + 1;
        }
        return getPageNo();
    }

}