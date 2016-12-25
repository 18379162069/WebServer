package com.springapp.mvc.dao.user_course;

import com.springapp.mvc.pojo.User_Course;

import java.util.List;

/**
 * Created by Administrator on 2016/2/26 0026.
 */
public interface User_CourseDao {
    public int insertU_CNexus(int userid, int courseid);   // 新增用户和课程联系
    public int deleteU_CNexus(int userid, int courseid);                 //删除用户课程
    public List<User_Course> getU_CListByuserid(int userid);           //获取学生的所有课程
    public List<User_Course> getU_CListBycourseid(int courseid);           //获取课程所有学生
}
