package com.springapp.mvc.controller;

import com.springapp.mvc.pojo.*;
import com.springapp.mvc.service.course.CourseService;
import com.springapp.mvc.service.lastednews.LastedNewsService;
import com.springapp.mvc.service.lecturer.LecturerService;
import com.springapp.mvc.service.lecturer_course.Lecturer_CourseService;
import com.springapp.mvc.service.user.UserService;
import com.springapp.mvc.service.user_course.User_CourseService;
import com.springapp.mvc.util.AjaxObject;
import com.springapp.mvc.util.PicUpLoad;
import com.springapp.mvc.util.RequestFactory;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 2016/2/1.
 */
@Controller
@RequestMapping(value = "/lecturer")
public class LecturerController {


    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private Lecturer_CourseService lecturer_courseService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private LastedNewsService lastedNewsService;

    @Autowired
    private User_CourseService user_courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private RequestFactory Factory;

    /**
     * 讲师登陆界面
     *
     * @return
     */
    @RequestMapping(value = "/lecturerlogpage", method = RequestMethod.GET)
    public String lecturerlogpage() {
        return "lecturer/LecturerLog";//跳转到讲师后台登陆界面
    }

    /**
     * 讲师登陆json传值
     *
     * @param lectureraccount
     * @param lecturerpassword
     * @return
     */
    @RequestMapping(value = "/lecturerLog", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String lecturerLog(@RequestParam("lectureraccount") String lectureraccount, @RequestParam("lecturerpassword") String lecturerpassword) {
        boolean flag = lecturerService.matchingLecture(lectureraccount, lecturerpassword);
        System.out.println(flag);
        if (flag) {
            Factory.getRequest().getSession().setAttribute("lectureraccount", lectureraccount);
        }
        return AjaxObject.toJson(flag);
    }

    @RequestMapping(value = "/lectureraccountcheck", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String lecturerAccountCheck(@RequestParam("lectureraccount") String lectureraccount) {
        boolean flag = lecturerService.matchingLecturerAccount(lectureraccount);
        return AjaxObject.toJson(flag);
    }

    /**
     * 讲师注册页面
     *
     * @return
     */

    @RequestMapping(value = "/lecturerregisterpage", method = RequestMethod.GET)
    public String lecturerregisterpage() {
        return "lecturer/lecturer-registerpage";
    }


    /**
     * 讲师添加
     */

    @RequestMapping(value = "/lecturerregister", method = RequestMethod.POST)
    @ResponseBody
    public String lecturerregister(@RequestParam("lectureraccount") String lectureraccount, @RequestParam("lecturername") String lecturername, @RequestParam("lecturerpassword") String lecturerpassword, @RequestParam("lectureremail") String lectureremail, @RequestParam("lectureretel") String lectureretel) {
        System.out.println(lecturername);
        Lecturer lecturer = new Lecturer();
        lecturer.setLectureraccount(lectureraccount);
        lecturer.setLecturername(lecturername);
        lecturer.setLecturerpassword(lecturerpassword);
        lecturer.setLectureremail(lectureremail);
        lecturer.setLecturertel(lectureretel);
        boolean flag = lecturerService.insertLecturer(lecturer);
        return AjaxObject.toJson(flag);
    }


    /**
     * 邮箱检测
     *
     * @return
     */
    @RequestMapping(value = "updatelectureremailcheck", method = RequestMethod.POST)
    @ResponseBody
    public String updatelecturerEmailCheck(@RequestParam(value = "lectureremail") String lectureremail) {
        Lecturer lecturer=lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString());
        boolean flag = lecturerService.updatechecklectureremail( lecturer.getId(),lectureremail);
        return AjaxObject.toJson(flag);



    }



    /**
     * 邮箱检测
     *
     * @return
     */
    @RequestMapping(value = "lectureremailcheck", method = RequestMethod.POST)
    @ResponseBody
    public String lecturerEmailCheck(@RequestParam(value = "lectureremail") String lectureremail) {
        boolean flag = lecturerService.checklectureremail(lectureremail);
        return AjaxObject.toJson(flag);


    }


    /**
     * 手机号码检测
     *
     * @return
     */
    @RequestMapping(value = "lecturertelcheck", method = RequestMethod.POST)
    @ResponseBody
    public String lecturerTelCheck(@RequestParam(value = "lecturertel") String lecturertel) {
        boolean flag = lecturerService.checklecturertel(lecturertel);
        return AjaxObject.toJson(flag);

    }

    /*
     * 讲师后台主页
     *
     * @return
     */
    @RequestMapping(value = "/lecturerBGPage", method = RequestMethod.GET)
    public String test() {
        return "lecturer/lecturer-backgroundpage";//跳转到讲师后台界面
    }

    /**
     * 讲师个人信息界面
     *
     * @return
     */
    @RequestMapping(value = "/lecturerInfoPage", method = RequestMethod.GET)
    public String lecturerInfoPage(Model model) {
        if (!checkSession()) {
            return "lecturer/LecturerLog";
        }
        Lecturer lecturer = lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString());
        model.addAttribute("lecturer", lecturer);
        return "lecturer/lecturer-infoupdate";
    }
    /**
     * 讲师更新个人信息
     *
     * @return
     */
    @RequestMapping(value = "/lecturerupdateinfopage", method = RequestMethod.POST)
    public String lecturerUpdateInfoPage(@ModelAttribute Lecturer lecturer, Model model) {
        if (checkSession()) {
            System.out.println(lecturer.toString());
            Lecturer lecturer1;
            lecturer1 = lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString());
            lecturer.setLectureraccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString());
            lecturer.setLecturerpassword(lecturer1.getLecturerpassword());
            lecturer.setLecturerrank(lecturer1.getLecturerrank());
            lecturer.setLecturercheck(lecturer1.getLecturercheck());
            lecturer.setLecturertel(lecturer1.getLecturertel());
            lecturer.setId(lecturer1.getId());
           lecturerService.updatelecturerbyid(lecturer);
            model.addAttribute("lecturer", lecturer);
            return lecturerInfoPage(model);              //修改之后需要重新等待管理员验证
        } else
            return "lecturer/LecturerLog";


    }

    /**
     * 讲师名下课程列表页面
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/lecturercourseinfopage", method = RequestMethod.GET)
    public String lecturerCourseInfoPage(HttpServletRequest request) {
        if (checkSession()) {
            Lecturer lecturer = lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString());
            List<Course> lecturercourseList = new ArrayList<Course>();
            lecturercourseList = courseService.getAllLecturerByEmail(lecturer.getLectureremail());
            System.out.println(lecturer.getLectureremail());
            System.out.println(lecturercourseList.size());
            List<Course> passcourseList = new ArrayList<Course>();
            List<Course> unpasscourseList = new ArrayList<Course>();
            if (lecturercourseList.size() != 0) {
                for (int i = 0; i < lecturercourseList.size(); i++) {
                    if (courseService.courseCheck(lecturercourseList.get(i).getId()) == null)
                        unpasscourseList.add(courseService.getCoursebyid(lecturercourseList.get(i).getId()));


                    else if (courseService.courseCheck(lecturercourseList.get(i).getId()).equals("1")) {
                        passcourseList.add(courseService.getCoursebyid(lecturercourseList.get(i).getId()));
                    }
                }

                request.setAttribute("passcourseList_LcturerPageList", passcourseList);                              //通过课程列表
                request.setAttribute("unpasscourseList_LcturerPageList", unpasscourseList);                          //未通过课程列表
            }
            return "lecturer/lecturer-courseinfo";
        } else
            return "lecturer/LecturerLog";
    }

    /**
     * 跳转至增加咨询
     *
     * @return
     */
    @RequestMapping(value = "/lastednewspage", method = RequestMethod.GET)
    public String lastedNewsPage() {
        return "lecturer/lastedNewsPage";
    }

    /**
     * 新增咨询
     *
     * @return
     */
    @RequestMapping(value = "/insertelastednews", method = RequestMethod.GET)
    public String insertelastedNews(HttpServletRequest request) {
        if (checkSession()) {
            LastedNews lastedNews = new LastedNews();
            request.getParameter("courseid");
            lastedNews.setNewsname(request.getParameter("newsname"));
            lastedNews.setNewscontent(request.getParameter("newscontent"));
            lastedNews.setNewscheck(null);
            lastedNewsService.insertlastedNews(lastedNews);
            return "#";

        } else
            return "lecturer/LecturerLog";

    }

    /**
     * 咨询图片上传
     *
     * @return
     */
    @RequestMapping(value = "insertelastednewspic", method = RequestMethod.POST)
    public String inserteNewspic(@RequestParam(value = "newspic") MultipartFile newspic) {
        if (checkSession()) {
            PicUpLoad picUpLoad = new PicUpLoad();
            String picStorePlace = "picture/newspic/";
            String newPicNmae = picUpLoad.updatePicName(newspic.getOriginalFilename());
            picUpLoad.upLoad(newspic, newPicNmae, picStorePlace);
            return "";
        } else
            return "#";
    }
    /**
     * 跳至课程学生管理页面
     *
     * @return
     */
    @RequestMapping(value = "coursestudentpage", method = RequestMethod.GET)
    public String coursestudentpage(HttpServletRequest request) {
        if (checkSession()) {
            int lecturerid = lecturerService.searchLecturerbyAccount(Factory.getRequest().getSession().getAttribute("lectureraccount").toString()).getId();
            List<Lecturer_Course> lecturer_courseList = new ArrayList<Lecturer_Course>();
            lecturer_courseList = lecturer_courseService.getL_CNexusbyLecturerid(lecturerid);
            List<Course> passcourseList = new ArrayList<Course>();
            List<Course> unpasscourseList = new ArrayList<Course>();
            if (lecturer_courseList.size() != 0) {
                for (int i = 0; i < lecturer_courseList.size(); i++) {
                    if (courseService.courseCheck(lecturer_courseList.get(i).getCourseid()) == null)
                        unpasscourseList.add(courseService.getCoursebyid(lecturer_courseList.get(i).getCourseid()));


                    else if (courseService.courseCheck(lecturer_courseList.get(i).getCourseid()).equals("1")) {
                        passcourseList.add(courseService.getCoursebyid(lecturer_courseList.get(i).getCourseid()));
                    }
                }

                request.setAttribute("passcourseList_LcturerPageList", passcourseList);                              //通过课程列表
                request.setAttribute("unpasscourseList_LcturerPageList", unpasscourseList);                          //未通过课程列表
            }
            return "lecturer/lecturer-studentpage";
        } else
            return "lecturer/LecturerLog";
    }

    /**
     * 跳转至特定的课程学生列表页面
     */
    @RequestMapping(value = "coursestudentlistpage", method = RequestMethod.GET)
    public String coursestudentlistpage(@RequestParam("courseid") String courseid) {
        if (checkSession()) {
            List<User_Course> user_courseList = new ArrayList<User_Course>();
            user_courseList = user_courseService.getU_CListBycourseid(Integer.parseInt(courseid));
            List<User> studentpay_YList = new ArrayList<User>();                         //已经支付学生
//            List<User> studentpay_NList = new ArrayList<User>();                        //未支付学生
            if (user_courseList.size() != 0) {
                for (int i = 0; i < user_courseList.size(); i++) {
                    studentpay_YList.add(userService.getUserById(user_courseList.get(i).getUserid()));
                }

            }
            Factory.getRequest().setAttribute("studentpay_YList",studentpay_YList);
            return "lecturer/lecturer-studentlistpage";
        } else return "lecturer/LecturerLog";
    }
    @RequestMapping(value = "/lecturerLogOut", method = RequestMethod.GET)
    public String lecturerLogOut(){
        if (!checkSession()){
            return "lecturer/LecturerLog";
        }
        Factory.getRequest().getSession().setAttribute("lectureraccount",null);
        return "lecturer/LecturerLog";
    }







    //增加课程类型
    @RequestMapping(value = "addCourseType",method = RequestMethod.POST)
    @ResponseBody
    public String addCourseType(@RequestParam("type1Name")String type1Name,@RequestParam("type2Name")String type2Name){
        //通过type2name一定不能有重复的
        System.out.println(type1Name+"//"+type2Name);
        boolean flag= lecturerService.insertServiceType(type1Name,type2Name);
        return AjaxObject.toJson(flag);
    }


    public boolean checkSession() {
        String lecturer = (String) Factory.getRequest().getSession().getAttribute("lectureraccount");
        if (lecturer != null) {
            return true;
        } else return false;
    }
}
