package com.springapp.mvc.javamail.demo;

/**
 * Created by louie on 2016/2/2.
 */
public class MailSenderFactory {

    /**
     * 服务邮箱
     */
    private static SimpleMailSender serviceSms = null;

    /**
     * 获取邮箱
     *
     * @return 符合类型的邮箱
     */
    public static SimpleMailSender getSender() {
        if (serviceSms == null) {
            serviceSms = new SimpleMailSender("510629251@qq.com",
                    "luoTIANxiang234");
        }
        return serviceSms;
    }

}