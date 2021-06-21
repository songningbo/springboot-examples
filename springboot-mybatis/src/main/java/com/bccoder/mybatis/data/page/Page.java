package com.bccoder.mybatis.data.page;

import java.io.Serializable;
import java.util.ArrayList;

public class Page implements Serializable {
    private Object data;//当前页存放的数据，类型一般为list
    private int currentPage =1; //当前是第几页，从1开始记数
    private int pageSize =10;//每页多少条
    private long totalCount;//总记录数
    private int totalPage;//总页数
    private Object fotter;//显示脚本统计
    //开始记录
    public int getPageStart(){
        return (currentPage - 1) * pageSize;
    }

    //结束记录
    public int getPageEnd(){
        return currentPage * pageSize;
    }

    /**
     * 构造方法，只构造空页.
     */
    @SuppressWarnings("rawtypes")
    public Page() {
        this(0, new ArrayList());
    }

    /**
     * 默认构造方法.
     *
     * @param totalSize
     *            数据库中总记录条数
     * @param data
     *            本页包含的数据
     *
     */
    public Page(long totalCount, Object data) {
        this.totalCount = totalCount;
        this.data = data;
    }

    /**
     * 取总记录数.
     */
    public long getTotalCount() {
        return this.totalCount;
    }

    /** 设置总记录数 */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 取当前页中的记录.
     */
    public Object getResult() {
        return data;
    }

    /**
     * 取当前页中的记录.
     */
    public Object getData() {
        return data;
    }

    public Object getFotter() {
        return fotter;
    }

    public void setFotter(Object fotter) {
        this.fotter = fotter;
    }

    /**
     * 设置当前页中的记录.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /** 设置当前页数 */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /** 取当前页数 */
    public int getCurrentPage() {
        return currentPage;
    }

    /** 设置每页记录条数 */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /** 取每页记录条数 */
    public int getPageSize() {
        return pageSize;
    }

    /** 设置总页数 */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 取总页数
     * <p>
     * 由总条数和每页的条数计算
     */
    public int getTotalPage() {
        if (totalCount == 0) {
            totalPage = 0;
        } else {
            totalPage = ((int) totalCount / pageSize);
            totalPage += ((totalCount % pageSize) > 0) ? 1 : 0;
        }
        return totalPage;
    }
}
