package com.springapp.mvc.util;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by louie on 2016/2/29.
 */
@Service
public class FileIO {

    public byte[] getInputStream(String filePath) {
        byte[] b=null;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));//新建一个FileInputStream对象
            try {
                b = new byte[fis.available()];//新建一个字节数组
                fis.read(b);//将文件中的内容读取到字节数组中
                fis.close();
//                str2 = new String(b);//再将字节数组中的内容转化成字符串形式输出
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }
}
