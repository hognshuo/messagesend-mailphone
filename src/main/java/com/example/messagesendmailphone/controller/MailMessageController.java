package com.example.messagesendmailphone.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * @author hso
 * @data: 2019/11/29 15:05
 * @param:
 * @description:   发送邮箱验证码demo
 */
@RestController
@RequestMapping("/mail")
public class MailMessageController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;
    private String emailServiceCode;
    @GetMapping("/sendText")
    public String mailSend(String[] args) {
        Random random = new Random();
        emailServiceCode = String.valueOf((int)((Math.random()*9+1)*1000));
        System.out.println(emailServiceCode);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("370246771@qq.com");
        message.setTo("ashuo0615@163.com");
        message.setSubject("邮箱验证");
        message.setText("邮箱验证码："+emailServiceCode);
        try {
            javaMailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
        return "true";
    }
}
