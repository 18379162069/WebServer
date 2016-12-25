package com.springapp.mvc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/14 0014.
 */
public class StringRule {
    static String [] tmp;
    public static String manyToOneStr(String[] str){
        String newStr = "";
        for(String tmp:str){
            newStr+=tmp;
            newStr+=",";
        }
        return newStr.substring(0,newStr.length()-1);
    }
    public static String[] oneToManyStr(String str){
        String[] tmp;
        tmp = str.split(",");
        return tmp;
    }
    public static List<String> oneToList(String str){
        List<String> strList=new ArrayList<String>();
        String[] tmp = str.split(",");
        for(String t:tmp){
            strList.add(t);
        }
        return strList;
    }
    public static String manyToOneStr(String oldstr,String newstr,int key){
        tmp=oneToManyStr(oldstr);
        for(int i=0;i<tmp.length;i++){
            if(i==key-1){
                tmp[i]=newstr;
            }
        }
        return  manyToOneStr(tmp);
    }

    public static String manyToOneStr(List<String> str){
        String newStr = "";
        for(String tmp:str){
            newStr+=tmp;
            newStr+=",";
        }
        return newStr.substring(0,newStr.length()-1);
    }
}
