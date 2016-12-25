package com.springapp.mvc.dao.user;

import com.springapp.mvc.pojo.User;

import java.util.List;

/**
 * Created by louie on 2016/2/1.
 */
public interface UserDao {

    public int insertUser(User user);                  //增加用户
    public int deleteUserbyemial(String useremail);    //根据用户邮箱删除用户
    public int deleteUserbytel(String usertel);        //根据用户电话删除用户
    public User searchUserbyemail(String usereamil);    //根据用户邮箱查找用户、
    public User searchUserbytel(String usertel);        //根据用户电话查找用户
    public int usernamecheck(String username);         //根据用户名检测用户
    public int updateUser(User user);                  //更新用户信息
    public int getUsernum();                           //获得所有用户数
    public int userMatchingbyemail(User user);      //根据用户邮箱匹配
    public int userMatchingbytel(User user);         //根据用d电话匹配
    public List<User> getAllUser();                  //获取所有用户信息
    public int usertelCheck(String usertel);           //用户手机号重复检测
    public User getUserById(int id);
    public int updateuseremailcheck(int userid,String useremail);//用户更新邮箱 邮箱重复验证




    //-----------------------------------
    public User getUserByTel(String tel);
    public User getUserByEmail(String email);

    public void addService(String name,String email,String phone,String subject,String content);

}
