package com.springapp.mvc.service.lecturer;

import com.springapp.mvc.pojo.Lecturer;

import java.util.List;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
public interface LecturerService {
    public boolean insertLecturer(Lecturer lecturer);                      //增加讲师
    public boolean deleteLecturerById(int id);                             //通过id删除讲师
    public Lecturer searchLecturerByid(int id);                         //通过id查找讲师
    public List<Lecturer> searchLecturerByName(String lecturename);     //通过名称搜索讲师
    public List<Lecturer> searchLecturerByTel(String lecturetel);       //通过教师手机搜索讲师
    public boolean     getLecturerCourseIds(int id);                          //通过id获得课程id
    public boolean     updateLecturerCourseId(int id,String courseids);       //更新讲师课程id
    public boolean     updatelecturer(Lecturer lecturer);                      //更新讲师信息
    public boolean     changeLecturerCheck(int id);               //通过审核状态
    public  boolean     changeCourseCheck(int id);               //通过审核状态
    public boolean notAgrCourseCheck(int id);        //不通过

    public boolean     updatelecturerbyaccount(Lecturer lecturer);                      //根据账号更新讲师信息
    public boolean     updatelecturerbyid(Lecturer lecturer);                         //根据id更新讲师信息
    public Lecturer    searchLecturerbyAccount(String account);        //通过账号查找讲师
    public boolean    matchingLecture(String account,String password);     //匹配讲师用户
    public boolean    registerLecturer(String account,String password);    //注册讲师并且插入新讲师
    public boolean matchingLecturerAccount(String account);                    //检测账号
    public boolean checklecturertel(String lecturertel);                     //检测重复号码
    public boolean checklectureremail(String lectureremail);                   //检测重复邮箱
    public String getLecturerByCourseEmail(String email);
    public boolean updatechecklectureremail(int lecturerid,String lectureremail); //更新信息时邮箱重复检测



    public boolean insertServiceType(String type1Name,String type2Name);
}
