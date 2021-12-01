package com.example.demo.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "rb_test_queue")
public class RabbitMQReceiver {

    @RabbitHandler
    public void process(String hello) {
        log.info("Receiver : " + hello);
    }

}