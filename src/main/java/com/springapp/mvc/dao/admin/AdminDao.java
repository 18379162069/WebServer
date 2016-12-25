package com.springapp.mvc.dao.admin;

import com.springapp.mvc.pojo.*;

import java.util.List;

/**
 * Created by Administrator on 2016/2/10 0010.
 */
public interface AdminDao {
    public void insertAdmin(Admin admin);   //加入新的管理员
    public int checkAdmin(String adminaccount);   //根据管理员账号检测是否存在
    public boolean deleteAdmin(String adminaccount);  //根绝管理员账号删除管理员
    public Admin searchAdmin(String adminaccount);  //根据管理员账号查找管理员
    public int getallAdminNum();                     //获得管理员数量
    public int alterAdmin(Admin admin);      //修改管理员信息
    public int matchingAdmin(Admin admin);   //管理员登陆验证

    public Integer getCourseDocCount(); //课程开班文档数
    public Integer getCourseCheckCount();//课程信息审核数
    public Integer getServiceCheckCount();//业务信息审核数
    public Integer getCompanyCheckCount();//企业会员申请审核
    public Integer getLecturerCheckCount();//个人讲师申请审核
    public Integer getNewsCheckCount();//最新资讯审核

    public List<Lecturer> getNoCheckL(int pageNo);
    public List<CompanyUser> getNoCheckC(int pageNo);


    public List<Course> getNoCheckCourse(int pageNo);
    public List<Service> getNoCheckService(int pageNo);
    public List<LastedNews> getNoCheckNews(int pageNo);
    public List<LastedNews> getNoCheckNewsContent(int pageNo);
    public List<Course> getNoCheckCourseDoc(int pageNo);

    public List<LastedNews> getAllNewsList();

    public void addNews(LastedNews lastedNews);

    public List<Integer> getAllUserByNewsId(int id);

    public String getNewsNameById(int id);

    public Course getCourseById(int id);

    public void agrDelCourse(int id);    //同意删除课程

    public List<Integer> getAllStuByCourseId(Integer courseId);


    public List<TypeCheck> getCourseTypeCheckList();
    public List<TypeCheck> getServiceTypeCheckList();

    public void delServiceType(Integer id);
    public void delCourseType(Integer id);

    public List<Admin> getAllAdmin();  //获取所有管理员

}
