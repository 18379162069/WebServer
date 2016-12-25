package com.springapp.mvc.pojo;

public class MainPage {
    private Integer id;

    private String companydescription;

    private String companyname;

    private String courseids;

    private String coursepics;

    private String serviceids;

    private String servicepics;

    private String homepageimgs;

    private String cooperation;

    private String cooperationpics;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanydescription() {
        return companydescription;
    }

    public void setCompanydescription(String companydescription) {
        this.companydescription = companydescription == null ? null : companydescription.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCourseids() {
        return courseids;
    }

    public void setCourseids(String courseids) {
        this.courseids = courseids == null ? null : courseids.trim();
    }

    public String getCoursepics() {
        return coursepics;
    }

    public void setCoursepics(String coursepics) {
        this.coursepics = coursepics == null ? null : coursepics.trim();
    }

    public String getServiceids() {
        return serviceids;
    }

    public void setServiceids(String serviceids) {
        this.serviceids = serviceids == null ? null : serviceids.trim();
    }

    public String getServicepics() {
        return servicepics;
    }

    public void setServicepics(String servicepics) {
        this.servicepics = servicepics == null ? null : servicepics.trim();
    }

    public String getHomepageimgs() {
        return homepageimgs;
    }

    public void setHomepageimgs(String homepageimgs) {
        this.homepageimgs = homepageimgs == null ? null : homepageimgs.trim();
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation == null ? null : cooperation.trim();
    }

    public String getCooperationpics() {
        return cooperationpics;
    }

    public void setCooperationpics(String cooperationpics) {
        this.cooperationpics = cooperationpics == null ? null : cooperationpics.trim();
    }
}