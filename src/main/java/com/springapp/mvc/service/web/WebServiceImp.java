package com.springapp.mvc.service.web;

import com.springapp.mvc.dao.web.WebDao;
import com.springapp.mvc.pojo.WebPage;
import com.springapp.mvc.util.FileIO;
import com.springapp.mvc.util.PicUpLoad;
import com.springapp.mvc.util.RootPath;
import com.springapp.mvc.util.StringRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 2016/2/29.
 */
@Service(value = "webService")
public class WebServiceImp implements WebService {

    @Autowired
    private RootPath rootPath;
    @Autowired
    private PicUpLoad picUpLoad;
    @Autowired
    private FileIO fileIO;
    @Autowired
    private WebDao webDao;

    @Override
    public byte[] getInputStream(String picname, String type) {
        String picPath = rootPath.RootPath() + "WEB_RES/" + type + "/" + picname;
        byte[] fileIOStream = fileIO.getInputStream(picPath);
        return fileIOStream;
    }

    @Override
    public List<String> getLunboPicList() {
        String lunboPics = webDao.getLunboPicList();
        List<String> lunboPicList = StringRule.oneToList(lunboPics);
        return lunboPicList;
    }

    @Override
    public String getCompanyIntroduce() {
        String introduce = webDao.getCompanyIntroduce();
        return introduce;
    }

    @Override
    public String getCompanyLogo() {
        String logo = webDao.getCompanyLogo();
        return logo;
    }

    @Override
    public List<String> getCompanyCoops() {
        String coops = webDao.getCompanyCoops();
        List<String> coopsList = StringRule.oneToList(coops);
        return coopsList;
    }

    @Override
    public List<String> getType2For1(Integer index) {
        List<String> type2List = webDao.getType2For1(index);
        return type2List;
    }

    @Override
    public boolean updateCompanyInfo(WebPage webPage) {
        if (webPage != null) {
            webDao.updateCompanyInfo(webPage);
            return true;
        } else
            return false;
    }

    @Override
    public WebPage getWebPageInfo() {
        return webDao.getWebPageInfo();
    }

    @Override
    public boolean updatemainpagepic(MultipartFile pic, Integer picnum) {
        if (pic != null) {
            WebPage webPage = webDao.getWebPageInfo();
            List<String> oldlunbopic = new ArrayList<String>();
            List<String> newlunbopic = new ArrayList<String>();

            oldlunbopic = StringRule.oneToList(webDao.getLunboPicList());

            String picStorePlace = "WEB_RES/lunbo_pic/";
            String upPicName = picUpLoad.updatePicName(pic.getOriginalFilename());
            picUpLoad.upLoad(pic, upPicName, picStorePlace);
            String uppicurls = upPicName;
            for (int i = 0; i < oldlunbopic.size(); i++) {
                if (picnum - 1 == i) {
                    newlunbopic.add(uppicurls);
                } else
                    newlunbopic.add(oldlunbopic.get(i));
            }
            String newString = StringRule.manyToOneStr(newlunbopic);
            webPage.setLuboPics(newString);
            webDao.updateCompanyInfo(webPage);
            return true;
        } else
            return false;
    }

    @Override
    public boolean updateCooperation(String coopeartionname, int num) {
        WebPage webPage = webDao.getWebPageInfo();
        List<String> coopeartionnames = this.getCompanyCoops();
        List<String> newcoops = new ArrayList<String>();
        for (int i = 0; i < coopeartionnames.size(); i++) {
            if (num - 1 == i) {
                newcoops.add(coopeartionname);
            } else
                newcoops.add(coopeartionnames.get(i));
        }
        webPage.setCooperation(StringRule.manyToOneStr(newcoops));
        if (webDao.updateCompanyInfo(webPage) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean addCoopeartion(String cooperationname) {
        WebPage webPage = webDao.getWebPageInfo();
        List<String> coopeartionnames = this.getCompanyCoops();
        coopeartionnames.add(cooperationname);
        webPage.setCooperation(StringRule.manyToOneStr(coopeartionnames));
        if (webDao.updateCompanyInfo(webPage) > 0)
            return true;
        else
            return false;
    }
}
