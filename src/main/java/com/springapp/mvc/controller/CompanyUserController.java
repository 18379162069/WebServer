package com.springapp.mvc.controller;

import com.springapp.mvc.pojo.CompanyUser;
import com.springapp.mvc.pojo.LastedNews;
import com.springapp.mvc.pojo.Service;
import com.springapp.mvc.service.companyuser.CompanyUserService;
import com.springapp.mvc.util.AjaxObject;
import com.springapp.mvc.util.RequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by louie on 2016/2/11.
 */
@Controller
@RequestMapping(value = "/companyuser")
public class CompanyUserController {

    @Autowired
    private CompanyUserService companyUserService;

    @Autowired
    private RequestFactory Factory;

    //进入企业用户后台
    @RequestMapping(value = "/companyuserLog", method = RequestMethod.GET)
    public String companyuserLog() {
        return "companyuser/companyuser-log";
    }

    //跳转页面
    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public String goToPage(Model model, @PathVariable String page, @RequestParam(value = "id", required = false) Integer id) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        if (id != null) {
            model.addAttribute("id", id);
        }
        return page;
    }


    //企业用户登入检验
    @RequestMapping(value = "/checkAccount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String checkAccount(@RequestParam("account") String account, @RequestParam("password") String password) {
        boolean flag = companyUserService.checkAccount(account, password);
        Factory.getRequest().getSession().setAttribute("companyuser", account);
        return AjaxObject.toJson(flag);
    }

    //企业用户填写申请
    @RequestMapping(value = "/companyUserAppl", method = RequestMethod.POST)
    public String companyUserAppl(@RequestParam("companyUserName") String companyUserName, @RequestParam("applicationReason") String applicationReason, @RequestParam("companyUserEmail") String companyUserEmail, @RequestParam("companyUserTel") String companyUserTel) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        companyUserService.companyUserAppl(companyUserName, applicationReason, companyUserEmail, companyUserTel);
        return null;
    }

    //查看企业用户账号是否存在
    @RequestMapping(value = "/accountIsExits", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String accountIsExits(@RequestParam("account") String account) {
        boolean flag = companyUserService.accountIsExits(account);
        return AjaxObject.toJson(flag);
    }

    //添加企业用户
    @RequestMapping(value = "/addCompanyUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addCompanyUser(@RequestParam("account") String account, @RequestParam("password") String password) {
        boolean flag = companyUserService.addCompanyUser(account, password);
        return AjaxObject.toJson(flag);
    }

    //删除企业用户
    @RequestMapping(value = "/delCompanyUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delCompanyUser(@RequestParam("id") int id) {
        companyUserService.delCompanyUser(id);
        boolean flag = true;
        return AjaxObject.toJson(flag);
    }


    //查看企业用户列表  （需要添加分页）
    @RequestMapping(value = "/listCompanyUser", method = RequestMethod.GET)
    public String listCompanyUser(Model model) {
        List<CompanyUser> companyUserList = companyUserService.listCompanyUser();
        model.addAttribute("companyUserList", companyUserList);
        return "admin/company-user-list";
    }
    //跳转到更新企业会员信息界面
    @RequestMapping(value = "/editCompanyUserPage", method = RequestMethod.GET)
    public String editCompanyUserPage(Model model){
        CompanyUser companyUser = companyUserService.getMyselfObj();
        model.addAttribute("companyUser",companyUser);
        return "companyuser/companyuser-info";
    }
    //更改企业会员信息
    @RequestMapping(value = "/editCompanyUser", method = RequestMethod.POST)
    public String editCompanyUser(Model model,@ModelAttribute("companyUser") CompanyUser companyUser) {
        if(checkSession()){
            return "companyuser/companyuser-log";
        }
        companyUserService.editCompanyUser(companyUser);
        return companyIndex(model,null);
    }


//    //显示业务列表
//    @RequestMapping(value = "/listService", method = RequestMethod.POST)
//    public String listService(Model model) {
//        if (checkSession()) {
//            return "companyuser/companyuser-log";
//        }
//        List<Service> serviceList = companyUserService.listService();
//        model.addAttribute("serviceList", serviceList);
//        return "service-list";
//    }

    //业务显示列表   列出type1类型   //列出对应的业务
    @RequestMapping(value = "/companyIndex", method = RequestMethod.GET)
    public String companyIndex(Model model, @RequestParam(value = "type", required = false) String type) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        List<Service> serviceList;
        if (type == null) {
            type = "网站建设/UI设计";
            serviceList = companyUserService.getType1Service(type);
        } else {
            serviceList = companyUserService.getType1Service(type);
        }
        List<String> type1List = companyUserService.getType1ListById();
        model.addAttribute("type1List", type1List);
        model.addAttribute("serviceList", serviceList);
        return "companyuser/companyuser-stage";
    }
    //显示业务
    @RequestMapping(value = "/showService", method = RequestMethod.GET)
    public String showService(Model model, @RequestParam("id") Integer id) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        Service service = companyUserService.showService(id);
        model.addAttribute("service", service);
        return "companyuser/edit-service";
    }
    //添加业务界面内容填充
    @RequestMapping(value = "/addServicePage", method = RequestMethod.GET)
    public String addServicePge(Model model) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        List<String> allType1List = companyUserService.getAllType1List();
        List<String> specType2List = companyUserService.getSpecType2List();

        model.addAttribute("type1List", allType1List);
        model.addAttribute("type2List", specType2List);

        return "companyuser/add-service";
    }
    //ajax请求分类
    @RequestMapping(value = "/getNextTypeList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getNextTypeList(@RequestParam("dataType") String dataType, @RequestParam(value = "dataType2", required = false) String dataType2) {
        String jsonTypeList = companyUserService.getNextTypeList(dataType, dataType2);
        System.out.println(jsonTypeList);
        return jsonTypeList;
    }


    //添加业务
    @RequestMapping(value = "/addService", method = RequestMethod.POST)
    public String addService(Model model, @ModelAttribute("service") Service service, @RequestParam("pic") MultipartFile pic, @RequestParam("type1") String type1, @RequestParam("type2") String type2) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        companyUserService.addService(service, pic, type1, type2);
        return companyIndex(model, null);
    }
    //编辑业务
    @RequestMapping(value = "/editService", method = RequestMethod.POST)
    @ResponseBody
    public String editService(Model model, @RequestParam("id") Integer id, @RequestParam("content") String content) {
        if (checkSession()) {
            return "companyuser-log";
        }
        companyUserService.editService(id, content);
        boolean flag = true;
        return AjaxObject.toJson(flag);
    }
    //删除业务
    @RequestMapping(value = "/delService", method = RequestMethod.GET)
    public String delService(Model model, @RequestParam("id") Integer id) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        companyUserService.delService(id);
        return companyIndex(model, null);
    }


    //列出该公司对应的资讯列表
    @RequestMapping(value = "/newsList", method = RequestMethod.GET)
    public String newsList(Model model) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        List<LastedNews> newsList = companyUserService.getMyNewsList();
        model.addAttribute("newsList", newsList);
        return "companyuser/news-list";
    }

    //发布资讯页面内容填充
    @RequestMapping(value = "/pubNewsPage", method = RequestMethod.GET)
    public String pubNewsPage(Model model, @RequestParam("id") Integer id) {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
//        List<String> newsTypeList = companyUserService.getNewsTypeList();
//        model.addAttribute("newsTypeList",newsTypeList);
        LastedNews lastedNews = companyUserService.getNewsById(id);
        model.addAttribute("lastedNews", lastedNews);
        return "companyuser/pub-news";
    }
    //添加资讯项
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public String addNews(Model model, @ModelAttribute LastedNews lastNews, @RequestParam(value = "pic", required = false) MultipartFile pic) {
        if (checkSession()) {
            return "admin/adminLog";
        }
        companyUserService.addNews(lastNews, pic);
        List<LastedNews> newsList = companyUserService.getMyNewsList();
        model.addAttribute("newsList", newsList);
        return "companyuser/news-list";
    }
    //发布资讯
    @RequestMapping(value = "/pubNews", method = RequestMethod.POST)
    public String pubNews(Model model, @ModelAttribute("lastedNews") LastedNews lastedNews) {
        System.out.println(lastedNews.toString());
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        companyUserService.pubNews(lastedNews);
        return newsList(model);
    }
    //注销
    @RequestMapping(value = "/companyuserLogOut", method = RequestMethod.GET)
    public String companyuserLogOut() {
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        Factory.getRequest().getSession().setAttribute("companyuser", null);
        return "companyuser/companyuser-log";
    }


    //增加业务类型界面
    @RequestMapping(value = "/addServiceTypePage")
    public String addServiceTypePage(Model model){
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        List<String> type1List = companyUserService.getAllType1List();
        model.addAttribute("type1List",type1List);
        return "companyuser/add-servic-type";
    }
    //增加业务类型
    @RequestMapping(value = "addServiceType",method = RequestMethod.POST)
    @ResponseBody
    public String addServiceType(@RequestParam("type1Name")String type1Name,@RequestParam("type2Name")String type2Name){
        //通过type2name一定不能有重复的
        if (checkSession()) {
            return "companyuser/companyuser-log";
        }
        System.out.println(type1Name+"//"+type2Name);
        boolean flag= companyUserService.insertServiceType(type1Name,type2Name);
        return AjaxObject.toJson(flag);
    }
    public boolean checkSession() {
        String admin = (String) Factory.getRequest().getSession().getAttribute("companyuser");
        if (admin == null) {
            return true;
        } else return false;
    }

}
