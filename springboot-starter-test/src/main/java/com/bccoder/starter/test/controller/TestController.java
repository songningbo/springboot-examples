package com.bccoder.starter.test.controller;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("redis")
    public String testRedis(){
        System.out.println("----------start-------------");
        redissonClient.getBucket("key").set("test value");
        System.out.println("----------end-------------");
        return redissonClient.getBucket("key").get().toString();
    }
}
