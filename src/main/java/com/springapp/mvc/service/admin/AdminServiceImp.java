package com.springapp.mvc.service.admin;

import com.springapp.mvc.dao.admin.AdminDao;
import com.springapp.mvc.dao.course.CourseDao;
import com.springapp.mvc.dao.service.ServiceDao;
import com.springapp.mvc.dao.user.UserDao;
import com.springapp.mvc.javamail.util.MailUtil;
import com.springapp.mvc.pojo.*;
import com.springapp.mvc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/10 0010.
 */
@org.springframework.stereotype.Service(value = "adminService")
@Transactional
public class AdminServiceImp implements AdminService {


    @Resource
    private AdminDao adminDao;
    @Autowired
    private RootPath rootPath;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private PicUpLoad upLoad;
    @Autowired
    private FileIO fileIO;
    @Autowired
    private MailUtil mailUtil;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private UserDao userDao;

    //增加管理员
    @Override
    public void insertAdmin(String account, String password) {
        Admin admin = new Admin();
        admin.setAdminaccount(account);
        admin.setAdminpassword(password);
        adminDao.insertAdmin(admin);
    }

    /**
     * 检查管理员是否存在
     *
     * @param adminaccount
     * @return
     */
    @Override
    public boolean checkAdmin(String adminaccount) {
        if (adminDao.checkAdmin(adminaccount) != 0) {
            return true;
        } else
            return false;
    }

    /**
     * 根据管理员账号删除管理员
     *
     * @param adminaccount
     * @return boolean
     */

    @Override
    public boolean deleteAdmin(String adminaccount) {
        adminDao.deleteAdmin(adminaccount);
        if (adminDao.checkAdmin(adminaccount) != 0) {
            return true;
        } else
            return false;
    }

    /**
     * 查找管理员
     *
     * @param adminaccount
     * @return
     */

    @Override
    public Admin searchAdmin(String adminaccount) {
        return adminDao.searchAdmin(adminaccount);
    }

    /**
     * 获得管理员数量
     *
     * @return
     */

    @Override
    public int getallAdminNum() {
        return adminDao.getallAdminNum();
    }

    /**
     * 修改管理员信息
     *
     * @param admin
     * @return
     */

