package com.springapp.mvc.service.coursepurchase;

import com.springapp.mvc.dao.coursepurchase.CoursePurchaseDao;
import com.springapp.mvc.pojo.CoursePurchase;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;


/**
 * Created by Administrator on 2016/2/27 0027.
 */
@org.springframework.stereotype.Service(value = "coursepurchaseService")
@Transactional
public class CoursePurchaseServiceImp implements CoursePurchaseService {
    @Resource
    CoursePurchaseDao coursePurchaseDao;

    @Override
    public boolean addNewCoursePurchase(CoursePurchase coursePurchase) {
        if (coursePurchaseDao.addNewCoursePurchase(coursePurchase) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteCoursePurchaseByOrderId(String orderid) {
        if (coursePurchaseDao.deleteCoursePurchaseByOrderId(orderid) > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<CoursePurchase> getCoursePurchaseListByUserId(int userid) {

        if (coursePurchaseDao.getCoursePurchaseListByUserId(userid) != null)
            return coursePurchaseDao.getCoursePurchaseListByUserId(userid);
        else
            return null;
    }

    @Override
    public List<CoursePurchase> getCoursePurchaseListNyCourseId(int courseid) {
        if (coursePurchaseDao.getCoursePurchaseListNyCourseId(courseid) != null)
            return coursePurchaseDao.getCoursePurchaseListNyCourseId(courseid);
        else
            return null;
    }

    @Override
    public List<CoursePurchase> getCoursePurchaseListByLecturerId(int lecturerid) {
        if (coursePurchaseDao.getCoursePurchaseListByLecturerId(lecturerid) != null)
            return coursePurchaseDao.getCoursePurchaseListByLecturerId(lecturerid);
        else
            return null;
    }
}
