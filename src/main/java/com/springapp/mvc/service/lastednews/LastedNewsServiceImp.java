package com.springapp.mvc.service.lastednews;

import com.springapp.mvc.dao.lastednews.LastedNewsDao;
import com.springapp.mvc.pojo.LastedNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
@org.springframework.stereotype.Service(value = "lastednewsService")
@Transactional
public class LastedNewsServiceImp implements LastedNewsService {
    @Autowired
    private LastedNewsDao lastedNewsDao;
    @Override
    public boolean insertlastedNews(LastedNews lastedNews) {
        if(lastedNewsDao.insertlastedNews(lastedNews)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deletelastedNewsbyid(int id) {
        if(lastedNewsDao.deletelastedNewsbyid(id)>0)
            return  true;
        else
            return false;
    }

    @Override
    public LastedNews getlastedNewsbyid(int id) {
        return lastedNewsDao.getlastedNewsbyid(id);
    }

    @Override
    public List<LastedNews> getlastedNewsbyNewsname(String newsname) {
        return getlastedNewsbyNewsname(newsname);
    }

    @Override
    public boolean updatelastedNews(LastedNews lastedNews) {
        if(lastedNewsDao.updatelastedNews(lastedNews)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean changeLastedNewsCheckbyid(int id) {
        LastedNews lastedNews=lastedNewsDao.getlastedNewsbyid(id);
        lastedNews.setNewscheck("pass");
        if(lastedNewsDao.updatelastedNews(lastedNews)>0)
            return  true;
        else
            return false;
    }
}
