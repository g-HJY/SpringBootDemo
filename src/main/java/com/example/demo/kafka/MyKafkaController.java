package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MyKafkaController {
    private final static String TOPIC_NAME = "testA";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send")
    public String sendMessage(){
        try {
            kafkaTemplate.send(TOPIC_NAME,0,"key","this is a message!");
        } catch (Exception e) {
            return e.getMessage();
        }
        return "send success!";
    }
}