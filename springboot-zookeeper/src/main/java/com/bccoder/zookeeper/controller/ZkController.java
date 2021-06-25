package com.bccoder.zookeeper.controller;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("zk")
public class ZkController {

    @Autowired
    private CuratorFramework zkClient;

    @GetMapping("disLock")
    public String lock() throws Exception {
        InterProcessMutex lock = new InterProcessMutex(zkClient,"/lock/test");
        try {
            lock.acquire(10, TimeUnit.HOURS);
            Thread.sleep(1000*7);
        } finally {
            lock.release();
        }
        return "success";
    }
}
