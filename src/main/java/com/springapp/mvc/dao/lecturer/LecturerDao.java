package com.springapp.mvc.dao.lecturer;

import com.springapp.mvc.pojo.Lecturer;

import java.util.List;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
public interface LecturerDao {
    public int insertLecturer(Lecturer lecturer);                      //���ӽ�ʦ
    public int deleteLecturerById(int id);                             //ͨ��idɾ����ʦ
    public Lecturer searchLecturerByid(int id);                         //ͨ��id���ҽ�ʦ
    public List<Lecturer> searchLecturerByName(String lecturename);     //ͨ������������ʦ
    public List<Lecturer> searchLecturerByTel(String lecturetel);       //ͨ����ʦ�ֻ�������ʦ
    public int  getLecturerCourseIds(int id);                          //ͨ��id��ÿγ�id
    public int     updateLecturerCourseId(int id,String courseids);       //���½�ʦ�γ�id
    public int     updatelecturer(Lecturer lecturer);                      //���½�ʦ��Ϣ
    public int     changeLecturerCheck(int id);               //�޸����״̬
    public int changeCourseCheck(int id);        //ͨ���γ����״̬

    public int notAgrCourseCheck(int id);     //��ͨ��

    public Lecturer searchLecturerByAccount(String account);            //ͨ����ʦ�˺Ų��ҽ�ʦ
    public int     updatelecturerbyid(Lecturer lecturer);                      //���½�ʦ��Ϣ
    public Integer     updatelecturerbyaccount(String account);                      //�����˺Ÿ��½�ʦ��Ϣ
    public int matchingLecturerbyaccount(String account,String password); //ƥ�佲ʦ
    public int matchingLecturerAccount(String account);                    //����˺�
    public int lecturertelcheck(String lecturertel);                           //����ֻ������Ƿ��ظ�
    public int lectureremailcheck(String lectureremail);                       //��ʦ�����ظ����
    public String getLecturerByCourseEmail(String email);               //��ʦemailȡ��ʦ
    public int updatelectureremailcheck(int lecturerid,String lectureremail);        //���½�ʦ��Ϣʱ�����ظ����






    public Integer get2IdByTypeName(String type2Name);
    public void insertCourseType(String type1Name,String type2Name);
}
