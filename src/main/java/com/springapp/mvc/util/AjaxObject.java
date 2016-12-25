package com.springapp.mvc.util;

/**
 * Created by louie on 2016/1/20.
 */
public class AjaxObject {

    public static String toJson(boolean flag) {
        return "{\"flag\":"+flag+"}";
    }
}
