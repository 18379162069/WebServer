package com.springapp.mvc.service.companyuser;

import com.alibaba.fastjson.JSON;
import com.springapp.mvc.dao.admin.AdminDao;
import com.springapp.mvc.dao.companyuser.CompanyUserDao;
import com.springapp.mvc.dao.user.UserDao;
import com.springapp.mvc.javamail.util.MailUtil;
import com.springapp.mvc.pojo.CompanyApplication;
import com.springapp.mvc.pojo.CompanyUser;
import com.springapp.mvc.pojo.LastedNews;
import com.springapp.mvc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.*;

/**
 * Created by louie on 2016/2/11.
 */

@Service(value = "companyUser")
public class CompanyUserImp implements CompanyUserService {

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private RootPath rootPath;
    @Autowired
    private PicUpLoad upLoad;
    @Autowired
    private RequestFactory Factory;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private CompanyUserDao companyUserDao;

    @Override
    public boolean checkAccount(String account, String password) {
        CompanyUser companyUser = companyUserDao.getObjByAccount(account);
        String newPsd = MD5Util.MD5(password);
        return newPsd.equals(companyUser.getCompanyuserpassword());
    }

    @Override
    public boolean addCompanyUser(String account,String password) {
        String newPsd = MD5Util.MD5(password);
        CompanyUser companyUser = new CompanyUser();
        companyUser.setCompanyuseraccount(account);
        companyUser.setCompanyuserpassword(newPsd);
        companyUserDao.addCompanyUser(companyUser);
        return true;
    }

    @Override
    public boolean accountIsExits(String account) {
        Integer id  = companyUserDao.accountIsExits(account);
        if (id==null){
            return false;
        }
        return true;
    }

    @Override
    public void delCompanyUser(int id) {
        companyUserDao.delCompanyUser(id);
    }

    @Override
    public List<CompanyUser> listCompanyUser() {
        List<CompanyUser> list = companyUserDao.listCompanyUser();
        return list;
    }

    @Override
    public void editCompanyUser(CompanyUser companyUser) {
        System.out.println(companyUser.toString()+"---==--");
        Integer id = Factory.getMyIdFromSession("companyuser");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("obj",companyUser);
        map.put("id",id);
        companyUserDao.editCompanyUser(map);

    }

    @Override
    public void pubNews(LastedNews lastedNews) {

        companyUserDao.pubNews(lastedNews);
    }

    @Override
    public void companyUserAppl(String companyusername, String applicationreason, String companyuseremail, String companyusertel) {
        CompanyApplication companyApplication = new CompanyApplication();
        companyApplication.setCompanyusername(companyusername);
        companyApplication.setApplicationreason(applicationreason);
        companyApplication.setCompanyuseremail(companyuseremail);
        companyApplication.setCompanyusertel(companyusertel);
        companyApplication.setApplicationtime(NowDate.getNowDate());
        companyUserDao.companyUserAppl(companyApplication);
    }

    @Override
    public List<CompanyApplication> getAllCAppl() {
        List<CompanyApplication> companyAppList= companyUserDao.getAllCAppl();
        return companyAppList;
    }

    @Override
    public CompanyApplication getReasonById(int id){
        CompanyApplication companyApplication = companyUserDao.getReasonById(id);
        return companyApplication;
    }

    @Override
    public void delApplById(int id) {
        System.out.println(id+"zsd");
        companyUserDao.delApplById(id);
    }

    @Override
    public com.springapp.mvc.pojo.Service getServiceById(int id) {
        com.springapp.mvc.pojo.Service service = companyUserDao.getServiceById(id);
        return service;
    }

    @Override
    public void changeServiceCheck(int id) {
        companyUserDao.changeServiceCheck(id);
    }

    @Override
    public void notAgrServiceCheck(int id) {
        companyUserDao.notAgrServiceCheck(id);
    }

    @Override
    public LastedNews getNewsById(int id) {
        LastedNews news = companyUserDao.getNewsById(id);
        return news;
    }

    @Override
    public void changeNewsCheck(int id) {
        companyUserDao.changeNewsCheck(id);
    }

