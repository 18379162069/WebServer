package com.springapp.mvc.service.coursepurchase;

import com.springapp.mvc.pojo.CoursePurchase;

import java.util.List;

/**
 * Created by Administrator on 2016/2/27 0027.
 */
public interface CoursePurchaseService {
    public boolean  addNewCoursePurchase(CoursePurchase coursePurchase);             //�����γ̽��׼�¼
    public boolean  deleteCoursePurchaseByOrderId(String orderid);                        //ͨ��������ɾ�������¼
    public List<CoursePurchase> getCoursePurchaseListByUserId(int userid);             //��ȡ�û����н�����Ϣ
    public List<CoursePurchase> getCoursePurchaseListNyCourseId(int courseid);        //��ȡ�γ����н�����Ϣ
    public List<CoursePurchase> getCoursePurchaseListByLecturerId(int lecturerid);   //��ȡ���н�ʦ�Ķ�����Ϣ
}
