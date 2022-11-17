package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Thymeleaf页面模板相关接口")
@RestController
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}