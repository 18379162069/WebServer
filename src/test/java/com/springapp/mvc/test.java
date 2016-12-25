package com.springapp.mvc;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

/**
 * Created by louie on 2016/2/26.
 */
public class test {

    public static void main(String[] args) {
        Map<String,Integer> map = Maps.newHashMap();
        Random random = new Random();
        int s = random.nextInt(9000) + 1000;
        System.out.println(s);
    }
}
