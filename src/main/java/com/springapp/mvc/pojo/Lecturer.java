package com.springapp.mvc.pojo;

public class Lecturer {
    private Integer id;

    private Integer courseid;

    private String lecturername;

    private Integer lecturerrank;

    private String lecturertel;

    public String getLecturertel() {
        return lecturertel;
    }

    public void setLecturertel(String lecturertel) {
        this.lecturertel = lecturertel;
    }

    private String lecturercompany;

    private String lectureremail;

    private String lecturerdescription;

    private String lecturersex;

    private Integer lecturerage;

    private String lecturercheck;

    public String getLecturercheck() {
        return lecturercheck;
    }

    public void setLecturercheck(String lecturercheck) {
        this.lecturercheck = lecturercheck;
    }

    private String lecturerlastlogin;

    private String lectureraccount;

    private String lecturerpassword;

    private String lecturerapplreason;

    public String getLecturerapplreason() {
        return lecturerapplreason;
    }

    public void setLecturerapplreason(String lecturerapplreason) {
        this.lecturerapplreason = lecturerapplreason;
    }
    public String getLectureraccount() {
        return lectureraccount;
    }

    public void setLectureraccount(String lectureraccount) {
        this.lectureraccount = lectureraccount;
    }

    public String getLecturerpassword() {
        return lecturerpassword;
    }

    public void setLecturerpassword(String lecturerpassword) {
        this.lecturerpassword = lecturerpassword;
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

    public String getLecturername() {
        return lecturername;
    }

    public void setLecturername(String lecturername) {
        this.lecturername = lecturername == null ? null : lecturername.trim();
    }

    public Integer getLecturerrank() {
        return lecturerrank;
    }

    public void setLecturerrank(Integer lecturerrank) {
        this.lecturerrank = lecturerrank;
    }

    public String getLecturercompany() {
        return lecturercompany;
    }

    public void setLecturercompany(String lecturercompany) {
        this.lecturercompany = lecturercompany == null ? null : lecturercompany.trim();
    }

    public String getLectureremail() {
        return lectureremail;
    }

    public void setLectureremail(String lectureremail) {
        this.lectureremail = lectureremail == null ? null : lectureremail.trim();
    }

    public String getLecturerdescription() {
        return lecturerdescription;
    }

    public void setLecturerdescription(String lecturerdescription) {
        this.lecturerdescription = lecturerdescription == null ? null : lecturerdescription.trim();
    }

    public String getLecturersex() {
        return lecturersex;
    }

    public void setLecturersex(String lecturersex) {
        this.lecturersex = lecturersex == null ? null : lecturersex.trim();
    }

    public Integer getLecturerage() {
        return lecturerage;
    }

    public void setLecturerage(Integer lecturerage) {
        this.lecturerage = lecturerage;
    }

    public String getLecturerlastlogin() {
        return lecturerlastlogin;
    }

    public void setLecturerlastlogin(String lecturerlastlogin) {
        this.lecturerlastlogin = lecturerlastlogin == null ? null : lecturerlastlogin.trim();
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", lecturername='" + lecturername + '\'' +
                ", lecturerrank=" + lecturerrank +
                ", lecturertel='" + lecturertel + '\'' +
                ", lecturercompany='" + lecturercompany + '\'' +
                ", lectureremail='" + lectureremail + '\'' +
                ", lecturerdescription='" + lecturerdescription + '\'' +
                ", lecturersex='" + lecturersex + '\'' +
                ", lecturerage=" + lecturerage +
                ", lecturercheck='" + lecturercheck + '\'' +
                ", lecturerlastlogin='" + lecturerlastlogin + '\'' +
                ", lectureraccount='" + lectureraccount + '\'' +
                ", lecturerpassword='" + lecturerpassword + '\'' +
                ", lecturerapplreason='" + lecturerapplreason + '\'' +
                '}';
    }
}