package com.springapp.mvc.pojo;

public class CoursePurchase {
    private Integer id;

    private Integer courseid;

    private Integer userid;

    private Integer lecturerid;

    private String purchasetime;

    private String purchaseprice;

    private String starttime;

    private String orderid;

    private String orderstate;

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getLecturerid() {
        return lecturerid;
    }

    public void setLecturerid(Integer lecturerid) {
        this.lecturerid = lecturerid;
    }

    public String getPurchasetime() {
        return purchasetime;
    }

    public void setPurchasetime(String purchasetime) {
        this.purchasetime = purchasetime == null ? null : purchasetime.trim();
    }

    public String getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(String purchaseprice) {
        this.purchaseprice = purchaseprice == null ? null : purchaseprice.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }
}