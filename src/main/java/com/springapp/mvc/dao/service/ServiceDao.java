package com.springapp.mvc.dao.service;

import com.springapp.mvc.pojo.Service;
import com.springapp.mvc.pojo.TypeCheck;

import java.util.List;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
public interface ServiceDao {
    public  int insertService(Service service);            //增加业务信息
    public  int deleteServicebyid(int id);                //通过业务id删除业务
    public List<Service> searchServicebyname(String servicename);      //通过业务名称搜索业务
    public Service searchServicebyid(int id);             //通过业务id准确得到业务信息
    public int alterServiceInfo(Service service);          //更改业务信息
    public List<Service> searchServicebytype1();  //得到第一级业务信息
    public List<Service> searchServicebytype2();  //得到第二级业务信息
    public List<Service> searchServicebytype3();  //得到第三级业务信息
    public int  alterServicecheck(int id, String servicecheck);                //通过id修改审核属性来判定业务是否审核通过 未完成成
    public int  getServicenum();                           //得到业务总数
    public int  getpassServicenum();                        //得到通过审核的业务数


//    --------------------------------------
    public List<String> getAllType1List();
    public List<Integer> getTopService();
    public Service getServicebyid(Integer id);
    public List<String> getType2For1(Integer index);
    public Integer getTyp2IdByType2Name(String type2);
    public Integer getTyp1IdByType2Name(String type2);
    public List<Service> getSByType12IdPage(Integer type1,Integer type2,Integer pageNum);
    Integer getServiceAllPageNum(Integer type1,Integer type2);
    public Integer getType1IdByType1Name(String type1Name);
    public Integer getLastType2IdByType1Name(String type1Name);

    public TypeCheck getCheckTypeById(Integer id);
    public void addServiceType(Integer type1id,String type1Name,Integer type2id,String type2Name);

}
