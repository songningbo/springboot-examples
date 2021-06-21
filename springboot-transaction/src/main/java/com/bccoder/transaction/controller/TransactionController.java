package com.bccoder.transaction.controller;

import com.bccoder.transaction.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("trans")
public class TransactionController {

    @Resource
    private IService service;

    @GetMapping("trans1")
    public String trans1(){
//        service.deleteUser(1);
        return "delete user";
    }
    @GetMapping("trans2")
    public String trans2(){
        service.updateUser(1);
        return "update param user";
    }

    @GetMapping("trans3")
    public String trans3(){
//        service.updateUser();
        return "update no param user";
    }

}
