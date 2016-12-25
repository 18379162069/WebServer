package com.springapp.mvc.controller;

import com.springapp.mvc.pojo.*;
import com.springapp.mvc.service.admin.AdminService;
import com.springapp.mvc.service.course.CourseService;
import com.springapp.mvc.service.mainpage.MainpageService;
import com.springapp.mvc.service.service.ServiceService;
import com.springapp.mvc.service.superadmin.SuperAdminService;
import com.springapp.mvc.service.web.WebService;
import com.springapp.mvc.util.AjaxObject;
import com.springapp.mvc.util.PicUpLoad;
import com.springapp.mvc.util.RequestFactory;
import com.springapp.mvc.util.StringRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.modelmbean.ModelMBean;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

/**
 * Created by louie on 2016/2/1.
 */
@Controller
@RequestMapping(value = "/superadmin")
public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private MainpageService mainpageService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private WebService webService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private RequestFactory Factory;


    PicUpLoad picUpLoad;

    @RequestMapping(value = "/superadminLogPage")
    public String test() {
        return "superadmin/superadminLog";//跳转到超级管理员后台界面
    }

    //超级管理员登入
    @RequestMapping(value = "/superadminLog", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("superadminaccount") String superadminaccount, @RequestParam("superadminpassword") String superadminpassword) {
        boolean flag = superAdminService.superAdminCheck(superadminaccount, superadminpassword);
        if (flag) {
            Factory.getRequest().getSession().setAttribute("superadminaccount", superadminaccount); //登陆成功设置管理员账号为session
            return "superadmin/superadmin-stage";   //返回管理界面
        } else
            return "superadmin/superadminLog";      //返回登陆界面
    }
    @RequestMapping(value = "superadmin_stage")
    public String superadmin_stage(){
        if(!checkSession()){
            return "superadmin/superadmin-stage";   //返回管理界面
        }else
            return "superadmin/superadminLog";      //返回登陆界面
    }

    /**
     * 跳转至公司更新主页信息页面
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "updatewebpage")
    private String updatewebpage(Model model) {
        if (!checkSession()) {
            model.addAttribute("webPage", webService.getWebPageInfo());
            return "superadmin/superadmin-webpageinfoupdate";
        } else
            return "superadmin/superadminLog";      //返回登陆界面

    }

    /**
     * 更新主页信息
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/updatemainpage", method = RequestMethod.POST)
    public String updatemainpage(@ModelAttribute WebPage webPage, Model model) {
        if (!checkSession()) {
            WebPage oldWebPage = webService.getWebPageInfo();
            webPage.setCompanyLogo(oldWebPage.getCompanyLogo());
            webPage.setCooperation(oldWebPage.getCooperation());
            webPage.setLuboPics(oldWebPage.getLuboPics());
            webService.updateCompanyInfo(webPage);
            model.addAttribute(webPage);
            return updatewebpage(model);
        } else
            return "superadmin/superadminLog";      //返回登陆界面
    }

    /**
     * 跳转至轮播跟新页面
     *
     * @return
     */
    @RequestMapping(value = "updatelunbopage")
    public String updatelunbopage(Model model) {
        if (!checkSession()) {

            return "superadmin/superadmin-updatelunbopic";
        }
        return "superadmin/superadminLog";      //返回登陆界面
    }

    /**
     * 更新主页轮播图片
     *
     * @return
     */
    @RequestMapping(value = "updatemainpic", method = RequestMethod.POST)
    public String updatemainpic(@RequestParam("picnum") Integer picnum, @RequestParam(value = "pic") MultipartFile pic, Model model) {
        if (!checkSession()) {
            webService.updatemainpagepic(pic, picnum);
            return updatelunbopage(model);

        }
        return "superadmin/superadminLog";      //返回登陆界面
    }

    //超级管理员注销
    @RequestMapping(value = "/superadminLogOut")
    public String superadminLoginOut() {
        Factory.getRequest().getSession().setAttribute("superadminaccount", null);
        return "superadmin/superadminLog";
    }

    //管理员检测账号
    @RequestMapping(value = "/adminCheck", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String adminCheck(@RequestParam("adminaccount") String adminaccount) {
        boolean flag = adminService.checkAdmin(adminaccount);
        return AjaxObject.toJson(flag);
    }

    /**
     * 跳转至管理员注册界面
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "insertadmin_page")
    public String insertadmin_page(Model model) {
        if (!checkSession()) {
            return "superadmin/superadmin-addadmin";
        } else
            return "superadmin/superadminLog";      //返回登陆界面
    }


    //管理员注册
    @RequestMapping(value = "/adminReg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    //@ResponseBody
    public String adminReg(Model model, @RequestParam("adminaccount") String adminaccount, @RequestParam("adminpassword") String adminpassword) {
        if (!checkSession()) {
            adminService.insertAdmin(adminaccount, adminpassword);
            return adminlistpage(model);
        } else
            return "superadmin/superadminLog";      //返回登陆界面

    }

    /**
     * 管理员列表界面
     *
     * @param
     * @return
     */
    @RequestMapping(value = "adminlistpage")
    public String adminlistpage(Model model) {
        if (!checkSession()) {
            model.addAttribute("adminList", adminService.getAllAdmin());
            return "superadmin/adminList";
        } else
            return "superadmin/superadminLog";      //返回登陆return "superadmin/superadminLog";      //返回登陆界面界面
    }

    //删除管理员
    @RequestMapping(value = "/delteadmin", method = RequestMethod.GET)
    public String deleteAdmin(Model model, @RequestParam("adminaccount") String adminaccount) {
        if (!checkSession()) {
            adminService.deleteAdmin(adminaccount);
            model.addAttribute("adminList", adminService.getAllAdmin());
            return adminlistpage(model);
        } else
            return "superadmin/superadminLog";      //返回登陆return "superadmin/superadminLog";

    }


    /**
     * 跳转至合作伙伴更新页面
     *
     * @return
     */
    @RequestMapping(value = "cooperation_page")
    public String cooperation_page(Model model) {
        if (!checkSession()) {
            List<String> cooperation = webService.getCompanyCoops();
            model.addAttribute("cooperation", cooperation);
            return "superadmin/superadmin-updatecooperation";
        } else
            return "superadmin/superadminLog";      //返回登陆界面


    }

    /**
     * 更改合作伙伴名称
     *
     * @return
     */
    @RequestMapping(value = "cooperation_update", method = RequestMethod.POST)
    public String cooperation_update(Model model, @RequestParam("cooperationname") String cooperationname, @RequestParam("cooperationnum") Integer cooperationnum) {
        if (!checkSession()) {
            webService.updateCooperation(cooperationname, cooperationnum);
            List<String> cooperation = webService.getCompanyCoops();
            model.addAttribute("cooperation", cooperation);
            return cooperation_page(model);
        } else
            return "superadmin/superadminLog";      //返回登陆界面

    }


    public boolean checkSession() {
        String superadmin = (String) Factory.getRequest().getSession().getAttribute("superadminaccount");
        if (superadmin == null) {
            return true;
        } else return false;
    }
}
