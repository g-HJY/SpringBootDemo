package com.example.demo.task;

import com.example.demo.service.TCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class MyTask {
    /**
     * 服务对象
     */
    @Resource
    private TCustomerService tCustomerService;


//    @Scheduled(cron = "0/10 * * * * *")
//    public void work() {
//        tCustomerService.queryById("1");
//    }


//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("现在时间：" + dateFormat.format(new Date()));
//    }

}