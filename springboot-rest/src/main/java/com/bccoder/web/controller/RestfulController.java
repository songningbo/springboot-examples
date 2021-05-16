package com.bccoder.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("rest")
public class RestfulController {

    @RequestMapping("show")
    public String show(){
        return "hello Springboot2.0!!!";
    }
}
