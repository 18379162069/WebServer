package com.springapp.mvc.dao.user_news;

import com.springapp.mvc.pojo.User_News;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
public interface User_NewsDao {
    public int  inserteU_NNexus(int userid, int newsid);        //插入用户与新闻关系
    public int  deleteU_NNexus(int userid, int newsid);          //删除用户与新闻关系
    public List<User_News> getListByUserId(int userid);         //获取用户的所有新闻
    public List<User_News> getListByNewsid(int newsid);     //获取新闻的所有用户
}
