package com.springapp.mvc.service.service;

import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.Service;
import com.springapp.mvc.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/2/12 0012.
 */
public interface ServiceService {
    public boolean insertService(Service service);                           //增加业务
    public boolean deleteServicebyid(int id);                               //通过业务id删除业务
    public List<Service> searchServicebyname(String servicename);             //根据业务名称模糊查询业务
    public Service searchServicebyid(int id);                                 //根据业务id准确查询业务信息
    public boolean alterServiceInfo(Service service);                        //修改业务信息
    public List<Service> searchServicebytype(int type);                       //根据业务等级获得业务list
    public boolean  alterServicecheck(int id, String servicecheck);           //根据id修改业务的审核情况
    public int  getServicenum();                                               //获得业务总数
    public int  getpassServicenum();                                           //获取业务通过审核的个数






//    ----------------------------------------------------
    public List<String> getAllType1List();
    public List<Service> getTopService();
    public List<String> getType2For1(Integer index);
    public List<Service> getServiceByType2(String type2,Integer pageNum);
    public Page getServiceAllPageNum(String type2,Integer pageNum);
}
