package com.bccoder.mybatis.protocol.req;

public class UserReq {
    //如果查询单条 不必传递
    //当前页
    private int currPage;
    //每页多少数据
    private int pageCount;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
