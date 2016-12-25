package com.springapp.mvc.dao.lecturer;

import com.springapp.mvc.pojo.Lecturer;

import java.util.List;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
public interface LecturerDao {
    public int insertLecturer(Lecturer lecturer);                      //增加讲师
    public int deleteLecturerById(int id);                             //通过id删除讲师
    public Lecturer searchLecturerByid(int id);                         //通过id查找讲师
    public List<Lecturer> searchLecturerByName(String lecturename);     //通过名称搜索讲师
    public List<Lecturer> searchLecturerByTel(String lecturetel);       //通过教师手机搜索讲师
    public int  getLecturerCourseIds(int id);                          //通过id获得课程id
    public int     updateLecturerCourseId(int id,String courseids);       //更新讲师课程id
    public int     updatelecturer(Lecturer lecturer);                      //更新讲师信息
    public int     changeLecturerCheck(int id);               //修改审核状态
    public int changeCourseCheck(int id);        //通过课程审核状态

    public int notAgrCourseCheck(int id);     //不通过

    public Lecturer searchLecturerByAccount(String account);            //通过讲师账号查找讲师
    public int     updatelecturerbyid(Lecturer lecturer);                      //更新讲师信息
    public Integer     updatelecturerbyaccount(String account);                      //根据账号更新讲师信息
    public int matchingLecturerbyaccount(String account,String password); //匹配讲师
    public int matchingLecturerAccount(String account);                    //检测账号
    public int lecturertelcheck(String lecturertel);                           //检测手机号嘛是否重复
    public int lectureremailcheck(String lectureremail);                       //讲师邮箱重复检测
    public String getLecturerByCourseEmail(String email);               //教师email取教师
    public int updatelectureremailcheck(int lecturerid,String lectureremail);        //更新讲师信息时邮箱重复检测






    public Integer get2IdByTypeName(String type2Name);
    public void insertCourseType(String type1Name,String type2Name);
}
