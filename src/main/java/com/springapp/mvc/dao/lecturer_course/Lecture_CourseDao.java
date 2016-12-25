package com.springapp.mvc.dao.lecturer_course;

import com.springapp.mvc.pojo.Lecturer;
import com.springapp.mvc.pojo.Lecturer_Course;

import java.util.List;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
public interface Lecture_CourseDao {
    public int addL_CNexus(int lecturerid, int courseid);            //添加教师与课程的联系
    public int deleteL_CNexus(int id);                                //通过id删除关系信息
    public List<Lecturer_Course> getL_CNexusbyLecturerid(int lecturerid);  //通过教师id获取课程
    public int getLecturerByCourseid(int courseid);                  //通过课程id得到讲师id
    public int deleteCourseByCourseid(int courseid);                 //通过课程id删除L_C表关系
    // public int changeL_CcheckByid(int lecturerid);                               //通过过教师id修改审核状况
}
