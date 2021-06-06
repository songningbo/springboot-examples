package com.bccoder.aop.service;

import org.springframework.stereotype.Service;

@Service
public class TestThisServiceImpl implements ITestThisService{
    @Override
    public String m1() {
        System.out.println("--------this expression TestThisServiceImpl-----------");
        return "test m1";
    }
}
