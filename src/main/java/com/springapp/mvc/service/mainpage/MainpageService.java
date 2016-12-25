package com.springapp.mvc.service.mainpage;

import com.springapp.mvc.pojo.MainPage;

/**
 * Created by Administrator on 2016/2/13 0013.
 */
public interface MainpageService {
    public boolean  insertMainpageinfo(MainPage mainPage);                    //插入主页公司信息
    public boolean     updateMainPageInfo(MainPage mainPage);               //更新主页内容
    public boolean     updateCourseid(String courseids);                    //更新课程id
    public boolean     updateServiceid(String serviceids);                  //更新业务id
    public boolean     updateCoursepic(String coursepic);                   //更新课程图片
    public boolean     updateServicepic(String servicepics);                 //更新业务图片
    public boolean     updateHomepageimg(String homepageimgs);               //更新主页轮播图片
    public boolean     updateCooperation(String cooperations);               //更新合作伙伴
    public boolean     updateCooperationpic(String cpicurls);                //更新合作伙伴图片
    public MainPage    getMainpageinfo();                                        //获得主页信息
    public String    getCourseid();                                        //获得课程ids
    public String    getServiceid();                                        //获得业务ids
    public String    getCoursepic();                                        //获得课程图片url
    public String    getServicepic();                                        //获得业务图片url
    public String    getHomepageimg();                                        //获得主页轮播图片url
    public String    getCooperation();                                        //获得合作伙伴
    public String    Cooperationpic();                                        //获得合作伙伴图片

}
