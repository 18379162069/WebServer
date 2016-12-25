package com.springapp.mvc.javamail.util;

import com.springapp.mvc.javamail.demo.MailAuthenticator;
import com.springapp.mvc.util.PicUpLoad;
import com.springapp.mvc.util.RequestFactory;
import com.springapp.mvc.util.RootPath;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by louie on 2016/2/2.
 */
@Transactional
@Service
public class MailUtil {

    @Autowired
    private RequestFactory Factory;

    @Autowired
    private RootPath rootPath;
    public void sendFileMail(String from, String password, String[] to, String subject, String fileUrl) throws GeneralSecurityException, MessagingException {
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        // 1创建与邮件服务器连接
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        properties.put("mail.smtp.auth", "true");// 连接验证
        properties.put("mail.debug", "true");// 在控制台显示日志
        Session session = Session.getInstance(properties);
        // 2编写邮件内容
        MimeMessage message = new MimeMessage(session);
        // from字段
        try {
            message.setFrom(new InternetAddress(from));
            // subject字段 ----主题
            message.setSubject(subject);
        }catch (MessagingException e){
            e.printStackTrace();
        }

        //内容组合实体
        Multipart mp = new MimeMultipart();

        //添加word文档
        MimeBodyPart mbp;
        mbp = new MimeBodyPart();
        System.out.println(fileUrl);
        mbp.setDataHandler(new DataHandler(new FileDataSource(fileUrl)));

        //base64编码 让中文不乱码
        BASE64Encoder enc = new BASE64Encoder();
        mbp.setFileName("=?GBK?B?" + enc.encode(("开班信息.doc").getBytes()) + "?=");

        //添加附件
        mp.addBodyPart(mbp);

        message.setContent(mp);
        message.saveChanges();
        // 3 使用Transport发送邮件
        Transport transport = session.getTransport();
        // 发邮件前进行身份校验
        transport.connect(from, password);
        try {
            for(String s:to) {
                InternetAddress[] userAddressList = new InternetAddress().parse(s);
                message.setRecipients(Message.RecipientType.TO, userAddressList);
                try {
                    transport.sendMessage(message, message.getAllRecipients());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMail(String from, String password, String[] to, String subject, String emailContent) throws GeneralSecurityException, MessagingException {
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        MailAuthenticator mail = new MailAuthenticator();
        // 1创建与邮件服务器连接
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        properties.put("mail.smtp.auth", "true");// 连接验证
        properties.put("mail.debug", "true");// 在控制台显示日志
        Session session = Session.getInstance(properties);
        // 2编写邮件内容
        MimeMessage message = new MimeMessage(session);
        // from字段
        try {
            message.setFrom(new InternetAddress(from));

            message.setSubject(subject);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        //项目路径
//        String webPath = Factory.getRequest().getSession().getServletContext().getRealPath("/");
        String webPath = "C:\\Users\\louie\\Desktop\\Demo\\WebServer\\target";
        //获取图片集合
        List<String> picList = getContentPic(emailContent);

        //内容组合实体
        MimeMultipart mimeMultipart = new MimeMultipart();

        //添加多附件
        MimeBodyPart imag;
        for (int i = 0; i < getContentPic(emailContent).size(); i++) {
            imag = new MimeBodyPart();
//            System.out.println(webPath+"--");
            String picPath = picList.get(i);
            System.out.println(picPath);
            imag.setDataHandler(new DataHandler(new FileDataSource(webPath + picPath.substring(0, picPath.length() - 1))));
            imag.setContentID("img" + i);
            //添加附件
            mimeMultipart.addBodyPart(imag);
        }

        //给email添加内容
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(changeToNewContent(emailContent), "text/html;charset=utf-8");
        mimeMultipart.addBodyPart(content);
        mimeMultipart.setSubType("related");

        message.setContent(mimeMultipart);

        // 3 使用Transport发送邮件
        Transport transport = session.getTransport();
        // 发邮件前进行身份校验
        transport.connect(from, password);
        try {
            for (String s : to) {
                System.out.println(s+"分出来的");
                InternetAddress[] userAddressList = new InternetAddress().parse(s);
                message.setRecipients(Message.RecipientType.TO, userAddressList);
                try {
                    transport.sendMessage(message, message.getAllRecipients());
                }catch (Throwable e){
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getMailList(String[] mailArray) {

        StringBuffer toList = new StringBuffer();
        int length = mailArray.length;
        if (mailArray != null && length < 2) {
            toList.append(mailArray[0]);
        } else {
            for (int i = 0; i < length; i++) {
                toList.append(mailArray[i]);
                if (i != (length - 1)) {
                    toList.append(",");
                }

            }
        }
        return toList.toString();
    }

    //        private final static String regxpForImaTagSrcAttrib = "src='([^']+)'";
    private final static String regxpForImaTagSrcAttrib = "/WebServer([^\"]+)\"";


    //把旧内容改成新的内容，img src改为id
    public String changeToNewContent(String originalContent) {
        Pattern pattern = Pattern.compile(regxpForImaTagSrcAttrib);
        Matcher matcher = pattern.matcher(originalContent);
        String newCotent = null;
        for (int i = 0; i < 100; i++) {
            newCotent = matcher.replaceFirst("cid:img" + i + "\"");
            matcher = pattern.matcher(newCotent);
        }
        return newCotent;
    }


    //获取content中的图片
    public List<String> getContentPic(String originalContent) {
        Pattern p = Pattern.compile(regxpForImaTagSrcAttrib);
        Matcher m = p.matcher(originalContent);
        List<String> result = new ArrayList<String>();
        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }
}
