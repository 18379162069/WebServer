package com.springapp.mvc.service.lecturer_course;

import com.springapp.mvc.pojo.Lecturer;
import com.springapp.mvc.pojo.Lecturer_Course;

import java.util.List;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
public interface Lecturer_CourseService {
    public boolean addL_CNexus(int lecturerid, int serviceid);            //添加教师与课程的联系
    public boolean deleteL_CNexus(int id);                                //通过id删除关系信息
    public List<Lecturer_Course> getL_CNexusbyLecturerid(int lecturerid);  //通过讲师id获取课程
    public int getLecturerByCourseid(int courseid);                  //通过课程id得到讲师信息
    public boolean deleteCourseByCourseid(int courseid);                 //通过课程id删除L_C表关系

}
