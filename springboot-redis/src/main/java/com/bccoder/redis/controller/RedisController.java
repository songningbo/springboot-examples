package com.bccoder.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("test")
    public String test(){
        redisTemplate.opsForValue().set("test","测试redis连接");
        return redisTemplate.opsForValue().get("test").toString();
    }

    @GetMapping("string/test")
    public String testStr(){
        stringRedisTemplate.opsForValue().set("testStr","测试redis String连接");
        return stringRedisTemplate.opsForValue().get("testStr").toString();
    }

    @GetMapping("conn/test")
    public String testConn(){
        Object obj = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set("key".getBytes(),"value".getBytes());
                return redisConnection.get("key".getBytes());
            }
        });
        byte [] bytes = (byte[]) obj;
        return new String(bytes);
    }

    @GetMapping("pub/test")
    public String testPub(){
        stringRedisTemplate.convertAndSend("testPub","1234");
        return "success";
    }

    @GetMapping("ser/test")
    public String testSer(){
        redisTemplate.opsForValue().set("test-1","test");
        redisTemplate.opsForValue().set("test-2", User.getSampleUser());
        return "success";
    }

    public static class User implements java.io.Serializable{
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Date date = new Date();
        public static User getSampleUser(){
            User user = new User();
            user.setId(1);
            user.setName("test User");
            return user;
        }
    }
}
