package com.example.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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
