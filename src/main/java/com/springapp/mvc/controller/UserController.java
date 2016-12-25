package com.springapp.mvc.controller;

import com.springapp.mvc.javasms.SMS;
import com.springapp.mvc.pojo.*;
import com.springapp.mvc.service.course.CourseService;
import com.springapp.mvc.service.coursepurchase.CoursePurchaseService;
import com.springapp.mvc.service.lastednews.LastedNewsService;
import com.springapp.mvc.service.lecturer.LecturerService;
import com.springapp.mvc.service.lecturer_course.Lecturer_CourseService;
import com.springapp.mvc.service.service.ServiceService;
import com.springapp.mvc.service.user.UserService;
import com.springapp.mvc.service.user_course.User_CourseService;
import com.springapp.mvc.service.user_news.User_NewsService;
import com.springapp.mvc.service.user_service.User_ServiceService;
import com.springapp.mvc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 2016/2/1.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private User_CourseService user_courseService;

    @Autowired
    private SMS sms;
    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CoursePurchaseService coursePurchaseService;

    @Autowired
    private Lecturer_CourseService lecturer_courseService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private RequestFactory Factory;

    @Autowired
    private User_ServiceService user_serviceService;

    @Autowired
    private LastedNewsService lastedNewsService;

    @Autowired
    private User_NewsService user_newsService;





    @RequestMapping(value = "/page/{page}",method = RequestMethod.GET)
    public String goTo(@PathVariable("page")String page){
        return "user/"+page;
    }
    //获取短信验证码
    @RequestMapping(value = "/getSMS",method = RequestMethod.POST)
    public void getSMS(@RequestParam("tel")String tel){
        sms.sendSMS(tel);
    }
    //清空session中短信验证码
    @RequestMapping(value = "/delSMS",method = RequestMethod.GET)
    public void delSMS(){
        Factory.getRequest().getSession().setAttribute("code",null);
    }

    //检查用户手机号是否重复
    @RequestMapping(value = "userTelCheck", method = RequestMethod.GET)
    @ResponseBody
    public String userTelCheck(@RequestParam(value = "userTel") String userTel){
        System.out.println(userTel);
        boolean flag = userService.userTelCheck(userTel);
        if(flag){
            Factory.getRequest().getSession().setAttribute("userTel",userTel);
        }
        return AjaxObject.toJson(flag);
    }


    // 用户EMail重复检测
    @RequestMapping(value = "userEmailCheck", method = RequestMethod.GET)
    @ResponseBody
    public String userEmailCheck(@RequestParam(value = "email") String email) {
        return AjaxObject.toJson(userService.userEmailcheck(email));
    }

    //添加用户信息
    @RequestMapping(value = "insertUser", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("user")User user){
        System.out.println(user.toString());
        userService.insertUser(user);
        return "user/userMainPages";
    }

    //检测验证码
    @RequestMapping(value = "checkVerify", method = RequestMethod.POST)
    @ResponseBody
    public String checkVerify(@RequestParam("verify")String verify,@RequestParam("userTel")String userTel){
        boolean flag = false;
        String phone = (String) Factory.getRequest().getSession().getAttribute("userTel");
        String smscode = (String) Factory.getRequest().getSession().getAttribute("code");
        if(phone.equals(userTel)  && smscode.equals(verify)){
            flag = true;
            return AjaxObject.toJson(flag);
        }else{
            return AjaxObject.toJson(flag);
        }
    }

    /**
     * 用户账号检测
     */
    @RequestMapping(value = "userLogCheck", method = RequestMethod.GET)
    @ResponseBody
    public String userLogCheck(@RequestParam(value = "usertel") String usertel, @RequestParam(value = "userpassword") String userpassword) {
        User user = new User();
        user.setUsertel(usertel);
        System.out.println(usertel);
        user.setUserpassword(userpassword);
        System.out.println( user.getUserpassword());
        boolean flag = userService.loginUserbytel(user);
        user.setUseremail(usertel);
        user.setUserpassword(userpassword);
        boolean flag1 = userService.loginUserbyemail(user);
        if (flag || flag1) {
            if(userService.searchUserbytel(usertel)!=null) {
                Factory.getRequest().setAttribute("user", userService.searchUserbytel(usertel));
            }else{
                Factory.getRequest().setAttribute("user", userService.searchUserbyemail(usertel));
            }
            if(flag){
                System.out.println(usertel+"---");
                user=userService.searchUserbytel(usertel);
                Factory.getRequest().getSession().setAttribute("userId", user.getId().toString());
                Factory.getRequest().getSession().setAttribute("userAccount", user.getUseremail());

            }else if(flag1){
                System.out.println(usertel+"+++");
                user=userService.searchUserbyemail(usertel);
                Factory.getRequest().getSession().setAttribute("userId", user.getId().toString());
                Factory.getRequest().getSession().setAttribute("userAccount", user.getUseremail());
            }

            boolean flag2 = flag||flag1;
            return AjaxObject.toJson(flag2);
        }
        return AjaxObject.toJson(flag);
    }


    //用户退出
    @RequestMapping(value = "userLogOut")
    public String userLogOut(){
        Factory.getRequest().getSession().setAttribute("user",null);
        Factory.getRequest().getSession().setAttribute("userAccount",null);
        Factory.getRequest().getSession().setAttribute("userId",null);
        return "main/index";
    }


