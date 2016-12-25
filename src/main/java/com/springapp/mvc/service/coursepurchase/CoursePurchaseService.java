package com.springapp.mvc.service.coursepurchase;

import com.springapp.mvc.pojo.CoursePurchase;

import java.util.List;

/**
 * Created by Administrator on 2016/2/27 0027.
 */
public interface CoursePurchaseService {
    public boolean  addNewCoursePurchase(CoursePurchase coursePurchase);             //新增课程交易记录
    public boolean  deleteCoursePurchaseByOrderId(String orderid);                        //通过订单号删除购买记录
    public List<CoursePurchase> getCoursePurchaseListByUserId(int userid);             //获取用户所有交易信息
    public List<CoursePurchase> getCoursePurchaseListNyCourseId(int courseid);        //获取课程所有交易信息
    public List<CoursePurchase> getCoursePurchaseListByLecturerId(int lecturerid);   //获取所有讲师的订单信息
}
