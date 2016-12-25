package com.springapp.mvc.service.user_course;

import com.springapp.mvc.dao.user_course.User_CourseDao;
import com.springapp.mvc.pojo.User_Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/26 0026.
 */
@Service(value = "user_courseService")
@Transactional
public class User_CourseServiceImp implements  User_CourseService {
    @Autowired
    User_CourseDao user_courseDao;
    @Override
    public boolean insertU_CNexus(int userid, int courseid) {
        if(user_courseDao.insertU_CNexus(userid,courseid)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteU_CNexus(int userid, int courseid) {
        if(user_courseDao.deleteU_CNexus(userid,courseid)>0)
            return true;
        else
            return false;
    }

    @Override
    public List<User_Course> getU_CListByuserid(int userid) {
        return user_courseDao.getU_CListByuserid(userid);
    }

    @Override
    public List<User_Course> getU_CListBycourseid(int courseid) {
        return user_courseDao.getU_CListBycourseid(courseid);
    }

    @Override
    public boolean checkUserCourse(int userid, int courseid) {
        List<User_Course> user_courses=new ArrayList<User_Course>();
        user_courses=user_courseDao.getU_CListByuserid(userid);
        for(int i=0;i<user_courses.size();i++){
            if(user_courses.get(i).getCourseid()==courseid)
                return true;
        }
        return false;
    }
}
