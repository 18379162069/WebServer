package com.springapp.mvc.service.course;

import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.Service;
import com.springapp.mvc.util.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2016/2/13 0013.
 */
public interface CourseService {
    public boolean insertCourse(Course course,MultipartFile pic,String type1Name,String type2Name);            //插入新课程
    public boolean deleteCoursebyid(int id);               //通过id删除课程信息
    public boolean updateCourseinfo(Course course);        //更新课程信息
    public boolean updateCoursePic(int id, String cpics);           //更新课程图片
    public boolean changeCourseCheck(int id, String coursecheck); //修改课程审核情况
    public String courseCheck(int courseid);               //获得课程审核情况
    public Course getCoursebyid(int id);                //通过id准确查找课程信息
    public List<Course> getCoursebyname(String coursename);    //通过课程名字模糊查询
    public List<Course> getAllPassCourse();              //获得所有通过审核课程的信息
    public int getAllCourseNum();                       //获得所有课程数量
    public int getPassCourse();                         //获得所有通过审核的课程
    public String getCoursePicsbyid(int id);            //根据课程id获取课程图片
    public List<Course> getGoodCourse();                 //获取收藏量大于500的课程
    public void upLoadDoc(Integer courseId,MultipartFile courseDoc);

    public List<Course> getAllLecturerByEmail(String lecturerEmail); //通过讲师email获取lecturer课程



    //---------------------------------------------------------------
    public List<String> getAllType1List();
    public List<Course> getTopCourse();
//    public List<Course> getCourseByType2(String type2);
    public List<Course> getCourseByType2(String type2,Integer pageNum);
    public Page getCourseAllPageNum(String type2,Integer pageNum);
    public List<String> getCourseType2List(String type1);
}
