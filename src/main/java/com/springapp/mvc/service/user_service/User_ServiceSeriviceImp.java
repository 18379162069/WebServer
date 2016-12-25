package com.springapp.mvc.service.user_service;

import com.springapp.mvc.dao.user_service.User_ServiceDao;
import com.springapp.mvc.pojo.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/6 0006.
 */
@Service(value = "user_serviceService")
@Transactional
public class User_ServiceSeriviceImp implements User_ServiceService {
    @Autowired
    User_ServiceDao user_serviceDao;

    @Override
    public boolean inserteU_SNexus(int userid, int serviceid) {
        if (!checkUserService(userid, serviceid)) {
            if (user_serviceDao.inserteU_SNexus(userid, serviceid) > 0)
                return true;
            else
                return false;
        }else
            return false;
    }

    @Override
    public boolean deleteU_SNexus(int userid, int serviceid) {
        if (user_serviceDao.deleteU_SNexus(userid, serviceid) > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<User_Service> getListByUserId(int userid) {
        if (user_serviceDao.getListByUserId(userid) != null)
            return user_serviceDao.getListByUserId(userid);
        else
            return null;
    }

    @Override
    public List<User_Service> getListByCourseid(int serviceid) {
        if (user_serviceDao.getListByCourseid(serviceid) != null)
            return user_serviceDao.getListByCourseid(serviceid);
        else
            return null;
    }

    @Override
    public boolean checkUserService(int userid, int serviceid) {
        List<User_Service> user_services = new ArrayList<User_Service>();
        user_services = this.getListByUserId(userid);
        for (int i = 0; i < user_services.size(); i++) {
            if (user_services.get(i).getServiceid() == serviceid)
                return true;
        }
        return false;
    }
}
