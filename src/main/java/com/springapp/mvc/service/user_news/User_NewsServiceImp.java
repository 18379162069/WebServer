package com.springapp.mvc.service.user_news;

import com.springapp.mvc.dao.user_news.User_NewsDao;
import com.springapp.mvc.pojo.User_News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
@Service(value = "user_newsService")
@Transactional
public class User_NewsServiceImp implements User_NewsService {
    @Autowired
    private User_NewsDao user_newsDao;
    @Override
    public boolean inserteU_NNexus(int userid, int newsid) {
        if(user_newsDao.inserteU_NNexus(userid,newsid)>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteU_NNexus(int userid, int newsid) {
        if(user_newsDao.deleteU_NNexus(userid,newsid)>0)
            return true;
        else
            return false;
    }

    @Override
    public List<User_News> getListByUserId(int userid) {
        if(user_newsDao.getListByUserId(userid)!=null){
            return user_newsDao.getListByUserId(userid);
        }

        else
            return null;
    }

    @Override
    public List<User_News> getListByNewsid(int newsid) {
        if(user_newsDao.getListByNewsid(newsid)!=null)
            return user_newsDao.getListByNewsid(newsid);
        else
            return null;
    }
}
