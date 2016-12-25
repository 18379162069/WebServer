package com.springapp.mvc.service.admin;

import com.springapp.mvc.pojo.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/10 0010.
 */
public interface AdminService {
    public void insertAdmin(String account,String password);   //加入新的管理员
    public boolean checkAdmin(String adminaccount);   //根据管理员账号检测是否存在
    public boolean deleteAdmin(String adminaccount);  //根绝管理员账号删除管理员
    public Admin searchAdmin(String adminaccount);  //根据管理员账号查找管理员
    public int getallAdminNum();                     //获得管理员数量
    public boolean alterAdmin(Admin admin);      //修改管理员信息
    public boolean matchingAdmin(String account,String password);   //管理员登陆验证

    public Map<String,Integer> getAdminIndexCount();

    List<Course> getNoCheckCourse(int pageNo);

    List<Service> getNoCheckService(int pageNo);

    List<LastedNews> getNoCheckNews(int pageNo);

    List<LastedNews> getNoCheckNewsContent(int pageNo);

    List<Course> getNoCheckCourseDoc(int pageNo);

    List<CompanyUser> getNoCheckC(int pageNo);

    List<Lecturer> getNoCheckL(int pageNo);

    List<LastedNews> getAllNewsList();

    public void addNews(LastedNews lastedNews,MultipartFile newspic);

    public boolean sendToEmail(String emailContent,int id) throws GeneralSecurityException, MessagingException;

    public Course getCourseById(int id);

    public void agrDelCourse(int id);

    public void agrCourseDocCheck(Integer id) throws GeneralSecurityException, MessagingException;

    public void notAgrCourseDocCheck(Integer id);

    public byte[] getInputStream(String imgFile,String imgName);

    public List<TypeCheck> courseTypeCheckList();
    public List<TypeCheck> serviceTypeCheckList();


    public void argServiceTypeCheck(Integer id,String agree);
    public void argCourseTypeCheck(Integer id,String agree);

    public List<Admin> getAllAdmin();                        //获取所有管理员
}
