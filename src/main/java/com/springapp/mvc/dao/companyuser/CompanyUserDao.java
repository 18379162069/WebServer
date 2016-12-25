package com.springapp.mvc.dao.companyuser;

import com.springapp.mvc.pojo.CompanyApplication;
import com.springapp.mvc.pojo.CompanyUser;
import com.springapp.mvc.pojo.LastedNews;
import com.springapp.mvc.pojo.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by louie on 2016/2/11.
 */
public interface CompanyUserDao {

    public boolean checkAccount();

    public CompanyUser getObjByAccount(String account);

    public void addCompanyUser(CompanyUser companyUser);

    public Integer accountIsExits(String account);

    public void delCompanyUser(int id);

    public List<CompanyUser> listCompanyUser();

    public void editCompanyUser(Map map);

    public void pubNews(LastedNews lastedNews);

    public void companyUserAppl(CompanyApplication companyUserAppl);

    public List<CompanyApplication> getAllCAppl();

    public CompanyApplication getReasonById(int id);

    public void delApplById(int id);

    public Service getServiceById(int id);

    public void changeServiceCheck(int id);

    public void notAgrServiceCheck(int id);

    public LastedNews getNewsById(int id);

    public void changeNewsCheck(int id);

    public void notAgrNewsCheck(int id);

    public List<Service> listService();

    public List<Service> getType1Service(int type,int companyUserId);

    public List<Integer> getType1List(Integer id);

    public Integer get1IdByTypeName(String typename);
    public Integer get2IdByTypeName(String typename);
    public Integer get3IdByTypeName(String typename);


    public Integer getIdByAc(String account);

    public String getType1NameById(Integer id);

    public void delService(Integer id);

    public Service showService(Integer id);

    public void editService(Integer id,String content);

    public List<String> getType2List(String type1);

    public void agrDelService(Integer id);

    public List<String> getType3List(String type1,String type2);

    public List<String> getAllType1List();

    public List<String> getSpecType2List();
    public List<String> getSpecType3List();

    public void addService(Service service);

    public List<String> getNewsTypeList();

    public CompanyUser getObjById(Integer id);

    public void addNews(LastedNews lastedNews);
    public List<LastedNews> getMyNewsList(Integer id);

    public void agrNewsContentCheck(Integer id);

    public void notAgrNewsContentCheck(Integer id);



    //----------------------------------
    public List<Integer> getTopService();
    public List<Integer> getTopNews();
    public void insertServiceType(String type1Name,String type2Name);

    }
