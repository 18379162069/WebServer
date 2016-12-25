package com.springapp.mvc.service.mainpage;

import com.springapp.mvc.dao.mainpage.MainpageDao;
import com.springapp.mvc.pojo.MainPage;
import com.springapp.mvc.util.StringRule;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/2/13 0013.
 */
@org.springframework.stereotype.Service(value = "mainpageService")
@Transactional
public class MainpageServiceImp implements MainpageService {
    @Resource
    private MainpageDao mainpageDao;
    @Override
    public boolean insertMainpageinfo(MainPage mainPage) {
        if(mainpageDao.insertMainpageInfo(mainPage)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateMainPageInfo(MainPage mainPage) {
        if(mainpageDao.updateMainPageInfo(mainPage)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateCourseid(String courseids) {
        if(mainpageDao.updateCourseid(courseids)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateServiceid(String serviceids) {
        if(mainpageDao.updateServiceid(serviceids)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateCoursepic(String coursepic) {
        if(mainpageDao.updateCoursepic(coursepic)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateServicepic(String servicepics) {
        if(mainpageDao.updateServicepic(servicepics)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateHomepageimg(String homepageimgs) {
        if(mainpageDao.updateHomepageimg(homepageimgs)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateCooperation(String cooperations) {
        if(mainpageDao.updateCooperation(cooperations)>0){
            return true;
        }else
            return false;
    }

    @Override
    public boolean updateCooperationpic(String cpicurls) {
        if(mainpageDao.updateCooperationpic(cpicurls)>0)
            return true;
        else
            return false;
    }

    @Override
    public MainPage getMainpageinfo() {
        return mainpageDao.getMainpageInfo();
    }

    @Override
    public String getCourseid() {
        return mainpageDao.getCourseids();
    }

    @Override
    public String getServiceid() {
        return mainpageDao.getServiceids();
    }

    @Override
    public String getCoursepic() {
        return mainpageDao.getCoursePics();
    }

    @Override
    public String getServicepic() {
        return mainpageDao.getServicePics();
    }

    @Override
    public String getHomepageimg() {
        return  mainpageDao.getHompageImgs();
    }

    @Override
    public String getCooperation() {
        return mainpageDao.getCooperation();
    }

    @Override
    public String Cooperationpic() {
        return mainpageDao.getCooperationpics();
    }
}
