package com.scholar.profile.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Random;

@Component
public class MailClient {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;
    @Value("欢迎您成为带得栏学术认证用户!")
    private String verificationSubject;

    public String generateVerificationCode(){
        Random random = new Random();
        return Integer.toString(random.nextInt(900000) + 100000);
    }

    public void sendEmailVerificationCode(String to, String verificationCode) throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(verificationSubject);
        String text = "您的验证码为：" + verificationCode + "\n请您返回网站输入以上验证码";
        helper.setText(text);
        mailSender.send(mimeMessage);
    }

}
