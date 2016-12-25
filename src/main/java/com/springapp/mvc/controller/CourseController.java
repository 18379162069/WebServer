package com.springapp.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.Lecturer;
import com.springapp.mvc.service.course.CourseService;
import com.springapp.mvc.service.lecturer.LecturerService;
import com.springapp.mvc.service.lecturer_course.Lecturer_CourseService;
import com.springapp.mvc.util.PicUpLoad;
import com.springapp.mvc.util.RequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by louie on 2016/2/1.
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {


    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private Lecturer_CourseService lecturer_courseService;

    @Autowired
    private CourseService courseService;


    @Autowired
    private RequestFactory Factory;

    /**
     * 课程信息页面
     *
     * @return
     */

    @RequestMapping(value = "/courseinfopage", method = RequestMethod.GET)
    public String lecturerlogpage(@RequestParam(value = "courseid") String courseid) {
        if (sessionCheck() || checkUserSession()) {
            int id = Integer.parseInt(courseid);
            Factory.getRequest().setAttribute("course", courseService.getCoursebyid(id));
            return "lecturer/lecturer-courseinfocheck";//跳转到课程信息页面
        }
        return "lecturer/LecturerLog";
    }

    /**
     * 跳转至课程更新界面
     *
     * @return
     */
    @RequestMapping(value = "/courseinfodatepage", method = RequestMethod.GET)
    public String courseinfoupdatepage(@RequestParam(value = "courseid") String courseid) {
        if (sessionCheck()) {
            int id = Integer.parseInt(courseid);
            Factory.getRequest().getSession().setAttribute("CourseId", id);
            Factory.getRequest().setAttribute("course", courseService.getCoursebyid(id));
            return "lecturer/lecturer-courseinfoupdate";//跳转到课程信息页面
        }
        return "lecturer/LecturerLog";
    }

    /**
     * 更新课程信息
     *
     * @return
     */
    @RequestMapping(value = "/courseinfoupdate", method = RequestMethod.GET)
    public String courseinfoUpdate(HttpServletRequest request) {
        if (sessionCheck()) {
            Course course = new Course();
//            System.out.println(request.getSession().getAttribute("CourseId"));
//            System.out.println(request.getParameter("coursename"));
            course = courseService.getCoursebyid(Integer.parseInt(request.getSession().getAttribute("CourseId").toString()));
            if (course == null) {
                System.out.println("----");
            } else {
                course.setCoursename(request.getParameter("coursename"));
                course.setCoursecheck(null);
//                course.setType1id(Integer.parseInt(request.getParameter("typ1id")));
//                course.setType2id(Integer.parseInt(request.getParameter("typ2id")));
//                course.setType3id(Integer.parseInt(request.getParameter("typ3id")));
                course.setCoursemode(request.getParameter("coursemode"));
                course.setCourselecturer(request.getParameter("courselecturer"));
                course.setCoursetime(request.getParameter("coursetime"));
                course.setCourseperiod(request.getParameter("courseperiod"));
                course.setCoursemaxstu(Integer.parseInt(request.getParameter("coursemaxstu")));
                course.setCourseprice(Integer.parseInt(request.getParameter("courseprice")));
                course.setCoursedescription(request.getParameter("lecturerdescription"));
                courseService.updateCourseinfo(course);
                Factory.getRequest().setAttribute("course", courseService.getCoursebyid(course.getId()));
                return "lecturer/lecturer-courseinfocheck";
            }

        }
        return "lecturer/LecturerLog";

    }




    /**
     * 教师删除未通过审核的课程
     *
     * @return
     */
    @RequestMapping(value = "coursedelete", method = RequestMethod.GET)
    public String courseDelete() {
        if (sessionCheck()) {
            Course course = courseService.getCoursebyid(Integer.parseInt(Factory.getRequest().getParameter("courseid").toString()));
            course.setCoursecheck("-1");
            courseService.updateCourseinfo(course);
            return "lecturer/lecturer-backgroundpage";
        } else
            return "lecturer/LecturerLog";

    }

    /**
     * 上传课程文档页面
     *
     * @return
     */
    @RequestMapping(value = "coursedocuploadpage", method = RequestMethod.GET)
    public String coursedocuploadpage(@RequestParam(value = "courseid") String courseid) {
        if (sessionCheck()) {
            Course course = courseService.getCoursebyid(Integer.parseInt(courseid));
            Factory.getRequest().setAttribute("course", course);
            return "lecturer/lecturer-courseinfocheckuploaddoc";
        } else
            return "lecturer/LecturerLog";
    }

    /**
     * 上传课程文档
     *
     * @return
     */
    @RequestMapping(value = "/coursedocupload", method = RequestMethod.POST)
    public String coursedocupload(@RequestParam(value = "coursedoc", required = false) MultipartFile coursedoc, @RequestParam(value = "courseid") Integer courseid) {
        if (sessionCheck()) {
            courseService.upLoadDoc(courseid, coursedoc);
            return "#";
        } else
            return "#";
    }

    /**
     * 课程主页
     *
     * @return
     */
    @RequestMapping(value = "/coursemainpage")
    public String courseMainpage() {
        return "course/coursemainpage";
    }


    public boolean sessionCheck() {
        String lecturer = (String) Factory.getRequest().getSession().getAttribute("lectureraccount");
        if (lecturer != null)
            return true;
        else
            return false;
    }

    public boolean checkUserSession() {
        String user = (String) Factory.getRequest().getSession().getAttribute("userAccount");
        if (user != null) {
            return true;
        } else return false;
    }





//    ---------------------

    /**
     * 申请课程表页面
     */
    @RequestMapping(value = "courseapplicationpage", method = RequestMethod.GET)
    public String courseApplicationPage(Model model) {
        List<String> type1List = courseService.getAllType1List();
        model.addAttribute("type1List",type1List);
        return "lecturer/lecturer-courseapplication";
    }
    //获取课程类型2的数据
    @RequestMapping(value = "getCourseType2List")
    @ResponseBody
    public String getCourseType2List(@RequestParam(value = "type1",required = false)String type1){
        List<String> courseType2List = courseService.getCourseType2List(type1);
        return JSON.toJSONString(courseType2List);
    }


    /**
     * 申请课程
     *
     * @return
     */
    @RequestMapping(value = "courseapplication", method = RequestMethod.POST)
    public String courseApplication(@ModelAttribute Course course, @RequestParam(value = "pic", required = false) MultipartFile pic,
                                    @RequestParam("type1Name")String type1Name,@RequestParam("type2Name")String type2Name) {
        System.out.println("--dfs");
        if (sessionCheck()) {
            System.out.println(course.getCoursename());
            course.setLectureremail(lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString()).getLectureremail());
            courseService.insertCourse(course, pic,type1Name,type2Name);
            lecturer_courseService.addL_CNexus(lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString()).getId(),course.getId());
            return "lecturer/lecturer-courseinfo";
        }
        return "lecturer/LecturerLog";
    }




}
