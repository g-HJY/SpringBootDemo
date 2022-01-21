package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "邮件相关接口")
@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource
    private JavaMailSender mailSender;

    @ApiOperation(value = "发送邮件",notes = "发送邮件")
    @RequestMapping(value = "/sendMail",method = {RequestMethod.GET,RequestMethod.POST})
    public String sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("493306620@qq.com");
        message.setTo("493306620@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
        return "Send mai success";
    }
}
