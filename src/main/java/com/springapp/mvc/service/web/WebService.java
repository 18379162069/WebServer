package com.springapp.mvc.service.web;

import com.springapp.mvc.pojo.WebPage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by louie on 2016/2/29.
 */
public interface WebService {

    public byte[] getInputStream(String picname,String type);   //取得文件流
    public List<String> getLunboPicList();              //取得首页轮播图片
    public String getCompanyIntroduce();                //取得公司介绍
    public String getCompanyLogo();                     //取得LOGO
    public List<String> getCompanyCoops();                    //取得公司合作伙伴
    public List<String> getType2For1(Integer index);

    public boolean updateCompanyInfo(WebPage webPage);           //更新主页信息
    public WebPage getWebPageInfo();                         //获取主页的所有信息
    public boolean updatemainpagepic(MultipartFile pic,Integer picnum); //更新轮播图片
    public boolean updateCooperation(String coopeartionname,int num);    //更新合作公司名称
    public boolean addCoopeartion(String cooperationname);    //增加合作公司
}
