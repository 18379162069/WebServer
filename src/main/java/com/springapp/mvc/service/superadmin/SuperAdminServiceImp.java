package com.springapp.mvc.service.superadmin;

import com.springapp.mvc.dao.superadmin.SuperAdminDao;
import com.springapp.mvc.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
@org.springframework.stereotype.Service(value = "superadminService")
@Transactional
public class SuperAdminServiceImp implements SuperAdminService {
    @Autowired
    SuperAdminDao superAdminDao;
    @Override
    public boolean superAdminCheck(String superadminaccount, String superadminpassword) {
        superadminpassword= MD5Util.MD5(superadminpassword);
        if(superAdminDao.superAdminCheck(superadminaccount,superadminpassword)>0)
            return true;
        else
            return false;
    }
}
