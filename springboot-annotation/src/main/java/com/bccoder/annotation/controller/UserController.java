package com.bccoder.annotation.controller;

import com.bccoder.annotation.beans.StudentEntity;
import com.bccoder.annotation.beans.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private StudentEntity studentEntity;

    @Autowired
    private UserEntity userEntity;

    @GetMapping("test")
    public String show(){
        System.out.println("Student name:"+studentEntity.getName());
        System.out.println("User name:"+userEntity.getName());
        System.out.println("User toString:"+userEntity.toString());
        return "Success";
    }
}
