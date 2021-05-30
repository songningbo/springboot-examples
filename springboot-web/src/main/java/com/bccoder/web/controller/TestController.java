package com.bccoder.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController{

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        request.setAttribute("name","test jsp");
        return "hello";
    }
}
