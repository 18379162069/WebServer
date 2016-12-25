package com.springapp.mvc.service.lecturer;

import com.springapp.mvc.dao.lecturer.LecturerDao;
import com.springapp.mvc.pojo.Lecturer;
import com.springapp.mvc.util.MD5Util;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/2/15 0015.
 */
@org.springframework.stereotype.Service(value = "lecturerService")
@Transactional
public class LecturerServiceImp implements LecturerService {
    @Resource
    private LecturerDao lectureDao;
    @Override
    public boolean insertLecturer(Lecturer lecturer) {
        lecturer.setLecturerpassword(MD5Util.MD5(lecturer.getLecturerpassword()));
        if(lectureDao.insertLecturer(lecturer)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteLecturerById(int id) {
        if(lectureDao.deleteLecturerById(id)>0)
            return true;
        else
            return false;
    }

    @Override
    public Lecturer searchLecturerByid(int id) {
        return lectureDao.searchLecturerByid(id);
    }

    @Override
    public List<Lecturer> searchLecturerByName(String lecturename) {
        return lectureDao.searchLecturerByName(lecturename);
    }

    @Override
    public List<Lecturer> searchLecturerByTel(String lecturetel) {
        return lectureDao.searchLecturerByTel(lecturetel);
    }

    @Override
    public boolean getLecturerCourseIds(int id) {
        if(lectureDao.getLecturerCourseIds(id)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateLecturerCourseId(int id, String courseids) {
        if(lectureDao.updateLecturerCourseId(id, courseids)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updatelecturer(Lecturer lecturer) {
        if (lectureDao.updatelecturer(lecturer)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean changeLecturerCheck(int id) {
        if(lectureDao.changeLecturerCheck(id)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean changeCourseCheck(int id) {
        if(lectureDao.changeCourseCheck(id)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean notAgrCourseCheck(int id) {

        if(lectureDao.notAgrCourseCheck(id)>0)
            return true;
        else
            return false;
    }



    @Override
    public boolean updatelecturerbyaccount(Lecturer lecturer) {
        System.out.println(lecturer.toString());
        if(lectureDao.updatelecturerbyaccount(lecturer.getLectureraccount())!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean updatelecturerbyid(Lecturer lecturer) {
        if(lectureDao.updatelecturerbyid(lecturer)>0)
            return true;
        else
            return false;
    }


    @Override
    public Lecturer searchLecturerbyAccount(String account) {
        return lectureDao.searchLecturerByAccount(account);
    }

    @Override
    public boolean matchingLecture(String account, String password) {
        if(lectureDao.matchingLecturerbyaccount(account,MD5Util.MD5(password))>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean registerLecturer(String account, String password) {
        Lecturer lecturer=new Lecturer();
        lecturer.setLectureraccount(account);
        lecturer.setLecturerpassword(MD5Util.MD5(password));
        if(lectureDao.insertLecturer(lecturer)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean matchingLecturerAccount(String account) {
        if(lectureDao.matchingLecturerAccount(account)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean checklecturertel(String lecturertel) {
        if(lectureDao.lecturertelcheck(lecturertel)>0)
            return true;
        else
            return false;
    }

    @Override
    public String getLecturerByCourseEmail(String email) {
        return lectureDao.getLecturerByCourseEmail(email);
    }

    @Override
    public boolean checklectureremail(String lectureremail) {
        if(lectureDao.lectureremailcheck(lectureremail)>0)
            return  true;
        else
            return false;
    }
    @Override
    public boolean updatechecklectureremail(int lecturerid, String lectureremail) {
        if (lectureDao.updatelectureremailcheck(lecturerid, lectureremail) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean insertServiceType(String type1Name, String type2Name) {
        Integer type2Id = lectureDao.get2IdByTypeName(type2Name);
        if(type2Id==null){
            lectureDao.insertCourseType(type1Name,type2Name);
            return true;
        }else{
            return false;
        }
    }
}
