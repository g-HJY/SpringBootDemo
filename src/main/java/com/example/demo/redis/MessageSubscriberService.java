package com.example.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class MessageSubscriberService {

    public MessageSubscriberService(RedisTemplate redisTemplate) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                // 收到消息的处理逻辑
                log.info("Receive message : " + message);
            }
        }, "channel21".getBytes(StandardCharsets.UTF_8));

    }

}