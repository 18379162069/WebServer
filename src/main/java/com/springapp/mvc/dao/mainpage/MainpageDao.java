package com.springapp.mvc.dao.mainpage;

import com.springapp.mvc.pojo.MainPage;

/**
 * Created by Administrator on 2016/2/13 0013.
 */
public interface MainpageDao {
    public  int insertMainpageInfo(MainPage mainPage);                   //增加公司首页信息
    public  int insertCourseid(String courseids);                         //推荐课程id增加
    public  int insertServiceid(String serviceids);                       //推荐业务id增加
    public  int insertCoursePic(String cpicurls);                         //课程图片的增加
    public  int insertServicePic(String spicurls);                       //业务课程url的增加
    public  int insertHomepageImg(String hpurls);                        //主页轮播图片url增加
    public  int insertCooperation(String cooperations);                   //增加主页显示合作伙伴
    public  int insertCooperationpic(String cpicurls);                    //增加课程伙伴图片url
    public  MainPage getMainpageInfo();                                 //获取主页信息
    public  String  getCourseids();                                      //获取课程id字符串
    public  String  getServiceids();                                     //获取业务id字符串
    public  String  getCoursePics();                                     //获取课程图片url字符串
    public  String  getServicePics();                                    //获取业务图片url字符串
    public  String  getHompageImgs();                                    //获取主页轮播图片imgeurl
    public  String  getCooperation();                                    //获取合作伙伴
    public  String  getCooperationpics();                                //获取合作伙伴图片url
    public  int     updateMainPageInfo(MainPage mainPage);               //更新主页内容
    public  int     updateCourseid(String courseids);                    //更新课程id
    public  int     updateServiceid(String serviceids);                  //更新业务id
    public  int     updateCoursepic(String coursepic);                   //更新课程图片
    public  int     updateServicepic(String servicepics);                 //更新业务图片
    public  int     updateHomepageimg(String homepageimgs);               //更新主页轮播图片
    public  int     updateCooperation(String cooperations);               //更新合作伙伴
    public  int     updateCooperationpic(String cpicurls);                //更新合作伙伴图片


}
