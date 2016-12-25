package com.springapp.mvc.service.lecturer_course;

import com.springapp.mvc.dao.lecturer_course.Lecture_CourseDao;
import com.springapp.mvc.pojo.Lecturer;
import com.springapp.mvc.pojo.Lecturer_Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
@org.springframework.stereotype.Service(value = "lecturer_courseService")
@Transactional
public class Lecturer_CourseServiceImp implements Lecturer_CourseService {
    @Autowired
    Lecture_CourseDao lecture_courseDao;
    @Override
    public boolean addL_CNexus(int companyid, int serviceid) {
        if(lecture_courseDao.addL_CNexus(companyid,serviceid)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteL_CNexus(int id) {
        if(lecture_courseDao.deleteL_CNexus(id)>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Lecturer_Course> getL_CNexusbyLecturerid(int lecturerid) {
        return lecture_courseDao.getL_CNexusbyLecturerid(lecturerid);
    }

    @Override
    public int getLecturerByCourseid(int courseid) {
        return lecture_courseDao.getLecturerByCourseid(courseid);
    }

    @Override
    public boolean deleteCourseByCourseid(int courseid) {
        if(lecture_courseDao.deleteCourseByCourseid(courseid)>0)
            return true;
        else
            return false;
    }


}
