package com.springapp.mvc.service.user_news;

import com.springapp.mvc.pojo.User_News;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
public interface User_NewsService {
    public boolean  inserteU_NNexus(int userid, int newsid);        //�����û������Ź�ϵ
    public boolean  deleteU_NNexus(int userid, int newsid);          //ɾ���û������Ź�ϵ
    public List<User_News> getListByUserId(int userid);         //��ȡ�û�����������
    public List<User_News> getListByNewsid(int newsid);     //��ȡ���ŵ������û�
}
