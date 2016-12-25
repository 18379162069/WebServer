package com.springapp.mvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by louie on 2016/2/18.
 */
@Service
public class RootPath {

    @Autowired
    private RequestFactory Factory;

    public String RootPath(){
        String absoultePath = Factory.getRequest().getSession().getServletContext().getRealPath("/");
        String[] str = absoultePath.split("WebServer");
        return str[0];
    }
}
