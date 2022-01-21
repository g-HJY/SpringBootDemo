package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
@Api(tags = "RabbitMQ相关接口")
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send() {
        String context = "hello " + new Date();
        this.rabbitTemplate.convertAndSend("rb_test_queue", context);
        return context;
    }

}