//    ------------------------------------------------------------------------


    /**
     * 用户登陆界面
     *
     * @return
     */

    @RequestMapping(method = RequestMethod.GET)
    public String test() {

        return "user/userLogin";
    }

    /**
     * 用户账号重复检测
     */
    @RequestMapping(value = "useraccountCheck", method = RequestMethod.GET)
    @ResponseBody
    public String useraccountCheck(@RequestParam(value = "useraccount") String useraccount) {
        return AjaxObject.toJson(userService.useraccountcheck(useraccount));
    }



    /**
     * 用户注册界面
     */
    @RequestMapping(value = "userRegisterPage", method = RequestMethod.GET)
    public String userRegisterPage() {
        return "user/userRegisterPage";
    }

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping(value = "userregister", method = RequestMethod.GET)
    @ResponseBody
    public String userRegisterpage(@RequestParam(value = "useraccount") String useraccount, @RequestParam(value = "userpassword") String userpassword, @RequestParam(value = "useremail") String useremail, @RequestParam(value = "usertel") String usertel) {
        User user = new User();
        boolean flag = true;
        if (userService.usertelCheck(usertel)) {
            flag = false;
            return AjaxObject.toJson(flag);
        } else {
            user.setUsertel(usertel);
            user.setUseremail(useremail);
            user.setUserpassword(userpassword);
            user.setUsername(useraccount);
            return AjaxObject.toJson(userService.insertUser(user));
        }
    }

    /**
     * 用户主页
     */
    @RequestMapping(value = "usermainpage")
    public String usermianpage() {
        if (checkSession()) {
            return "user/userMainPages";
        } else
            return "user/userLogin";
    }

    /**
     * 用户个信息主页
     *
     * @return
     */
    @RequestMapping(value = "userinfoupdatepage", method = RequestMethod.GET)
    public String userMainPage(Model model) {
        if (checkSession()) {
            User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            model.addAttribute("user", user);
            return "user/user-infoupdatepage";
        } else
            return "user/userLogin";
    }

    /**
     * 更新用户头像
     *
     * @return
     */
    @RequestMapping(value = "updateavatar", method = RequestMethod.POST)
    public String updateAvatar(@RequestParam(value = "useravatar") MultipartFile useravatar) {
        if (checkSession()) {
            User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            PicUpLoad picUpLoad = new PicUpLoad();
            String picStorePlace = "picture/newspic/";
            String newPicNmae = picUpLoad.updatePicName(useravatar.getOriginalFilename());
            user.setUserimage(newPicNmae);
            userService.updateUser(user);
            picUpLoad.upLoad(useravatar, newPicNmae, picStorePlace);
            return "";
        } else
            return "user/userLogin";

    }

    /**
     * 课程信息页面
     */
    @RequestMapping(value = "courseListpage")
    public String usercourseListpage() {
        if (checkSession()) {
            User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            List<Course> courseList = new ArrayList<Course>();
            courseList = userService.getUserAllCourse(user.getId());
            Factory.getRequest().setAttribute("courseList", courseList);
            return "user/usercourseListPage";

        } else
            return "user/userLogin";
    }

    /**
     * 用户添加课程
     *
     * @return
     */
    @RequestMapping(value = "useraddcourse", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String useraddcourse(@RequestParam("userid") String userid, @RequestParam("courseid") String courseid) {
        boolean flag = user_courseService.checkUserCourse(Integer.parseInt(userid), Integer.parseInt(courseid));  //true 为已选课程 false 为未选课程
        if (!flag && userid != null && courseid != null && checkTrade(Integer.parseInt(courseid))) {
            user_courseService.insertU_CNexus(Integer.parseInt(userid), Integer.parseInt(courseid));

            return AjaxObject.toJson(flag);
        } else
            return AjaxObject.toJson(flag);
    }

    /**
     * 收藏业务
     */
    @RequestMapping(value = "coursecollection", method = RequestMethod.POST)
    public String coursecollection(@RequestParam("serviceid") String serviceid) {
        if (checkSession()) {
            User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            if (user_serviceService.inserteU_SNexus(user.getId(), Integer.parseInt(serviceid)))
                return "successpage";
            else
                return "cfbuypage";
        } else
            return "user/userLogin";


    }

    /**
     * 用户删除课程
     *
     * @return
     */
    @RequestMapping(value = "userdeletecourse", method = RequestMethod.POST)
    @ResponseBody
    public String userdeletecourse(@RequestParam(value = "userid") String userid, @RequestParam(value = "courseid") String courseid) {
        boolean flag = false;
        if (userid != null && courseid != null) {
            flag = user_courseService.deleteU_CNexus(Integer.parseInt(userid), Integer.parseInt(courseid));
            return AjaxObject.toJson(flag);
        } else {
            return AjaxObject.toJson(flag);
        }

    }

    /**
     * 用户信息更新
     *
     * @return
     */
    @RequestMapping(value = "userinfoupade", method = RequestMethod.POST)
    public String userinfoupdate(@ModelAttribute("user") User user, Model model) {
//        System.out.println(user+"--f");
//        System.out.println(user.getUseremail()+"-0-0");


        if (checkSession()) {
//            System.out.println(user.getUseremail()+"-0-0");
            User user1 = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            user1.setId(user.getId());
            System.out.println(user1.getUsertel());
            user1.setUsername(user.getUsername());
            user1.setUserrank(user.getUserrank());
            user1.setUseremail(user.getUseremail());
            user1.setUsercompany(user.getUsercompany());
            user1.setUserjob(user.getUserjob());
            userService.updateUser(user1);
            model.addAttribute("user", user1);
            return "user/user-infoupdatepage";
        } else {
            System.out.println("-ffsf");
            return "user/userLogin";
        }

    }

    /**
     * 购买课程界面
     */
    @RequestMapping(value = "buycoursepage")
    public String buyCoursepage() {
        return "course/buycoursepage";
    }

    @RequestMapping(value = "updateuseremialcheck",method = RequestMethod.GET)
    @ResponseBody
    public String updateuseremialcheck(@RequestParam("email")String useremail){
        int userid=Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString());
        User user=userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
        boolean flag=userService.updateuseremailcheck(user.getId(),useremail);
        return AjaxObject.toJson(flag);
    }


    /**
     * 成功购买课程
     */
    @RequestMapping(value = "buyCourseSuccess", method = RequestMethod.POST)
    public String buyCourse(@RequestParam("courseorderid") String courseorderid, @RequestParam("courseid") String courseid) {
        if (checkSession()) {
            if (!this.checkTrade(Integer.parseInt(courseid))) {
                CoursePurchase coursePurchase = this.addCoursePurchaseinfo(Integer.parseInt(courseid), courseorderid);
                user_courseService.insertU_CNexus(userService.searchUserbyemail(Factory.getRequest().getSession().getAttribute("userAccount").toString()).getId(), Integer.parseInt(courseid)); //根据session Useraccount得到userid 并且插入到用户课程表
                boolean flag = coursePurchaseService.addNewCoursePurchase(coursePurchase);
                return "successfulpage";                       //跳转至支付成功界面
            } else
                return "cfbuypage";                              //跳转至重复购买界面
        } else
            return "user/userLogin";


    }

    /**
     * 跳转用户订阅业务页面
     *
     * @return
     */
    @RequestMapping(value = "usercollectionservice")
    public String usercollectionService() {
        if (checkSession()) {
            List<User_Service> user_services = new ArrayList<User_Service>();
            User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            if (user_serviceService.getListByUserId(user.getId()) != null) {
                List<Service> services = new ArrayList<Service>();
                user_services = user_serviceService.getListByUserId(user.getId());                                    //获取用户订阅的所有业务id
                for (int i = 0; i < user_services.size(); i++) {
                    services.add(serviceService.searchServicebyid(user_services.get(i).getServiceid()));
                }
                Factory.getRequest().setAttribute("serviceList", services);
                return "user/usercollectionListPage";
            }

            return "user/usercollectionListPage";
        }
        return "user/userLogin";

    }

    /**
     * 跳转至资讯页面
     */
    @RequestMapping(value = "newspage", method = RequestMethod.GET)
    public String newsPage() {
        if (checkSession()) {
            User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
            if(this.getUserLastdNews(user.getId())!=null){
                Factory.getRequest().setAttribute("lastedNewsList",this.getUserLastdNews(user.getId()));
            }
            return "user/newsListPage";
        }else
            return "user/userLogin";
    }


    /**
     * 通过课程id获取讲师信息
     * 相关表L_C 表 不能为空
     *
     * @param courseid
     * @return
     */
    public Lecturer getLecturerByCourseid(int courseid) {
        int lecturerid = lecturer_courseService.getLecturerByCourseid(courseid);         //在课程讲师表要存在相应的关系
        if (lecturerService.searchLecturerByid(lecturerid) != null)
            return lecturerService.searchLecturerByid(lecturerid);
        else
            return null;
    }

    /**
     * 检测用户是否已经购买该课程
     *
     * @return
     */
    private boolean checkTrade(int courseid) {

        User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
        int userid=user.getId();
        List<Course> allusercourse = new ArrayList<Course>();
        allusercourse = userService.getUserAllCourse(userid);                                                    //获取用户所有课程
        for (int i = 0; i < allusercourse.size(); i++) {
            if (allusercourse.get(i).getId() == courseid) {
                return true;
            }
        }

        return false;
    }

    /**
     * 课程购买记录填写
     *
     * @return
     */
    private CoursePurchase addCoursePurchaseinfo(int courseid, String orderid) {
        CoursePurchase coursePurchase = new CoursePurchase();
        String useraccount = Factory.getRequest().getSession().getAttribute("userAccount").toString();          //获取用户账号（手机号码）
        coursePurchase.setUserid(userService.searchUserbyemail(useraccount).getId());
        coursePurchase.setCourseid(courseid);
        coursePurchase.setLecturerid(this.getLecturerByCourseid(courseid).getId());
        coursePurchase.setPurchasetime(NowDate.getNowDate());
        coursePurchase.setPurchaseprice(courseService.getCoursebyid(courseid).getCourseprice().toString());
        coursePurchase.setStarttime(courseService.getCoursebyid(courseid).getCoursetime());
        coursePurchase.setOrderid(orderid);
        coursePurchase.setOrderstate("1");
        return coursePurchase;
    }

    /**
     * 获取用户的咨询
     * @return
     */
    public List<LastedNews> getUserLastdNews(int userid){
        User user = userService.getUserById(Integer.parseInt(Factory.getRequest().getSession().getAttribute("userId").toString()));
        List<User_News> user_newsList=new ArrayList<User_News>();
        List<LastedNews> lastedNewsList=new ArrayList<LastedNews>();
        user_newsList=user_newsService.getListByUserId(user.getId());
        if(user_newsList!=null){
            for(int i=0;i<user_newsList.size();i++){
                if(lastedNewsService.getlastedNewsbyid(user_newsList.get(i).getNewsid())!=null)
                lastedNewsList.add(lastedNewsService.getlastedNewsbyid(user_newsList.get(i).getNewsid()));
            }
            if(lastedNewsList!=null)
                return lastedNewsList;
            else
                return null;
        }
        else
            return null;

    }


    public boolean checkSession() {
        String user =(String) Factory.getRequest().getSession().getAttribute("userId");
        if (user != null) {
            return true;
        } else return false;
    }


}
