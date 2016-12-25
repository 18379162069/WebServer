package com.springapp.mvc.dao.superadmin;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
public interface SuperAdminDao {
    public int superAdminCheck(String superadminaccount, String superadminpassword);   //匹配超级管理员
}