    @Override
    public boolean alterAdmin(Admin admin) {
        String adminpassword = MD5Util.MD5(admin.getAdminpassword());    //加密管理员密码
        admin.setAdminpassword(adminpassword);
        if (adminDao.alterAdmin(admin) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean matchingAdmin(String account, String password) {
        String newPsd = MD5Util.MD5(password);
        Admin admin = adminDao.searchAdmin(account);
        if (admin != null) {
            String psd = admin.getAdminpassword();
            return newPsd.equals(psd);
        }
        return false;
    }

    @Override
    public Map<String, Integer> getAdminIndexCount() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("courseDocCount", adminDao.getCourseDocCount());
        map.put("courseCheckCount", adminDao.getCourseCheckCount());
        map.put("serviceCheckCount", adminDao.getServiceCheckCount());
        map.put("companyCheckCount", adminDao.getCompanyCheckCount());
        map.put("lecturerCheckCount", adminDao.getLecturerCheckCount());
        map.put("newsCheckCount", adminDao.getNewsCheckCount());
        return map;
    }

    @Override
    public List<Course> getNoCheckCourse(int pageNo) {
        List<Course> courseList = adminDao.getNoCheckCourse(pageNo * 10);
        return courseList;
    }

    @Override
    public List<com.springapp.mvc.pojo.Service> getNoCheckService(int pageNo) {
        List<Service> serviceList = adminDao.getNoCheckService(pageNo * 10);
        return serviceList;
    }

    @Override
    public List<LastedNews> getNoCheckNews(int pageNo) {
        List<LastedNews> newsList = adminDao.getNoCheckNews(pageNo * 10);
        return newsList;
    }

    @Override
    public List<LastedNews> getNoCheckNewsContent(int pageNo) {
        List<LastedNews> newsContentList = adminDao.getNoCheckNewsContent(pageNo * 10);
        return newsContentList;
    }

    @Override
    public List<Course> getNoCheckCourseDoc(int pageNo) {
        List<Course> courseDocList = adminDao.getNoCheckCourseDoc(pageNo * 10);
        return courseDocList;
    }

    @Override
    public List<CompanyUser> getNoCheckC(int pageNo) {
        List<CompanyUser> companyUserList = adminDao.getNoCheckC(pageNo * 10);
        return companyUserList;
    }

    @Override
    public List<Lecturer> getNoCheckL(int pageNo) {
        List<Lecturer> lecturerList = adminDao.getNoCheckL(pageNo * 10);
        return lecturerList;
    }

    @Override
    public List<LastedNews> getAllNewsList() {
        List<LastedNews> newsList = adminDao.getAllNewsList();
        return newsList;
    }

    @Override
    public void addNews(LastedNews lastedNews, MultipartFile newspic) {
        lastedNews.setNewscheck("1");
        lastedNews.setCompanyuserid(0);
        lastedNews.setCompanyname("管理员公司");

        //图片存放位置并上传图片
        String picStorePlace = "/WEB_RES/news_pic/";
        String newPicName = upLoad.updatePicName(newspic.getOriginalFilename());
        lastedNews.setNewspic(newPicName);
        upLoad.upLoad(newspic, newPicName, picStorePlace);

        adminDao.addNews(lastedNews);
    }

    //管理员的资讯发送给订阅者
    @Override
    public boolean sendToEmail(String emailContent, int id) throws GeneralSecurityException, MessagingException {
        List<Integer> userIds = adminDao.getAllUserByNewsId(id);
        String newStr = "";
        String[] to;
        for (int tmpId : userIds) {
            String email = userDao.getUserById(tmpId).getUseremail();
            newStr += email;
            newStr += ",";
        }
        if (newStr != "") {
            newStr = newStr.substring(0, newStr.length() - 1);
        }
        to = StringRule.oneToManyStr(newStr);
        String from = "510629251@qq.com";
        String password = "jhekfdoamsmncaeh";
        String subject = adminDao.getNewsNameById(id);
        if (userIds.size() != 0) {
            mailUtil.sendMail(from, password, to, subject, emailContent);
        }
        return true;
    }

    @Override
    public Course getCourseById(int id) {
        Course course = adminDao.getCourseById(id);
        return course;
    }

    @Override
    public void agrDelCourse(int id) {
        adminDao.agrDelCourse(id);
    }

    @Override
    public void agrCourseDocCheck(Integer courseId) throws GeneralSecurityException, MessagingException {
        List<Integer> studentIds = adminDao.getAllStuByCourseId(courseId);
        String newStr = "";
        String[] to;
        for (int tmpId : studentIds) {
            if (userDao.getUserById(tmpId) != null) {
                String email = userDao.getUserById(tmpId).getUseremail();
                System.out.println(courseId + "//" + tmpId + "//" + email);
                newStr += email;
                newStr += ",";
            }
        }
        if (newStr != "") {
            newStr = newStr.substring(0, newStr.length() - 1);
        }
        to = StringRule.oneToManyStr(newStr);
        String from = "510629251@qq.com";
        String password = "jhekfdoamsmncaeh";
        Course course = courseDao.getCoursebyid(courseId);
        String subject = course.getCoursename();
        String fileUrl = rootPath.RootPath() + "WEB_RES/doc/" + course.getCoursedoc();
        System.out.println(fileUrl + "这是文档地址");
        if (studentIds.size() != 0) {
            mailUtil.sendFileMail(from, password, to, subject, fileUrl);
        }
        notAgrCourseDocCheck(courseId);
    }

    @Override
    public void notAgrCourseDocCheck(Integer courseId) {
        Course course = courseDao.getCoursebyid(courseId);
        course.setCoursedoc(null);
        courseDao.updateCourseinfo(course);
    }

    @Override
    public byte[] getInputStream(String imgFile, String imgName) {
        String picPath = rootPath.RootPath() + "WEB_RES/doc_pic/" + imgFile + "/" + imgName;
        byte[] fileIOStream = fileIO.getInputStream(picPath);

        return fileIOStream;
    }

    @Override
    public List<TypeCheck> courseTypeCheckList() {
        List<TypeCheck> typeCheckList = adminDao.getCourseTypeCheckList();
        return typeCheckList;
    }

    @Override
    public List<TypeCheck> serviceTypeCheckList() {
        List<TypeCheck> typeCheckList = adminDao.getServiceTypeCheckList();
        return typeCheckList;
    }

    @Override
    public void argServiceTypeCheck(Integer id, String agree) {

        if (agree.equals("yes")) {
            TypeCheck typeCheck = serviceDao.getCheckTypeById(id);
            if(typeCheck!=null) {
                String type1Name = typeCheck.getType1name();
                String type2Name = typeCheck.getType2name();
                int type1id = serviceDao.getType1IdByType1Name(type1Name);
                int type2id = serviceDao.getLastType2IdByType1Name(type1Name);
                System.out.println("type1id=" + type1id + "//" + "type2id=" + type2id);
                serviceDao.addServiceType(type1id, type1Name, type2id + 1, type2Name);
            }
        }
        adminDao.delServiceType(id);
    }

    @Override
    public void argCourseTypeCheck(Integer id, String agree) {
        System.out.println(id+"//"+agree);
        if (agree.equals("yes")) {
            TypeCheck typeCheck = courseDao.getCheckTypeById(id);
            System.out.println(typeCheck);
            if(typeCheck!=null) {
                String type1Name = typeCheck.getType1name();
                String type2Name = typeCheck.getType2name();
                int type1id = courseDao.getType1IdByType1Name(type1Name);
                int type2id = courseDao.getLastType2IdByType1Name(type1Name);
                courseDao.addCourseType(type1id, type1Name, type2id + 1, type2Name);
            }
        }
        adminDao.delCourseType(id);
    }


    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

}
