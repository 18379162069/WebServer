package com.springapp.mvc.service.user;

import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.User;

import java.util.List;

/**
 * Created by louie on 2016/2/1.
 */
public interface UserService {

        public boolean insertUser(User user);                  //增加用户
        public boolean deleteUserbyemial(String useremail);    //根据用户邮箱删除用户
        public boolean deleteUserbytel(String usertel);        //根据用户电话删除用户
        public User searchUserbyemail(String usereamil);    //根据用户邮箱查找用户、
        public User searchUserbytel(String usertel);        //根据用户电话查找用户
        public boolean updateUser(User user);                  //更新用户信息
        public int getUsernum();                           //获得所有用户数
        public boolean loginUserbyemail(User user);               //用户通过邮箱登录
        public boolean loginUserbytel(User user);               //用户通过手机登录
        public List<User> getAllUser();                          //得到所有用户信息
        public User getUserById(int id);                          //得到所有用户信息
        public boolean useraccountcheck(String username);                    //检测用户名是否存在
        public boolean usertelCheck(String usertel);             //用户手机号重复检测
        public List<Course> getUserAllCourse(int userid);          //获取用户已选的课程
        public boolean updateuseremailcheck(int userid,String useremail);  //更新用户邮箱 邮箱重复检测


















        //------------------------------------------------------------
        public boolean userTelCheck(String usertel);                   //检测手机号是否存在
        public boolean userEmailcheck(String email);                    //检测邮箱是否存在
        public void addService(String subject,String content);          //添加需求

}
