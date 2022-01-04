package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
//开启定时任务
@EnableScheduling
//★1、(@EnableCaching)开启Spring对缓存的支持
@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//多数据源配置
//@MapperScan("com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
