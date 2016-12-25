package com.springapp.mvc;

import com.springapp.mvc.javamail.demo.MailAuthenticator;
import com.springapp.mvc.javamail.util.MailUtil;
import com.springapp.mvc.javasms.SMS;
import com.springapp.mvc.pojo.User;
import com.springapp.mvc.service.admin.AdminService;
import com.springapp.mvc.service.companyuser.CompanyUserService;
import com.springapp.mvc.service.user.UserService;
import com.springapp.mvc.service.web.WebService;
import com.springapp.mvc.util.NowDate;
import com.springapp.mvc.util.RequestFactory;
import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.*;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-mybatis.xml")
public class AppTests {

    //    private final static String originalContent = "<p>阿斯蒂芬<img src='/ueditor/jsp/upload/image/201602/1454681194331088223.jpg' title='1453634807699050290.png' alt='QQ图片20160115113336.png'/><img src='/ueditor/jsp/upload/image/201602/1454681194331088223.jpg'" +
//            " title='1453634807699050290.png' alt='QQ图片20160115113336.png'/><img src='/ueditor/jsp/upload/image/201602/1454681194331088223.jpg' title='1453634807699050290.png' alt='QQ图片20160115113336.png'/>" +
//            "asdfasdfsrcsadf<img src='/ueditor/jsp/upload/image/201602/1454681194331088223.jpg' title='1453634807699050290.png' alt='QQ图片20160115113336.png'/></p>";
    private final static String originalContent = "<p>呵呵呵</p>";
    @Autowired
    MailUtil mailUtil;

    @Autowired
    RequestFactory Factory;
    @Autowired
    private WebService webService;
    @Autowired
    private AdminService adminService;
    @Resource
    private UserService userService;

    @Autowired
    private CompanyUserService companyUser;



    public void test1() {
        System.out.println(companyUser.checkAccount("1", "1"));
    }

    @Test
    public void testMailSender() throws GeneralSecurityException, MessagingException {
        String[] to = {"----9@qq.com","510629251@qq.com"};
        String from = "510629251@qq.com";
        String password = "jhekfdoamsmncaeh";
//        System.out.println(mailUtil.changeToNewContent(originalContent));
//        mailUtil.sendMail(from,password,to,"javamail",originalContent);
        String fileUrl = "C:\\Users\\louie\\Desktop\\Demo\\WebServer\\target\\WebServer\\";
        String fileName = "开发文档.docx";
//        mailUtil.sendFileMail("510629251@qq.com", "jhekfdoamsmncaeh", to, "javamail邮件", fileUrl + fileName);
        mailUtil.sendMail(from, password, to, "test", originalContent);
    }


    public void sendMail() throws MessagingException, GeneralSecurityException {
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
        message.setFrom(new InternetAddress("510629251@qq.com"));
        // to字段
        String to[] = {"510629251@qq.com", "571877919@qq.com"};
        String toList = getMailList(to);
        InternetAddress[] iaToList = new InternetAddress().parse(toList);
        message.setRecipients(Message.RecipientType.TO, iaToList);

        // subject字段 ----主题
        message.setSubject("<p>javamail发送简单邮件");
        // 邮件正文内容
//        message.setText("<p>使用javamail</p>");
        MimeBodyPart imag = new MimeBodyPart();
        String webPath = Factory.getRequest().getSession().getServletContext().getRealPath("/");
        imag.setDataHandler(new DataHandler(new FileDataSource(webPath + "/res/pic/a.jpeg")));
        imag.setContentID("myImag");

        MimeBodyPart content = new MimeBodyPart();
        content.setContent("<h2>hello</h2><a href='http://www.baidu.com'><img src='cid:myImag'/></a>", "text/html;charset=utf-8");

        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(imag);
        mimeMultipart.addBodyPart(content);
        mimeMultipart.setSubType("related");

        message.setContent(mimeMultipart);

        // 3 使用Transport发送邮件
        Transport transport = session.getTransport();
        // 发邮件前进行身份校验
        transport.connect("510629251@qq.com", "jhekfdoamsmncaeh");
        transport.sendMessage(message, message.getAllRecipients());
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

//    @Test
//    public void test() {
//        System.out.println(changeToNewContent());
//    }

    private final static String regxpForImaTagSrcAttrib = "src='([^']+)'";

    private String changeToNewContent(String originalContent) {
        Pattern pattern = Pattern.compile(regxpForImaTagSrcAttrib);
        Matcher matcher = pattern.matcher(originalContent);
        String newCotent = null;
        for (int i = 0; i < 100; i++) {
            newCotent = matcher.replaceFirst("src=\"cid:img" + i + "\"");
            matcher = pattern.matcher(newCotent);
        }
        return newCotent;
    }


    public List<String> getContentPic() {

        Pattern p = Pattern.compile(regxpForImaTagSrcAttrib);
        Matcher m = p.matcher(originalContent);
        List<String> result = new ArrayList<String>();

        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }

    public String manyToOneStr(String[] str) {
        String newStr = "";
        for (String tmp : str) {
            newStr += tmp;
            newStr += ",";
        }
        return newStr.substring(0, newStr.length() - 1);
    }

    public String[] oneToManyStr(String str) {
        String[] tmp = str.split(",");
        return tmp;
    }

    @Test
    public void test2() throws GeneralSecurityException, MessagingException {
        adminService.sendToEmail("<p><img src=\"/WebServer/ueditor/jsp/upload/image/201602/1455632718582057720.jpg\" title=\"1455632718582057720.jpg\" alt=\"smallpeople.jpg\"/>啊的风格</p>", 4);
    }

    @Test
    public void test3(){
        webService.getCompanyCoops();
    }
    @Test
    public void test4(){
        User user=new User();
        user.setUseremail("510629251@qq.com");
        user.setUserpassword("1");
        if(userService.loginUserbyemail(user))
        {
            System.out.println("登陆成功");
        }else
            System.out.println("登录失败");

    }
    @Test
    public void test5(){
        System.out.println(Boolean.TRUE);
    }
}

