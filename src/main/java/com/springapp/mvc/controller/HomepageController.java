package com.springapp.mvc.controller;

import com.springapp.mvc.service.mainpage.MainpageService;
import com.springapp.mvc.util.RequestFactory;
import com.springapp.mvc.util.StringRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/2/14 0014.
 */
@Controller
@RequestMapping(value = "/mainPage")
public class HomepageController {
    @Autowired
    private MainpageService mainpageService;

    @Autowired
    private RequestFactory Factory;

    /**
     * 跳转到主页
     * @return
     */
    @RequestMapping(value="/mainpage",method = RequestMethod.GET)
    public String mainpage(){
        return "mainpage";
    }
    /**
     * 更新主页轮播图片
     */
    @RequestMapping(value ="/updatemainpagepic",method = RequestMethod.GET)
    public String updatemianpagepic(@RequestParam("mainpagepicurl")String mainpagepicsurl,@RequestParam("key")int key){
        if(checkSession()){
            return "admin/adminLog";
        }else{
            StringRule stringRule=null;
            String mainpagepics=mainpageService.getHomepageimg();
            stringRule.manyToOneStr(mainpagepics, mainpagepicsurl, key);
            return "mainpage";
        }
    }

    /**
     * 更新主页id
     * @param courseid
     * @param key
     * @return
     */
    @RequestMapping(value="/updatecourseids",method = RequestMethod.GET)
    public String updatecourseids(@RequestParam("courseid")String courseid,@RequestParam("key")int key){
        if(checkSession()){
            return "admin/adminLog";
        }else {
            StringRule stringRule=null;
            String courseids=mainpageService.getCourseid();
            stringRule.manyToOneStr(courseids, courseid, key);
            return "mainpage";
        }

    }

    @RequestMapping(value = "/updateserviceids",method = RequestMethod.GET)
    public String updateserviceids(@RequestParam("serviceid")String serviceid,@RequestParam("key")int key){
        if(checkSession())
            return "admin/adminLog";
        else{
            StringRule stringRule=null;
            String servicedids=mainpageService.getServiceid();
            stringRule.manyToOneStr(servicedids, serviceid, key);
            return "mainpage";
        }
    }

    public boolean checkSession() {
        String admin = (String) Factory.getRequest().getSession().getAttribute("adminaccount");
        if (admin == null) {
            return true;
        } else return false;
    }

}
