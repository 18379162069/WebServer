package com.springapp.mvc.dao.web;

import com.springapp.mvc.pojo.User;
import com.springapp.mvc.pojo.WebPage;

import java.util.List;

/**
 * Created by louie on 2016/2/1.
 */
public interface WebDao {

    public String getLunboPicList();
    public String getCompanyIntroduce();
    public String getCompanyLogo();
    public String getCompanyCoops();
    public List<String> getType2For1(Integer index);

    public int updateCompanyInfo(WebPage webPage);           //更新主页信息
    public WebPage getWebPageInfo();                         //获取主页的所有信息
}
