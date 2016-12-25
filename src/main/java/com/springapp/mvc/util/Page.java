package com.springapp.mvc.util;

/**
 * Created by louie on 2016/3/6.
 */
public class Page {

    private int pageNum;    //当前页面
    private int pageCount;  //总页面数

    private int preStart;   //前段开始
    private int preEnd;     //前段结束

    private int nextStart;  //后段开始
    private int nextEnd;    //后段结束


    public Page(int pageNum, int pageCount, int preStart, int preEnd, int nextStart, int nextEnd) {
        this.pageNum = pageNum;
        this.pageCount = pageCount;
        this.preStart = preStart;
        this.preEnd = preEnd;
        this.nextStart = nextStart;
        this.nextEnd = nextEnd;
        if((pageCount>10 && pageNum>5)&&(pageCount-pageNum>5)){
            this.preStart = (pageNum-4);
            this.preEnd=(pageNum);
            this.nextStart=(pageNum+1);
            this.nextEnd=(pageNum+5);
        }else if((pageCount>10 && pageNum<=5)&&(pageCount-pageNum>5)){
            this.preStart = 1;
            this.preEnd = pageNum;
            this.nextStart = pageCount-5;
            this.nextEnd = pageCount;
        }else if((pageCount>10 && pageNum>5)&&(pageCount-pageNum<=5)){
            this.preStart = 1;
            this.preEnd = 5;
            this.nextStart = pageNum;
            this.nextEnd = pageCount;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPreStart() {
        return preStart;
    }

    public void setPreStart(int preStart) {
        this.preStart = preStart;
    }

    public int getPreEnd() {
        return preEnd;
    }

    public void setPreEnd(int preEnd) {
        this.preEnd = preEnd;
    }

    public int getNextStart() {
        return nextStart;
    }

    public void setNextStart(int nextStart) {
        this.nextStart = nextStart;
    }

    public int getNextEnd() {
        return nextEnd;
    }

    public void setNextEnd(int nextEnd) {
        this.nextEnd = nextEnd;
    }
}
