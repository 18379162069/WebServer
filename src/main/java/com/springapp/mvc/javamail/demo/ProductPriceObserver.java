package com.springapp.mvc.javamail.demo;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 2016/2/2.
 */
public class ProductPriceObserver {


    public void update() {

        if (true) {
            double decrease = 11.1;
            if (decrease > 0) {
                // 发送邮件
                SimpleMailSender sms = MailSenderFactory
                        .getSender();
                List<String> recipients = new ArrayList<String>();
                recipients.add("862627787@qq.com");
                recipients.add("luolouiegit@gmail.com");
                recipients.add("510629251@qq.com");
                try {
                    for (String recipient : recipients) {
                        sms.send(recipient, "价格变动", "您关注的物品"
                                + "元降到"  + "元，降幅达"
                                + decrease + "元人民币。赶快购物吧。");
                    }
                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
