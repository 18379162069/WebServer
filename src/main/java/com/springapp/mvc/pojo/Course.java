package com.springapp.mvc.pojo;

public class Course {
    private Integer id;

    private Integer type1id;

    private Integer type2id;

    private Integer type3id;

    private String coursename;

    private String coursepic;

    private Integer courseprice;

    private String coursedescription;

    private String coursecontent;

    private String coursemode;

    private String courselecturer;

    private String lectureremail;

    private String coursetime;

    private String signup;

    private String courseperiod;

    private Integer coursetakes;

    private Integer courseincomecount;

    private String coursecheck;

    private Integer coursemaxstu;

    private String coursedoc;

    private String coursedocstate;

    public String getCoursedoc() {
        return coursedoc;
    }

    public void setCoursedoc(String coursedoc) {
        this.coursedoc = coursedoc;
    }

    public String getCoursedocstate() {
        return coursedocstate;
    }

    public void setCoursedocstate(String coursedocstate) {
        this.coursedocstate = coursedocstate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType1id() {
        return type1id;
    }

    public void setType1id(Integer type1id) {
        this.type1id = type1id;
    }

    public Integer getType2id() {
        return type2id;
    }

    public void setType2id(Integer type2id) {
        this.type2id = type2id;
    }

    public Integer getType3id() {
        return type3id;
    }

    public void setType3id(Integer type3id) {
        this.type3id = type3id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getCoursepic() {
        return coursepic;
    }

    public void setCoursepic(String coursepic) {
        this.coursepic = coursepic == null ? null : coursepic.trim();
    }

    public Integer getCourseprice() {
        return courseprice;
    }

    public void setCourseprice(Integer courseprice) {
        this.courseprice = courseprice;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription == null ? null : coursedescription.trim();
    }

    public String getCoursecontent() {
        return coursecontent;
    }

    public void setCoursecontent(String coursecontent) {
        this.coursecontent = coursecontent == null ? null : coursecontent.trim();
    }

    public String getCoursemode() {
        return coursemode;
    }

    public void setCoursemode(String coursemode) {
        this.coursemode = coursemode == null ? null : coursemode.trim();
    }

    public String getCourselecturer() {
        return courselecturer;
    }

    public void setCourselecturer(String courselecturer) {
        this.courselecturer = courselecturer == null ? null : courselecturer.trim();
    }

    public String getLectureremail() {
        return lectureremail;
    }

    public void setLectureremail(String lectureremail) {
        this.lectureremail = lectureremail == null ? null : lectureremail.trim();
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime == null ? null : coursetime.trim();
    }

    public String getSignup() {
        return signup;
    }

    public void setSignup(String signup) {
        this.signup = signup == null ? null : signup.trim();
    }

    public String getCourseperiod() {
        return courseperiod;
    }

    public void setCourseperiod(String courseperiod) {
        this.courseperiod = courseperiod == null ? null : courseperiod.trim();
    }

    public Integer getCoursetakes() {
        return coursetakes;
    }

    public void setCoursetakes(Integer coursetakes) {
        this.coursetakes = coursetakes;
    }

    public Integer getCourseincomecount() {
        return courseincomecount;
    }

    public void setCourseincomecount(Integer courseincomecount) {
        this.courseincomecount = courseincomecount;
    }

    public String getCoursecheck() {
        return coursecheck;
    }

    public void setCoursecheck(String coursecheck) {
        this.coursecheck = coursecheck == null ? null : coursecheck.trim();
    }

    public Integer getCoursemaxstu() {
        return coursemaxstu;
    }

    public void setCoursemaxstu(Integer coursemaxstu) {
        this.coursemaxstu = coursemaxstu;
    }
}