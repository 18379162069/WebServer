package com.springapp.mvc.service.user_service;

import com.springapp.mvc.pojo.User_Service;

import java.util.List;

/**
 * Created by Administrator on 2016/3/6 0006.
 */
public interface User_ServiceService {
    public boolean  inserteU_SNexus(int userid, int serviceid);        //�����û���ҵ���ϵ
    public boolean  deleteU_SNexus(int userid, int serviceid);          //ɾ���û���ҵ���ϵ
    public List<User_Service> getListByUserId(int userid);         //��ȡ�û�������ҵ��id
    public List<User_Service> getListByCourseid(int service);     //��ȡҵ��������û�
    public boolean checkUserService(int userid, int serviceid);                //����û��Ƿ��ظ�����ҵ��
}
