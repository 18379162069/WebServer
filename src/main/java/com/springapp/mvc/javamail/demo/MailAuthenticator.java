package com.springapp.mvc.javamail.demo;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by louie on 2016/2/2.
 */
public class MailAuthenticator extends Authenticator {

    public MailAuthenticator(){
        super();
    }
//    private String username;
//    private String password;
//
//    public MailAuthenticator(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }



    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String username = "510629251@qq.com";
        String password = "luoTIANxiang234";
        if ((username != null) && (username.length() > 0) && (password != null)
                && (password.length   () > 0)) {
            return new PasswordAuthentication(username, password);
        }
        return null;
    }
}
