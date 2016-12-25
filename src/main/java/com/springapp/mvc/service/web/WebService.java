package com.springapp.mvc.service.web;

import com.springapp.mvc.pojo.WebPage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by louie on 2016/2/29.
 */
public interface WebService {

    public byte[] getInputStream(String picname,String type);   //ȡ���ļ���
    public List<String> getLunboPicList();              //ȡ����ҳ�ֲ�ͼƬ
    public String getCompanyIntroduce();                //ȡ�ù�˾����
    public String getCompanyLogo();                     //ȡ��LOGO
    public List<String> getCompanyCoops();                    //ȡ�ù�˾�������
    public List<String> getType2For1(Integer index);

    public boolean updateCompanyInfo(WebPage webPage);           //������ҳ��Ϣ
    public WebPage getWebPageInfo();                         //��ȡ��ҳ��������Ϣ
    public boolean updatemainpagepic(MultipartFile pic,Integer picnum); //�����ֲ�ͼƬ
    public boolean updateCooperation(String coopeartionname,int num);    //���º�����˾����
    public boolean addCoopeartion(String cooperationname);    //���Ӻ�����˾
}
