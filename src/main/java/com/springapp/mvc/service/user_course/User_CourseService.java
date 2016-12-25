package com.springapp.mvc.service.user_course;

import com.springapp.mvc.pojo.User_Course;

import java.util.List;

/**
 * Created by Administrator on 2016/2/26 0026.
 */
public interface User_CourseService {
    public boolean insertU_CNexus(int userid, int courseid);   // �����û��Ϳγ���ϵ
    public boolean deleteU_CNexus(int userid, int courseid);                 //ɾ���û��γ�
    public List<User_Course> getU_CListByuserid(int userid);           //��ȡѧ�������пγ�
    public List<User_Course> getU_CListBycourseid(int courseid);           //��ȡ�γ�����ѧ��
    public boolean checkUserCourse(int userid, int courseid);        //�ж��û��Ƿ��ظ�ѡ��
}
