package com.springapp.mvc.util;

import com.springapp.mvc.dao.companyuser.CompanyUserDao;
import com.springapp.mvc.service.companyuser.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by louie on 2016/1/20.
 */
@Service
public class RequestFactory {

    @Autowired
    private CompanyUserDao companyUserDao;

    public HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public Integer getMyIdFromSession(String userType){
        if(userType.equals("companyuser")){
            String account = (String) getRequest().getSession().getAttribute("companyuser");
            Integer id = companyUserDao.getIdByAc(account);
            return id;
        }
        else{
            String account = (String) getRequest().getSession().getAttribute("companyuser");
            Integer id = companyUserDao.getIdByAc(account);
            return id;
        }
    }
}
