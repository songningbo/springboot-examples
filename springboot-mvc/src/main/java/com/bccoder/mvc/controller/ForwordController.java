package com.bccoder.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("forward")
public class ForwordController {
    @RequestMapping("login")
    public String login(){
        log.info("==========登录成功==========");
        return "forward:/forward/index";
    }
    @RequestMapping("index")
    public String index(){
        log.info("==========跳转首页成功==========");
        return "forward";
    }
}