    @Override
    public void notAgrNewsCheck(int id) {
        companyUserDao.notAgrNewsCheck(id);
    }

    @Override
    public void sendEmail(int id) throws GeneralSecurityException, MessagingException {
        List<Integer> userIds = adminDao.getAllUserByNewsId(id);
        String newStr="";
        String[] to;
        for(int tmpId:userIds){
            String email = userDao.getUserById(tmpId).getUseremail();
            newStr+=email;
            newStr+=",";
        }
        String emailContent = companyUserDao.getNewsById(id).getNewscontent();
        if(newStr!="") {
            newStr = newStr.substring(0, newStr.length() - 1);
        }
        to = StringRule.oneToManyStr(newStr);

        String from="510629251@qq.com";
        String password="jhekfdoamsmncaeh";
        String subject=adminDao.getNewsNameById(id);
        if(userIds.size()!=0) {
            mailUtil.sendMail(from, password, to, subject, emailContent);
        }
    }

    @Override
    public List<com.springapp.mvc.pojo.Service> listService() {
        List<com.springapp.mvc.pojo.Service> serviceList = companyUserDao.listService();
        return serviceList;
    }

    @Override
    public List<String> getType1ListById() {
        String account = (String) Factory.getRequest().getSession().getAttribute("companyuser");
        Integer companyUserId = companyUserDao.getIdByAc(account);
        List<String> type1List = new ArrayList<String>();
        List<Integer> type1IdList = companyUserDao.getType1List(companyUserId);
        for(Integer id:type1IdList){
            String type = companyUserDao.getType1NameById(id);
            type1List.add(type);
        }
        return type1List;
    }

    @Override
    public List<com.springapp.mvc.pojo.Service> getType1Service(String type) {
        String account = (String) Factory.getRequest().getSession().getAttribute("companyuser");
        Integer companyUserId = companyUserDao.getIdByAc(account);
        Integer typeid = companyUserDao.get1IdByTypeName(type);
        List<com.springapp.mvc.pojo.Service> type1Service = companyUserDao.getType1Service(typeid,companyUserId);
        return type1Service;
    }

    @Override
    public void delService(Integer id) {
        companyUserDao.delService(id);
    }

    @Override
    public void editService(Integer id,String content) {
        companyUserDao.editService(id,content);
    }

    @Override
    public com.springapp.mvc.pojo.Service showService(Integer id) {
        com.springapp.mvc.pojo.Service service = companyUserDao.showService(id);
        return service;
    }

    @Override
    public String getNextTypeList(String type1, String type2) {
        List<String> typeList;
        List<String> type2List;
        if(type2==null) {
            typeList = companyUserDao.getType2List(type1);
            type2List = companyUserDao.getType3List(type1,typeList.get(0));
            return "{\"typeList\":"+JSON.toJSONString(typeList)+",\"type2List\":"+JSON.toJSONString(type2List)+"}";
        }else{
            typeList = companyUserDao.getType3List(type1,type2);
            return "{\"typeList\":"+JSON.toJSONString(typeList)+"}";
        }
    }

    @Override
    public List<String> getAllType1List() {
        List<String> allType1List = companyUserDao.getAllType1List();
        return allType1List;
    }

    @Override
    public List<String> getSpecType2List() {
        List<String> specType2List = companyUserDao.getSpecType2List();
        return specType2List;
    }

    @Override
    public List<String> getSpecType3List() {
        List<String> specType3List = companyUserDao.getSpecType3List();
        return specType3List;
    }

    @Override
    public void agrDelService(Integer id) {
        System.out.println(id+"我是id----");
        companyUserDao.agrDelService(id);
    }

