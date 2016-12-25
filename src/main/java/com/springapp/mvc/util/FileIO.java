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
            FileInputStream fis = new FileInputStream(new File(filePath));//�½�һ��FileInputStream����
            try {
                b = new byte[fis.available()];//�½�һ���ֽ�����
                fis.read(b);//���ļ��е����ݶ�ȡ���ֽ�������
                fis.close();
//                str2 = new String(b);//�ٽ��ֽ������е�����ת�����ַ�����ʽ���
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
