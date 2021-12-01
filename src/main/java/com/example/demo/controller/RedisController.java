package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @Value("${my.value}")
    private String str;


    @RequestMapping("/hello")
    public Map hello(){
        Map map = new HashMap<>();
        map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map.put("str",str);
        redisTemplate.convertAndSend("channel21","Hello,I'm a message from redis.");
        String version = SpringBootVersion.getVersion();
        map.put("version",version);
        return map;
    }


    @RequestMapping("/insert")
    public String redis(){
        //增：key:name   value:openxu
        redisTemplate.opsForValue().set("name", "openxu");
        redisTemplate.opsForValue().set("age", 23);
        redisTemplate.opsForValue().set("gender", "man");

        return "insert ok";
    }

    @RequestMapping("/get")
    public String redisget(){
        //增：key:name   value:openxu
        String name = (String)redisTemplate.opsForValue().get("name");
        return name;
    }

    @RequestMapping("/delete")
    public String redisdel(){
        //增：key:name   value:openxu
        redisTemplate.delete("findCustomerId::account.findCustomerId");
        return "delete ok";
    }



}
