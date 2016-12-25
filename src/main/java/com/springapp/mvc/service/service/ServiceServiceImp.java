package com.springapp.mvc.service.service;

import com.springapp.mvc.dao.service.ServiceDao;
import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.Service;
import com.springapp.mvc.util.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/12 0012.
 */
@org.springframework.stereotype.Service(value = "serviceService")
@Transactional
public class ServiceServiceImp implements ServiceService {
    @Resource
    private ServiceDao serviceDao;

    /**
     * 增加业务
     * @param service
     * @return
     */
    @Override
    public boolean insertService(Service service) {
        if(serviceDao.insertService(service)>0)
            return true;
        else
            return false;
    }

    /**
     * 通过id删除业务
     * @param id
     * @return
     */
    @Override
    public boolean deleteServicebyid(int id) {
        if(serviceDao.deleteServicebyid(id)>0)
            return true;
        else
            return false;
    }

    /**
     * 根据业务名字模糊查询
     * @param servicename
     * @return
     */

    @Override
    public List<Service> searchServicebyname(String servicename) {
        return serviceDao.searchServicebyname(servicename);
    }

    /**
     * 根据业务等级返回业务信息
     * @param id
     * @return
     */

    @Override
    public Service searchServicebyid(int id) {
        return serviceDao.searchServicebyid(id);
    }

    /**
     * 修改业务信息
     * @param service
     * @return
     */

    @Override
    public boolean alterServiceInfo(Service service) {
        if(serviceDao.alterServiceInfo(service)>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Service> searchServicebytype(int type) {
        if(type==1)
            return serviceDao.searchServicebytype1();
        else if(type==2)
            return serviceDao.searchServicebytype2();
        else if(type==3)
            return serviceDao.searchServicebytype3();
        return null;
    }

    @Override
    public boolean alterServicecheck(int id, String servicecheck) {
        if(serviceDao.alterServicecheck(id,servicecheck)>0)
            return true;
        else
            return false;
    }

    @Override
    public int getServicenum() {
        return serviceDao.getServicenum();
    }

    @Override
    public int getpassServicenum() {
        return serviceDao.getpassServicenum();
    }

    @Override
    public List<String> getAllType1List() {
        List<String> allType1List = serviceDao.getAllType1List();
        return allType1List;
    }

    @Override
    public List<Service> getTopService() {
        List<Service> serviceList = new ArrayList<Service>();
        List<Integer> serviceInteger = serviceDao.getTopService();
        for(Integer tmp:serviceInteger){
            serviceList.add(serviceDao.getServicebyid(tmp));
        }
        return serviceList;
    }

    @Override
    public List<String> getType2For1(Integer index) {
        List<String> type2List = serviceDao.getType2For1(index);
        return type2List;
    }

    @Override
    public List<Service> getServiceByType2(String type2, Integer pageNum) {
        Integer type2Id = serviceDao.getTyp2IdByType2Name(type2);
        Integer type1Id = serviceDao.getTyp1IdByType2Name(type2);
        List<Service> serviceList = serviceDao.getSByType12IdPage(type1Id, type2Id, (pageNum - 1) * 10);
        return serviceList;
    }

    @Override
    public Page getServiceAllPageNum(String type2,Integer pageNum) {
        Integer type2Id = serviceDao.getTyp2IdByType2Name(type2);
        Integer type1Id = serviceDao.getTyp1IdByType2Name(type2);
        Integer courpage = serviceDao.getServiceAllPageNum(type1Id,type2Id);
        Integer courcount = (courpage/12)+1;        //对应课程总页数
        Page page = new Page(pageNum,courcount,0,0,0,0);
        return page;
    }


}
