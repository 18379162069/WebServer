package com.springapp.mvc.dao.lastednews;

import com.springapp.mvc.pojo.LastedNews;

import java.util.List;

/**
 * Created by Administrator on 2016/2/16 0016.
 */
public interface LastedNewsDao {
    public int insertlastedNews(LastedNews lastedNews);                  //新增资讯
    public int deletelastedNewsbyid(int id);                            //通过id删除资讯
    public LastedNews getlastedNewsbyid(int id);                        //通过id准确查找咨询
    public List<LastedNews> getlastedNewsbyNewsname(String newsname);    //通过新闻名字模糊查找新闻
    public int  updatelastedNews(LastedNews lastedNews);                 //更新资讯
}
