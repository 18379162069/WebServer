package com.springapp.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.springapp.mvc.pojo.Course;
import com.springapp.mvc.pojo.LastedNews;
import com.springapp.mvc.pojo.Service;
import com.springapp.mvc.service.companyuser.CompanyUserService;
import com.springapp.mvc.service.course.CourseService;
import com.springapp.mvc.service.lecturer.LecturerService;
import com.springapp.mvc.service.service.ServiceService;
import com.springapp.mvc.service.user.UserService;
import com.springapp.mvc.service.web.WebService;
import com.springapp.mvc.util.FileIO;
import com.springapp.mvc.util.Page;
import com.springapp.mvc.util.RequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by louie on 2016/2/28.
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CompanyUserService companyUserService;
    @Autowired
    private FileIO fileIO;
    @Autowired
    private WebService webService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RequestFactory Factory;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private UserService userService;

    //填充首页内容
    @RequestMapping(value = "/gotoIndex", method = RequestMethod.GET)
    public String gotoIndex(Model model) {
        String companyLogo = webService.getCompanyLogo();
        String companyIntroduce = webService.getCompanyIntroduce();
        List<String> cooperation = webService.getCompanyCoops();
        List<Course> courseList = courseService.getTopCourse();
        List<Service> serviceList = companyUserService.getTopService();
        List<LastedNews> newsList = companyUserService.getTopNews();
        List<String> lunboPicList = webService.getLunboPicList();
        model.addAttribute("cooperation", cooperation);
        model.addAttribute("companyLogo", companyLogo);
        model.addAttribute("courseList", courseList);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("newsList", newsList);
        model.addAttribute("lunboPicList", lunboPicList);
        model.addAttribute("companyIntroduce", companyIntroduce);
        return "main/index";
    }

    //读取图片
    @RequestMapping(value = "/getPic/{imgType}/{imgName:.+}", method = RequestMethod.GET, produces = {"image/jpeg", "image/png"})
    @ResponseBody
    public byte[] getPic(@PathVariable("imgType") String imgType, @PathVariable("imgName") String imgName) {
        byte[] fileIOStream = new byte[0];
        if (imgType.equals("lunboImg")) {
            fileIOStream = webService.getInputStream(imgName, "lunbo_pic");
        } else if (imgType.equals("courseImg")) {
            fileIOStream = webService.getInputStream(imgName, "course_pic");
        } else if (imgType.equals("serviceImg")) {
            fileIOStream = webService.getInputStream(imgName, "service_pic");
        } else if (imgType.equals("newsImg")) {
            fileIOStream = webService.getInputStream(imgName, "news_pic");
        } else if (imgType.equals("logoImg")) {
            fileIOStream = webService.getInputStream(imgName, "logo_pic");
        }
        return fileIOStream;
    }
    //联系我们提交表单
    @RequestMapping(value = "contactUs",method = RequestMethod.GET)
    public String contactUs(){
        return "main/contactus";
    }
    //课程培训界面
    @RequestMapping(value = "/coursePage", method = RequestMethod.GET)
    public String gotoCoursePage(Model model) {
        List<String> type1List = courseService.getAllType1List();
        List<Course> courseList = courseService.getTopCourse();

        model.addAttribute("type1List", type1List);
        model.addAttribute("courseList", courseList);
        return "main/courpage";
    }
    //课程：为type1获取type2的list
    @RequestMapping(value = "/getType2For1", method = RequestMethod.GET)
    @ResponseBody
    public String getType2For1(@RequestParam("index") Integer index) {
        List<String> type2List = webService.getType2For1(index);
        String s = JSON.toJSONString(type2List);
        return s;
    }
    //课程：取出type2的课程表
    @RequestMapping(value = "/getTyp2V", method = RequestMethod.GET)
    public String getTyp2V(Model model, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam("type2") String type2) {
        List<String> type1List = courseService.getAllType1List();
        Page page;
        List<Course> courseList;
        if (pageNum == null) {
            pageNum = 1;
            page = courseService.getCourseAllPageNum(type2, pageNum);
            courseList = courseService.getCourseByType2(type2, pageNum);
        } else {
            courseList = courseService.getCourseByType2(type2, pageNum);
            page = courseService.getCourseAllPageNum(type2, pageNum);

        }
        Factory.getRequest().getSession().setAttribute("type2", type2);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("page", page);
        model.addAttribute("type1List", type1List);
        model.addAttribute("courseList", courseList);
        return "main/courpage";
    }
    //课程详情页面展示
    @RequestMapping(value = "/getCourseInfo", method = RequestMethod.GET)
    public String getCourseInfo(Model model, @RequestParam("courseId") Integer courseId) {
        Course course = courseService.getCoursebyid(courseId);
        String lecturerDescription = lecturerService.getLecturerByCourseEmail(course.getLectureremail());
        model.addAttribute("course", course);
        model.addAttribute("lecturerDescription", lecturerDescription);
        return "main/course_info";
    }


    //业务展示界面
    @RequestMapping(value = "/servicePage", method = RequestMethod.GET)
    public String gotoServicePage(Model model) {
        List<String> type1List = serviceService.getAllType1List();
        List<Service> serviceList = serviceService.getTopService();

        model.addAttribute("type1List", type1List);
        model.addAttribute("serviceList", serviceList);
        return "main/servpage";
    }
    //业务：为type1获取type2的list
    @RequestMapping(value = "/getType2For1Service", method = RequestMethod.GET)
    @ResponseBody
    public String getType2For1Service(@RequestParam("index") Integer index) {
        List<String> type2List = serviceService.getType2For1(index);
        String s = JSON.toJSONString(type2List);
        return s;
    }
    //业务：取出type2的课程表
    @RequestMapping(value = "/getTyp2ServieList", method = RequestMethod.GET)
    public String getTyp2ServieList(Model model, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam("type2") String type2) {
        List<String> type1List = serviceService.getAllType1List();
        Page page;
        List<Service> serviceList;
        if (pageNum == null) {
            pageNum = 1;
            page = courseService.getCourseAllPageNum(type2, pageNum);
            serviceList = serviceService.getServiceByType2(type2, pageNum);
        } else {
            serviceList = serviceService.getServiceByType2(type2, pageNum);
            page = courseService.getCourseAllPageNum(type2, pageNum);

        }
        Factory.getRequest().getSession().setAttribute("type2", type2);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("page", page);
        model.addAttribute("type1List", type1List);
        model.addAttribute("serviceList", serviceList);
        return "main/servpage";
    }
    //业务详情页面展示
    @RequestMapping(value = "/getServiceInfo", method = RequestMethod.GET)
    public String getServiceInfo(Model model, @RequestParam("serviceId") Integer id) {
        Service service = serviceService.searchServicebyid(id);
        model.addAttribute("service", service);
        return "main/service_info";
    }


    //用户提交申请
    @RequestMapping(value = "userAddService",method = RequestMethod.POST)
    public String userAddService(Model model,@RequestParam("")String subject,@RequestParam("content")String content){
        userService.addService(subject,content);
        return "main/index";
    }

}
