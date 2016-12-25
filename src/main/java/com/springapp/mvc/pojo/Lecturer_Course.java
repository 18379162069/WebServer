package com.springapp.mvc.pojo;

public class Lecturer_Course {
    private Integer id;

    private Integer lecturerid;

    private Integer courseid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLecturerid() {
        return lecturerid;
    }

    public void setLecturerid(Integer lecturerid) {
        this.lecturerid = lecturerid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }
}