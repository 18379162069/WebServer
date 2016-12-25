package com.springapp.mvc.service.user;


import com.springapp.mvc.dao.course.CourseDao;
import com.springapp.mvc.dao.user.UserDao;
import com.springapp.mvc.dao.user_course.User_CourseDao;
import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.User;
import com.springapp.mvc.pojo.User_Course;
import com.springapp.mvc.util.MD5Util;
import com.springapp.mvc.util.RequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by louie on 2016/2/1.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;
    @Autowired
    private RequestFactory Factory;
    @Resource
    private User_CourseDao user_courseDao;

    @Resource
    private CourseDao courseDao;


    @Override
    public boolean insertUser(User user) {
        String userpassword = MD5Util.MD5(user.getUserpassword());    //加密用户密码
        user.setUserpassword(userpassword);
        if (userDao.insertUser(user) > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteUserbyemial(String useremail) {
        if (userDao.deleteUserbyemial(useremail) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteUserbytel(String usertel) {
        if (userDao.deleteUserbytel(usertel) > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public User searchUserbyemail(String usereamil) {

        return userDao.searchUserbyemail(usereamil);
    }

    @Override
    public User searchUserbytel(String usertel) {
        return userDao.searchUserbytel(usertel);
    }

    @Override
    public boolean updateUser(User user) {
        if (userDao.updateUser(user) > 0)
            return true;
        else
            return false;
    }

    @Override
    public int getUsernum() {
        return userDao.getUsernum();
    }

    @Override
    public boolean loginUserbyemail(User user) {
        String userpassword = MD5Util.MD5(user.getUserpassword());    //加密用户密码
        user.setUserpassword(userpassword);
        if (userDao.userMatchingbyemail(user) > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean loginUserbytel(User user) {
        String userpassword = MD5Util.MD5(user.getUserpassword());    //加密用户密码
        user.setUserpassword(userpassword);
        if (userDao.userMatchingbytel(user) > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserById(int id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public boolean useraccountcheck(String username) {
        if (userDao.usernamecheck(username) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean usertelCheck(String usertel) {
        if (userDao.usertelCheck(usertel) > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Course> getUserAllCourse(int userid) {
        List<User_Course> user_courses = new ArrayList<User_Course>();
        user_courses = user_courseDao.getU_CListByuserid(userid);
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < user_courses.size(); i++) {
            courseList.add(courseDao.getCoursebyid(user_courses.get(i).getCourseid()));
        }
        if (courseList != null)
            return courseList;
        else
            return null;
    }



//    ------------------------------------------------------------
    @Override
    public boolean userTelCheck(String usertel) {
        User user = userDao.getUserByTel(usertel);
        if(user==null)
            return true;
        else {
            return false;
        }
    }

    @Override
    public boolean userEmailcheck(String email) {
        User user = userDao.getUserByEmail(email);
        if (user==null)
            return true;
        else {
            return false;
        }
    }

    @Override
    public void addService(String subject, String content) {
        Integer id = Integer.parseInt((String) Factory.getRequest().getSession().getAttribute("userId"));
        User user = userDao.getUserById(id);
        String email = user.getUseremail();
        String name = user.getUsername();
        String phone = user.getUsername();
        userDao.addService(name,email,phone,subject,content);
    }

    @Override
    public boolean updateuseremailcheck(int userid, String useremail) {
        if(userDao.updateuseremailcheck(userid,useremail)>0)
            return true;
        else
            return false;
    }

}
