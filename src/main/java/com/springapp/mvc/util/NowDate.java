package com.springapp.mvc.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by louie on 2016/1/22.
 */

public class NowDate {

    public static String getNowDate(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
        String newsdate = df.format(date);
        return newsdate;
    }
}
