package com.springapp.mvc.controller;

import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;
import com.springapp.mvc.pojo.*;
import com.springapp.mvc.service.admin.AdminService;
import com.springapp.mvc.service.companyuser.CompanyUserService;
import com.springapp.mvc.service.lecturer.LecturerService;
import com.springapp.mvc.util.AjaxObject;
import com.springapp.mvc.util.Doc2Img;
import com.springapp.mvc.util.RequestFactory;
import com.springapp.mvc.util.RootPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by louie on 2016/2/1.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private Doc2Img doc2Img;
    @Autowired
    private AdminService adminService;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private CompanyUserService companyUserService;
    @Autowired
    private RequestFactory Factory;
    @Autowired
    private RootPath Path;

    //跳转页面
    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public String goToPage(@PathVariable String page) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        return "admin/" + page;
    }

    @RequestMapping(value = "/adminLogPage", method = RequestMethod.GET)
    public String test() {
        return "admin/adminLog";//跳转到后台界面
    }

    //管理员首页（获取后台首页数据）
    @RequestMapping(value = "/adminIndex", method = RequestMethod.GET)
    public String adminIndex(Model model) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        Map<String, Integer> map = adminService.getAdminIndexCount();
        int courseDocCount = map.get("courseDocCount");
        int courseCheckCount = map.get("courseCheckCount");
        int serviceCheckCount = map.get("serviceCheckCount");
        int companyCheckCount = map.get("companyCheckCount");
        int lecturerCheckCount = map.get("lecturerCheckCount");
        int newsCheckCount = map.get("newsCheckCount");

        model.addAttribute("courseDocCount", courseDocCount);
        model.addAttribute("courseCheckCount", courseCheckCount);
        model.addAttribute("serviceCheckCount", serviceCheckCount);
        model.addAttribute("companyCheckCount", companyCheckCount);
        model.addAttribute("lecturerCheckCount", lecturerCheckCount);
        model.addAttribute("newsCheckCount", newsCheckCount);

        return "admin/admin-stage";//跳转到后台界面

    }


    //个人讲师审核列表
    @RequestMapping(value = "/lecturerApplCheckList", method = RequestMethod.GET)
    public String lecturerApplCheck(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        List<Lecturer> lecturerList;
        if (pageNo == null) {
            lecturerList = adminService.getNoCheckL(0);
        } else {
            lecturerList = adminService.getNoCheckL(pageNo);
        }
        model.addAttribute("lecturerList", lecturerList);
        return "admin/lecturer-application-checklist";
    }

    //个人讲师理由
    @RequestMapping(value = "/getLecturerById", method = RequestMethod.GET)
    public String getLecturerById(Model model, @RequestParam(value = "id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        Lecturer lecturer = lecturerService.searchLecturerByid(id);
        model.addAttribute("lecturer", lecturer);
        return "admin/application-reason-lecturer";
    }

    //个人讲师通过审核
    @RequestMapping(value = "/agrLApplById", method = RequestMethod.GET)
    public String agrLApplById(Model model, @RequestParam(value = "id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        lecturerService.changeLecturerCheck(id);
        return lecturerApplCheck(model, 0);
    }

    //个人讲师没通过审核
    @RequestMapping(value = "/delLApplById", method = RequestMethod.GET)
    public String delLApplById(Model model, @RequestParam(value = "id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        lecturerService.deleteLecturerById(id);
        return lecturerApplCheck(model, 0);
    }


    //获取企业详细申请信息
    @RequestMapping(value = "/getCReasonById", method = RequestMethod.GET)
    public String getCReasonById(Model model, @RequestParam("id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        CompanyApplication companyApplObj = companyUserService.getReasonById(id);
        model.addAttribute("companyApplObj", companyApplObj);
        return "admin/application-reason-company";
    }

    //删除企业申请
    @RequestMapping(value = "/delApplById", method = RequestMethod.GET)
    public String delApplById(Model model, @RequestParam("id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        companyUserService.delApplById(id);
        return companyUserApplCheck(model);
    }

    //企业信息审核
    @RequestMapping(value = "/companyUserApplCheckList", method = RequestMethod.GET)
    public String companyUserApplCheck(Model model) {
        List<CompanyApplication> companyUserApplList;
        if (checkSession()) {
            return "admin/adminLog";
        }
        companyUserApplList = companyUserService.getAllCAppl();
        model.addAttribute("companyUserApplList", companyUserApplList);
        return "admin/company-application-checklist";
    }


    //课程信息审核列表
    @RequestMapping(value = "/courseCheckList", method = RequestMethod.GET)
    public String courseCheckList(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
        List<Course> courseList;
        if (checkSession()) {
            return "admin/adminLog";
        }
        if (pageNo == null) {
            courseList = adminService.getNoCheckCourse(0);
        } else {
            courseList = adminService.getNoCheckCourse(pageNo);
        }
        model.addAttribute("courseList", courseList);
        model.addAttribute("pageNo", pageNo);
        return "admin/course-checklist";
    }

    //课程信息
    @RequestMapping(value = "/courseCheckInfo", method = RequestMethod.GET)
    public String courseCheck(Model model, @RequestParam(value = "id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        Course course = adminService.getCourseById(id);
        model.addAttribute("course", course);
        return "admin/course-info";
    }

    //课程信息通过
    @RequestMapping(value = "/agrCourseCheck", method = RequestMethod.GET)
    public String agrCourseCheck(Model model, @RequestParam(value = "id") int id) {
        lecturerService.changeCourseCheck(id);
        return courseCheckList(model, 0);
    }

    //课程信息不通过
    @RequestMapping(value = "/notAgrCourseCheck", method = RequestMethod.GET)
    public String notAgrCourseCheck(Model model, @RequestParam(value = "id") int id) {
        lecturerService.notAgrCourseCheck(id);
        return courseCheckList(model, 0);
    }

    //课程信息同意删除
    @RequestMapping(value = "/agrDelCourse", method = RequestMethod.GET)
    public String agrDelCourse(Model model, @RequestParam("id") int id) {
        adminService.agrDelCourse(id);
        return courseCheckList(model, null);
    }


    //业务信息审核列表
    @RequestMapping(value = "/serviceCheckList", method = RequestMethod.GET)
    public String serviceCheckList(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
        List<Service> serviceList;
        if (checkSession()) {
            return "admin/adminLog";
        }
        if (pageNo == null) {
            serviceList = adminService.getNoCheckService(0);
        } else {
            serviceList = adminService.getNoCheckService(pageNo);
        }
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("pageNo", pageNo);
        return "admin/service-checklist";
    }

    //业务信息详情
    @RequestMapping(value = "/serviceCheckInfo", method = RequestMethod.GET)
    public String serviceCheckInfo(Model model, @RequestParam(value = "id") int id) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        Service service = companyUserService.getServiceById(id);
        model.addAttribute("service", service);
        return "admin/service-info";
    }

    //业务信息通过
    @RequestMapping(value = "/agrServiceCheck", method = RequestMethod.GET)
    public String agrServiceCheck(Model model, @RequestParam(value = "id") int id) {
        companyUserService.changeServiceCheck(id);
        return serviceCheckList(model, 0);
    }

    //业务信息不通过
    @RequestMapping(value = "/notAgrServiceCheck", method = RequestMethod.GET)
    public String notAgrServiceCheck(Model model, @RequestParam(value = "id") int id) {
        companyUserService.notAgrServiceCheck(id);
        return serviceCheckList(model, 0);
    }

    //业务信息同意删除
    @RequestMapping(value = "/agrDelService", method = RequestMethod.GET)
    public String agrDelService(Model model, @RequestParam(value = "id") int id) {
        companyUserService.agrDelService(id);
        return serviceCheckList(model, 0);
    }


    //开班文档审核
    @RequestMapping(value = "/courseDocCheckList", method = RequestMethod.GET)
    public String courseDocCheckList(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
        List<Course> courseDocList;
        if (checkSession()) {
            return "admin/adminLog";
        }
        if (pageNo == null) {
            courseDocList = adminService.getNoCheckCourseDoc(0);
        } else {
            courseDocList = adminService.getNoCheckCourseDoc(pageNo);
        }
        model.addAttribute("courseDocList", courseDocList);
        model.addAttribute("pageNo", pageNo);
        return "admin/coursedoc-check";
    }

    //文档详情
    @RequestMapping(value = "/courseDocCheck", method = RequestMethod.GET)
    public String courseDocCheck(Model model, @RequestParam("id") int id) {
        List<String> list = new ArrayList<String>();
        Course course = adminService.getCourseById(id);
        String path = Path.RootPath() + "WEB_RES/doc/" + course.getCoursedoc();
//        String path = "C:\\Users\\louie\\Desktop\\Demo\\WEB_RES\\doc\\208b598f-8661-4005-b778-2fee0d1d38fc.doc";
        String[] strings = doc2Img.convertDocument(path);
        for (String s : strings) {
            System.out.println(s);
            list.add(s);
        }
        model.addAttribute("id",id);
        model.addAttribute("picList", list);
        return "admin/detail";
    }

    //预览文档
    @RequestMapping(value = "/getDocPic/{imgFile}/{imgName:.+}", method = RequestMethod.GET, produces = {"image/jpeg", "image/png"})
    @ResponseBody
    public byte[] getDocPic(@PathVariable("imgFile")String imgFile,@PathVariable("imgName")String imgName) {
        byte[] fileIOStream;
        fileIOStream = adminService.getInputStream(imgFile,imgName);
        return fileIOStream;
    }

    //文档审核通过
    @RequestMapping(value = "/agrCourseDocCheck", method = RequestMethod.GET)
    public String agrCourseDocCheck(Model model, @RequestParam("id") Integer id) throws GeneralSecurityException, MessagingException {
        adminService.agrCourseDocCheck(id);
        return courseDocCheckList(model,null);
    }

    //文档审核不通过
    @RequestMapping(value = "/notAgrCourseDocCheck", method = RequestMethod.GET)
    public String notAgrCourseDocCheck(Model model, @RequestParam("id") Integer id) {
        adminService.notAgrCourseDocCheck(id);
        return courseDocCheckList(model,null);
    }


    //最新资讯审核
    @RequestMapping(value = "/newsCheckList", method = RequestMethod.GET)
    public String newsCheckList(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
        List<LastedNews> newsList;
        if (checkSession()) {
            return "admin/adminLog";
        }
        if (pageNo == null) {
            newsList = adminService.getNoCheckNews(0);
        } else {
            newsList = adminService.getNoCheckNews(pageNo);
        }
        model.addAttribute("newsList", newsList);
        model.addAttribute("pageNo", pageNo);
        return "admin/news-checklist";
    }

    //资讯内容列表
    @RequestMapping(value = "/newsContentCheckList", method = RequestMethod.GET)
    public String newsContentCheckList(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
        List<LastedNews> newsList;
        if (checkSession()) {
            return "admin/adminLog";
        }
        if (pageNo == null) {
            newsList = adminService.getNoCheckNewsContent(0);
        } else {
            newsList = adminService.getNoCheckNewsContent(pageNo);
        }
        model.addAttribute("newsList", newsList);
        model.addAttribute("pageNo", pageNo);
        return "admin/newscontent-checklist";
    }

    //资讯详情
    @RequestMapping(value = "/newsCheckInfo", method = RequestMethod.GET)
    public String newsCheckInfo(Model model, @RequestParam("id") int id) {
        LastedNews news = companyUserService.getNewsById(id);
        model.addAttribute("news", news);
        return "admin/news-info";
    }

    //资讯内容审核
    @RequestMapping(value = "/newsContentCheckInfo", method = RequestMethod.GET)
    public String newsContentCheckInfo(Model model, @RequestParam("id") int id) {
        LastedNews news = companyUserService.getNewsById(id);
        model.addAttribute("news", news);
        return "admin/newscontent-info";
    }

    //资讯通过审核
    @RequestMapping(value = "/agrNewsCheck", method = RequestMethod.GET)
    public String agrNewsCheck(Model model, @RequestParam(value = "id") int id) throws GeneralSecurityException, MessagingException {
        companyUserService.changeNewsCheck(id);
        companyUserService.sendEmail(id);
        return newsContentCheckList(model, 0);
    }

    //资讯不通过审核
    @RequestMapping(value = "/notAgrNewsCheck", method = RequestMethod.GET)
    public String notAgrNewsCheck(Model model, @RequestParam(value = "id") int id) {
        companyUserService.notAgrNewsCheck(id);
        return newsContentCheckList(model, 0);
    }

    //资讯内容详情审核
    @RequestMapping(value = "/agrNewsContentCheck", method = RequestMethod.GET)
    public String agrNewsContentCheck(Model model, @RequestParam(value = "id") int id) throws GeneralSecurityException, MessagingException {
        companyUserService.agrNewsContentCheck(id);
        return newsContentCheckList(model, 0);
    }

    //资讯内容审核不通过
    @RequestMapping(value = "/notAgrNewsContentCheck", method = RequestMethod.GET)
    public String notAgrNewsContentCheck(Model model, @RequestParam(value = "id") int id) {
        companyUserService.notAgrNewsContentCheck(id);
        return newsContentCheckList(model, 0);
    }


    //管理员登入
    @RequestMapping(value = "/adminLog", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("adminaccount") String adminaccount, @RequestParam("adminpassword") String adminpassword) {
        boolean flag = adminService.matchingAdmin(adminaccount, adminpassword);
        if (flag) {
            Factory.getRequest().getSession().setAttribute("adminaccount", adminaccount); //登陆成功设置管理员账号为session
            return "admin/admin-stage";
        } else
            return "admin/adminLog";
    }

    //管理员注销
    @RequestMapping(value = "/adminLogOut", method = RequestMethod.GET)
    public String adminLoginOut() {
        Factory.getRequest().getSession().setAttribute("adminaccount", null);
        return "admin/adminLog";
    }

    //管理员检测账号
    @RequestMapping(value = "/adminCheck", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String adminCheck(@RequestParam("adminaccount") String adminaccount) {
        boolean flag = adminService.checkAdmin(adminaccount);
        return AjaxObject.toJson(flag);
    }

    //管理员注册
    @RequestMapping(value = "/adminReg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String adminReg(@RequestParam("adminaccount") String adminaccount, @RequestParam("adminpassword") String adminpassword) {

        adminService.insertAdmin(adminaccount, adminpassword);
        boolean flag = true;
        return AjaxObject.toJson(flag);
    }


    //资讯跳转到ueditor页面
    @RequestMapping(value = "/goToUeditor", method = RequestMethod.GET)
    public String goToUeditor(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return "admin/pub-news";
    }

    //发布资讯
    @RequestMapping(value = "/adminPubNews", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String adminPubNews(@RequestParam("news") String news, @RequestParam("id") Integer id) throws GeneralSecurityException, MessagingException {
        boolean flag = adminService.sendToEmail(news, id);
        return AjaxObject.toJson(flag);
    }

    //资讯列表
    @RequestMapping(value = "/newsList", method = RequestMethod.GET)
    public String newsList(Model model) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        List<LastedNews> newsList = adminService.getAllNewsList();
        model.addAttribute("newsList", newsList);
        return "admin/news-list";
    }

    //添加资讯
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public String addNews(Model model, @ModelAttribute LastedNews lastNews, @RequestParam(value = "pic", required = false) MultipartFile pic) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        adminService.addNews(lastNews, pic);
        List<LastedNews> newsList = adminService.getAllNewsList();
        model.addAttribute("newsList", newsList);
        return "admin/news-list";
    }



    //课程类型审核
    @RequestMapping(value = "courseTypeCheckList",method = RequestMethod.GET)
    public String courseTypeCheckList(Model model){
        List<TypeCheck> courseTypeCheckList = adminService.courseTypeCheckList();
        model.addAttribute("courseTypeCheckList",courseTypeCheckList);
        return "admin/course-addType-checkList";
    }
    //课程类型通过审核
    @RequestMapping(value = "argCourseTypeCheck",method = RequestMethod.GET)
    public String argCourseTypeCheck(Model model,@RequestParam("id")Integer id,@RequestParam("agree")String agree){
        if (checkSession()) {
            return "admin/adminLog";
        }
        adminService.argCourseTypeCheck(id,agree);
        return courseTypeCheckList(model);
    }
    //业务类型审核
    @RequestMapping(value = "serviceTypeCheckList",method = RequestMethod.GET)
    public String serviceTypeCheckList(Model model){
        if (checkSession()) {
            return "admin/adminLog";
        }
        List<TypeCheck> serviceTypeCheckList = adminService.serviceTypeCheckList();
        model.addAttribute("serviceTypeCheckList",serviceTypeCheckList);
        return "admin/service-addType-checkList";
    }
    //业务类型通过审核
    @RequestMapping(value = "argServiceTypeCheck",method = RequestMethod.GET)
    public String argServiceTypeCheck(Model model,@RequestParam("id")Integer id,@RequestParam("agree")String agree){
        adminService.argServiceTypeCheck(id,agree);
        return serviceTypeCheckList(model);
    }
    public boolean checkSession() {
        String admin = (String) Factory.getRequest().getSession().getAttribute("adminaccount");
        if (admin == null) {
            return true;
        } else return false;
    }
}
