package com.springapp.mvc.service.superadmin;

import com.springapp.mvc.pojo.Admin;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
public interface SuperAdminService {
    public boolean superAdminCheck(String superadminaccount, String superadminpassword);   //匹配超级管理员
}
