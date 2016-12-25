package com.springapp.mvc.service.companyuser;

import com.springapp.mvc.pojo.CompanyApplication;
import com.springapp.mvc.pojo.CompanyUser;
import com.springapp.mvc.pojo.LastedNews;
import com.springapp.mvc.pojo.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created by louie on 2016/2/11.
 */
public interface CompanyUserService {

    public boolean checkAccount(String account,String password);

    public boolean addCompanyUser(String account,String password);

    public boolean accountIsExits(String account);

    public void delCompanyUser(int id);

    public List<CompanyUser> listCompanyUser();

    public void editCompanyUser(CompanyUser companyUser);

    public void pubNews(LastedNews lastedNews);

    public void companyUserAppl(String companyUserName,String applicationReason,String companyUserEmail,String companyUserTel);

    public List<CompanyApplication> getAllCAppl();

    public CompanyApplication getReasonById(int id);

    public void delApplById(int id);

    public Service getServiceById(int id);

    public void changeServiceCheck(int id);

    public void notAgrServiceCheck(int id);

    public LastedNews getNewsById(int id);

    public void changeNewsCheck(int id);

    public void notAgrNewsCheck(int id);

    public void sendEmail(int id) throws GeneralSecurityException, MessagingException;

    public  List<Service> listService();

    public List<String> getType1ListById();

    public List<Service> getType1Service(String type);

    public void delService(Integer id);

    public void editService(Integer id,String content);

    public Service showService(Integer id);     //servie详情

    public String getNextTypeList(String type1,String type2);  //获取级联操作数据

    public List<String> getAllType1List();  //获取所有Type1List

    public List<String> getSpecType2List(); //获取特定type2List

    public List<String> getSpecType3List();   //获取特定type3List

    public void agrDelService(Integer id);      //管理员同意删除业务

    public void addService(Service service,MultipartFile pic,String type1,String type2);

    public List<String> getNewsTypeList();

    public void addNews(LastedNews lastedNews,MultipartFile newspic); //添加资讯

    public List<LastedNews> getMyNewsList();

    public void agrNewsContentCheck(Integer id) throws GeneralSecurityException, MessagingException;

    public void notAgrNewsContentCheck(Integer id);

    public CompanyUser getMyselfObj();



    //-------------------------------------------------
    public List<Service> getTopService();
    public List<LastedNews> getTopNews();
    public boolean insertServiceType(String type1Name,String type2Name);
}
