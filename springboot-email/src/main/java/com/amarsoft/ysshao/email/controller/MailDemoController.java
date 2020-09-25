package com.amarsoft.ysshao.email.controller;/**
 * @author ysshao
 * @create 2020-09-24 18:25
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author AllenShao
 * @Description //TODO 
 * @Date 2020/9/24 18:25
 * @Version 1.0
 **/

@RestController
@Slf4j
public class MailDemoController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/sendMail")
    public String sendMSg(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("allenshao9@163.com");
        message.setTo("ysshao@xxxx.com");
        message.setSubject("BugBugBug");
        message.setText(" 人生如戏 Go for it ");
        mailSender.send(message);

        return "Spring Boot sendMail";
    }

}
