package com.springapp.mvc.dao.user_service;

import com.springapp.mvc.pojo.User_Service;

import java.util.List;

/**
 * Created by Administrator on 2016/3/6 0006.
 */
public interface User_ServiceDao {
    public int  inserteU_SNexus(int userid, int serviceid);        //插入用户与业务关系
    public int  deleteU_SNexus(int userid, int serviceid);          //删除用户与业务关系
    public List<User_Service> getListByUserId(int userid);         //获取用户的所有业务id
    public List<User_Service> getListByCourseid(int courseid);     //获取业务的所有用户
}
