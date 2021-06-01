package com.bccoder.annotation.controller;

import com.bccoder.annotation.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
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

    @Autowired
    private ImportResourceEntity importResourceEntity;

    @Autowired
    private ImportEntity importEntity;

    @Autowired
    ApplicationContext ctx;

    @Autowired
    ScopeEntity twoScope;

    @GetMapping("test")
    public String show(){
        System.out.println("Student name:"+studentEntity.getName());
        System.out.println("User name:"+userEntity.getName());
        System.out.println("test import:"+importEntity.getName());
        System.out.println("test importResource:"+importResourceEntity.getName());
        return "Success";
    }
    @GetMapping("scope")
    public String test(){
        System.out.println("singletion:"+ctx.getBean("oneScope"));
        System.out.println("prototype:"+ctx.getBean("twoScope"));
        return "Success";
    }

    /**
     * 注入非单例的bean
     * 每次访问都是同一个bean。
     * @return
     */
    @GetMapping("singleton")
    public String test1(){
        System.out.println(twoScope);
        return "Success";
    }

    /**
     * 解决方式一
     * @return
     */
    @GetMapping("singleton2")
    public String test2(){
        System.out.println(testBean());
        return "Success";
    }

    private ScopeEntity testBean(){
        return (ScopeEntity)ctx.getBean("twoScope");
    }

}
