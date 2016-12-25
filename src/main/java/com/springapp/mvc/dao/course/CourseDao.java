package com.springapp.mvc.dao.course;

import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.TypeCheck;

import java.util.List;

/**
 * Created by Administrator on 2016/2/13 0013.
 */
public interface CourseDao {
    public int insertCourse(Course course);            //插入新课程
    public int deleteCoursebyid(int id);               //通过id删除课程信息
    public int updateCourseinfo(Course course);        //更新课程信息
    public int updateCoursePic(int id, String cpics);           //更新课程图片
    public int changeCourseCheck(int id, String coursecheck); //修改课程审核情况
    public Course getCoursebyid(int id);                //通过id准确查找课程信息
    public List<Course> getCoursebyname(String coursename);    //通过课程名字模糊查询
    public List<Course> getAllPassCourse();              //获得所有通过审核课程的信息
    public int getAllCourseNum();                       //获得所有课程数量
    public int getPassCourse();                         //获得所有通过审核的课程
    public String getCoursePicsbyid(int id);            //根据课程id获取课程图片
    public List<Course> goodCourses();                  //根据收藏量获取候选热门课程
    public String courseCheck(int courseid);              //查看课程审核情况
    public List<Course> getAllLecturerByEmail(String lecturerEmail); //通过讲师email获取lecturer课程



    //--------------------------------------
    public List<Integer> getTopCourse();      //获取top课程
    public List<String> getAllType1List();      //获取所有的类型1
    public Integer getTyp2IdByType2Name(String type2); //获取符合type2的课程
    public Integer getTyp1IdByType2Name(String type2);   //在typetable中找出type1id通过type2name
    public List<Course> getCByType12Id(Integer type1,Integer type2);  //在course中选出type1,type2的课程
    public List<Course> getCByType12IdPage(Integer type1,Integer type2,Integer pageNum);
    public Integer getCourseAllPageNum(Integer type1,Integer type2);
    public List<String> getCourseType2List();      //获取type1id=1的type2List
    public List<String> getCourseType2ListForType1(String type1);  //获取特定type1的type2List
    public Integer getType1IdByType1Name(String type2Name);
    public Integer getLastType2IdByType1Name(String type1Name);
    public TypeCheck getCheckTypeById(Integer id);
    public void addCourseType(Integer type1id,String type1Name,Integer type2id,String type2Name);
}
