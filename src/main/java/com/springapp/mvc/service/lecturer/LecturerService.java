package com.springapp.mvc.service.lecturer;

import com.springapp.mvc.pojo.Lecturer;

import java.util.List;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
public interface LecturerService {
    public boolean insertLecturer(Lecturer lecturer);                      //���ӽ�ʦ
    public boolean deleteLecturerById(int id);                             //ͨ��idɾ����ʦ
    public Lecturer searchLecturerByid(int id);                         //ͨ��id���ҽ�ʦ
    public List<Lecturer> searchLecturerByName(String lecturename);     //ͨ������������ʦ
    public List<Lecturer> searchLecturerByTel(String lecturetel);       //ͨ����ʦ�ֻ�������ʦ
    public boolean     getLecturerCourseIds(int id);                          //ͨ��id��ÿγ�id
    public boolean     updateLecturerCourseId(int id,String courseids);       //���½�ʦ�γ�id
    public boolean     updatelecturer(Lecturer lecturer);                      //���½�ʦ��Ϣ
    public boolean     changeLecturerCheck(int id);               //ͨ�����״̬
    public  boolean     changeCourseCheck(int id);               //ͨ�����״̬
    public boolean notAgrCourseCheck(int id);        //��ͨ��

    public boolean     updatelecturerbyaccount(Lecturer lecturer);                      //�����˺Ÿ��½�ʦ��Ϣ
    public boolean     updatelecturerbyid(Lecturer lecturer);                         //����id���½�ʦ��Ϣ
    public Lecturer    searchLecturerbyAccount(String account);        //ͨ���˺Ų��ҽ�ʦ
    public boolean    matchingLecture(String account,String password);     //ƥ�佲ʦ�û�
    public boolean    registerLecturer(String account,String password);    //ע�ὲʦ���Ҳ����½�ʦ
    public boolean matchingLecturerAccount(String account);                    //����˺�
    public boolean checklecturertel(String lecturertel);                     //����ظ�����
    public boolean checklectureremail(String lectureremail);                   //����ظ�����
    public String getLecturerByCourseEmail(String email);
    public boolean updatechecklectureremail(int lecturerid,String lectureremail); //������Ϣʱ�����ظ����



    public boolean insertServiceType(String type1Name,String type2Name);
}
