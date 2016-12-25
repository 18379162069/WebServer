package com.springapp.mvc.service.course;

import com.springapp.mvc.dao.course.CourseDao;
import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.util.Page;
import com.springapp.mvc.util.PicUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/13 0013.
 */
@org.springframework.stereotype.Service(value = "courseService")
@Transactional
public class CourseServiceImp implements CourseService {
    @Resource
    private CourseDao courseDao;

    @Autowired
    private PicUpLoad upLoad;
    @Override
    public boolean insertCourse(Course course,MultipartFile pic,String type1Name,String type2Name) {
        if (pic != null) {
           // PicUpLoad picUpLoad=new PicUpLoad();
            String picStorePlace = "WEB_RES/course_pic/";
            String userPicName = upLoad.updatePicName(pic.getOriginalFilename());
            upLoad.upLoad(pic,userPicName,picStorePlace);
            String userpicurls=userPicName;
            course.setCoursepic(userpicurls);
        }
        Integer type1Id = courseDao.getType1IdByType1Name(type1Name);
        Integer type2Id = courseDao.getTyp2IdByType2Name(type2Name);
        course.setType1id(type1Id);
        course.setType2id(type2Id);
        if (courseDao.insertCourse(course) > 0)
            return true;
        else
            return false;
    }



    @Override
    public List<Course> getAllLecturerByEmail(String lecturerEmail) {
        return courseDao.getAllLecturerByEmail(lecturerEmail);
    }

    @Override
    public boolean deleteCoursebyid(int id) {
        if (courseDao.deleteCoursebyid(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateCourseinfo(Course course) {
        if (courseDao.updateCourseinfo(course) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateCoursePic(int id, String cpics) {
        if (courseDao.updateCoursePic(id, cpics) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean changeCourseCheck(int id, String coursecheck) {
        if (courseDao.changeCourseCheck(id, coursecheck) > 0)
            return true;
        else
            return false;
    }

    @Override
    public String courseCheck(int courseid) {
        if (courseDao.courseCheck(courseid) == null)
            return null;
        else if (courseDao.courseCheck(courseid).equals("1"))
            return "1";

        else
            return "-1";
    }

    @Override
    public Course getCoursebyid(int id) {
        return courseDao.getCoursebyid(id);
    }

    @Override
    public List<Course> getCoursebyname(String coursename) {
        return getCoursebyname(coursename);
    }

    @Override
    public List<Course> getAllPassCourse() {
        return courseDao.getAllPassCourse();
    }

    @Override
    public int getAllCourseNum() {
        return courseDao.getAllCourseNum();
    }

    @Override
    public int getPassCourse() {
        return courseDao.getPassCourse();
    }

    @Override
    public String getCoursePicsbyid(int id) {
        return courseDao.getCoursePicsbyid(id);
    }

    @Override
    public List<Course> getGoodCourse() {
        return courseDao.goodCourses();
    }

    @Override
    public void upLoadDoc(Integer courseId,MultipartFile courseDoc) {
        Course course = courseDao.getCoursebyid(courseId);
        String newDocName = upLoad.updatePicName(courseDoc.getOriginalFilename());
        course.setCoursedoc(newDocName);
        String docStorePlace = "/WEB_RES/doc";
        upLoad.upLoad(courseDoc,newDocName,docStorePlace);
        courseDao.updateCourseinfo(course);
    }



    //------------------------------------
    @Override
    public List<String> getAllType1List() {
        List<String> allType1List = courseDao.getAllType1List();
        return allType1List;
    }

    @Override
    public List<Course> getTopCourse() {
        List<Course> courseList = new ArrayList<Course>();
        List<Integer> courseInteger = courseDao.getTopCourse();
        for(Integer tmp:courseInteger){
            courseList.add(courseDao.getCoursebyid(tmp));
        }
        return courseList;
    }



    @Override
    public List<Course> getCourseByType2(String type2, Integer pageNum) {
        Integer type2Id = courseDao.getTyp2IdByType2Name(type2);
        Integer type1Id = courseDao.getTyp1IdByType2Name(type2);
        List<Course> courseList = courseDao.getCByType12IdPage(type1Id,type2Id,(pageNum-1)*10);
        return courseList;
    }

    @Override
    public Page getCourseAllPageNum(String type2,Integer pageNum) {
//        Page page = new Page();
        Integer type2Id = courseDao.getTyp2IdByType2Name(type2);
        Integer type1Id = courseDao.getTyp1IdByType2Name(type2);
        Integer courpage = courseDao.getCourseAllPageNum(type1Id,type2Id);
        Integer courcount = (courpage/12)+1;        //对应课程总页数
        Page page = new Page(pageNum,courcount,0,0,0,0);
        //page对象赋值
//        page.setPageCount(courcount);
//        page.setPageNum(1);
//        if((courcount>10 && pageNum>5)&&(courcount-pageNum>5)){
//            page.setPreStart(pageNum-4);
//            page.setPreEnd(pageNum);
//            page.setNextStart(pageNum+1);
//            page.setNextEnd(pageNum+5);
//        }else if((courcount>10 && pageNum<=5)&&(courcount-pageNum>5)){
//            page.setPreStart(1);
//            page.setPreEnd(pageNum);
//            page.setNextStart(courcount-5);
//            page.setNextEnd(courcount);
//        }else if((courcount>10 && pageNum>5)&&(courcount-pageNum<=5)){
//            page.setPreStart(1);
//            page.setPreEnd(5);
//            page.setNextStart(pageNum);
//            page.setNextEnd(courcount);
//        }
        return page;
    }

    @Override
    public List<String> getCourseType2List(String type1) {
        List<String> courseType2List;
        if(type1==null){
            courseType2List = courseDao.getCourseType2List();     //获取type1id=1的type2List
        }else{
           courseType2List = courseDao.getCourseType2ListForType1(type1);    //获取特定type1的type2List
        }
        return courseType2List;
    }
}
