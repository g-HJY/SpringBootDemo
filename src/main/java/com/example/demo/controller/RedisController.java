package com.example.demo.controller;

import com.example.demo.ratelimit.LimitType;
import com.example.demo.ratelimit.RateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "Redis使用相关接口")
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @Value("${my.value}")
    private String str;

    public static final String REDIS_LOCK = "good_lock";
    @Resource
    Redisson redisson;


    @ApiOperation(value = "Redis实现分布式锁",notes = "Redis实现分布式锁")
    @GetMapping("/distributedLock")
    public String index(){

        // 每个人进来先要进行加锁，key值为"good_lock"
        RLock lock = redisson.getLock(REDIS_LOCK);
        lock.lock();

        try{
            String result = (String) redisTemplate.opsForValue().get("goods:001");
            int total = result == null ? 0 : Integer.parseInt(result);
            if (total > 0) {
                // 如果在此处需要调用其他微服务，处理时间较长。。。
                int realTotal = total - 1;
                redisTemplate.opsForValue().set("goods:001", String.valueOf(realTotal));
                System.out.println("购买商品成功，库存还剩：" + realTotal + "件");
                return "购买商品成功，库存还剩：" + realTotal + "件";
            }
            return "购买商品失败，库存不足";
        }finally {
            if(lock.isLocked() && lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    @Autowired
    private CacheManager cacheManager;

    /**
     * Redis实现消息队列
     * @return
     */
    @ApiOperation(value = "Redis实现消息队列",
            notes = "Redis实现消息队列",
            httpMethod = "GET",
            response = Map.class)
    @GetMapping("/hello")
    public Map hello(){
        Map map = new HashMap<>();
        map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map.put("str",str);
        redisTemplate.convertAndSend("channel21","Hello,I'm a message from redis.");
        String version = SpringBootVersion.getVersion();
        map.put("version",version);
        System.out.println("CacheManager type : " + cacheManager.getClass());
        return map;
    }


    /**
     * Redis以注解方式实现接口限流
     * @return
     */
    @ApiOperation(value = "Redis实现接口限流",
            notes = "Redis实现接口限流",
            httpMethod = "GET",
            response = Map.class)
    @GetMapping("/rateLimit")
    @RateLimiter(time = 5,count = 3,limitType = LimitType.IP)
    public Map rateLimit(){
        Map map = new HashMap<>();
        map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map.put("desc","被限流接口");
        return map;
    }


    /**
     * 模拟Redis插入数据
     * @return
     */
    @ApiOperation(value = "模拟Redis插入数据",
            notes = "模拟Redis插入数据",
            httpMethod = "POST",
            response = String.class)
    @PostMapping("/insert")
    public String redis(){
        //增：key:name   value:openxu
        redisTemplate.opsForValue().set("name", "openxu");
        redisTemplate.opsForValue().set("age", 23);
        redisTemplate.opsForValue().set("gender", "man");

        return "insert ok";
    }

    /**
     * 模拟Redis查询数据
     * @return
     */
    @ApiOperation(value = "模拟Redis查询数据",
            notes = "模拟Redis查询数据",
            httpMethod = "GET",
            response = String.class)
    @GetMapping("/get")
    public String redisget(){
        //增：key:name   value:openxu
        String name = (String)redisTemplate.opsForValue().get("name");
        return name;
    }


    /**
     * 模拟Redis删除数据
     * @return
     */
    @ApiOperation(value = "模拟Redis删除数据",
            notes = "模拟Redis删除数据",
            httpMethod = "GET",
            response = String.class)
    @GetMapping("/delete")
    public String redisdel(){
        //增：key:name   value:openxu
        redisTemplate.delete("findCustomerId::account.findCustomerId");
        return "delete ok";
    }



}