    @Override
    public void addService(com.springapp.mvc.pojo.Service service,MultipartFile pic, String type1, String type2) {

        Integer companyuserId  = Factory.getMyIdFromSession("companyuser");
        System.out.println(type1);
        System.out.println(type2);

        Integer type1Id = companyUserDao.get1IdByTypeName(type1);
        Integer type2Id = companyUserDao.get2IdByTypeName(type2);
        service.setType1id(type1Id);
        service.setType2id(type2Id);
        service.setCompanyuserid(companyuserId);
        CompanyUser companyUser = companyUserDao.getObjById(companyuserId);
        service.setServicemanagetel(companyUser.getCompanyusertel());
        service.setServicemanage(companyUser.getCompanyusermanager());

        //处理图片
        String picStorePlace = "/WEB_RES/service_pic";
        String newPicName = upLoad.updatePicName(pic.getOriginalFilename());
        upLoad.upLoad(pic, newPicName, picStorePlace);
        service.setServicepic(newPicName);

        companyUserDao.addService(service);
    }

    @Override
    public List<String> getNewsTypeList() {
        List<String> newsTypeList = companyUserDao.getNewsTypeList();
        return newsTypeList;
    }

    @Override
    public void addNews(LastedNews lastedNews, MultipartFile newspic) {
        Integer companyUserId = Factory.getMyIdFromSession("companyuser");
        lastedNews.setCompanyuserid(companyUserId);
        CompanyUser companyUser = companyUserDao.getObjById(companyUserId);
        lastedNews.setCompanyname(companyUser.getCompanyusername());

        //图片存放位置并上传图片
        String picStorePlace = "/WEB_RES/news_pic";
        String newPicName = upLoad.updatePicName(newspic.getOriginalFilename());
        lastedNews.setNewspic(newPicName);
        upLoad.upLoad(newspic, newPicName, picStorePlace);

        companyUserDao.addNews(lastedNews);
    }

    @Override
    public List<LastedNews> getMyNewsList() {

        Integer companyuserId = Factory.getMyIdFromSession("companyuser");
        List<LastedNews> newsList = companyUserDao.getMyNewsList(companyuserId);
        return newsList;
    }


    //审核成功并且发送给订阅的人
    @Override
    public void agrNewsContentCheck(Integer id) throws GeneralSecurityException, MessagingException {
        List<Integer> userIds = adminDao.getAllUserByNewsId(id);
        String newStr="";
        String[] to;
        for(int tmpId:userIds){
            String email = userDao.getUserById(tmpId).getUseremail();
            newStr+=email;
            newStr+=",";
        }
        if(newStr!="") {
            newStr = newStr.substring(0, newStr.length() - 1);
        }
        String emailContent = companyUserDao.getNewsById(id).getNewscontent();
        to = StringRule.oneToManyStr(newStr);
        String from="510629251@qq.com";
        String password="jhekfdoamsmncaeh";
        String subject=adminDao.getNewsNameById(id);
        if(userIds.size()!=0) {
            mailUtil.sendMail(from, password, to, subject, emailContent);
        }
        companyUserDao.agrNewsContentCheck(id);
    }

    @Override
    public void notAgrNewsContentCheck(Integer id) {
        companyUserDao.notAgrNewsContentCheck(id);
    }

    @Override
    public CompanyUser getMyselfObj() {
        Integer id = Factory.getMyIdFromSession("companyuser");
        CompanyUser companyUser = companyUserDao.getObjById(id);
        return companyUser;
    }



    //------------------------------------------------------------
    @Override
    public List<com.springapp.mvc.pojo.Service> getTopService() {
        List<com.springapp.mvc.pojo.Service> serviceList = new ArrayList<com.springapp.mvc.pojo.Service>();
        List<Integer> serviceInteger = companyUserDao.getTopService();
        for(Integer tmp:serviceInteger){
            serviceList.add(companyUserDao.getServiceById(tmp));
        }
        return serviceList;
    }

    @Override
    public List<LastedNews> getTopNews() {
        List<LastedNews> newsList = new ArrayList<LastedNews>();
        List<Integer> newsInteger = companyUserDao.getTopNews();
        for(Integer tmp:newsInteger){
            newsList.add(companyUserDao.getNewsById(tmp));
        }
        return newsList;
    }

    @Override
    public boolean insertServiceType(String type1Name, String type2Name) {
        Integer type2Id = companyUserDao.get2IdByTypeName(type2Name);
        if(type2Id==null){
            companyUserDao.insertServiceType(type1Name,type2Name);
            return true;
        }else{
            return false;
        }
    }


}
