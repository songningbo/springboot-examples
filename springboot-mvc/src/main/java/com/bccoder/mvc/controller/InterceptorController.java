package com.bccoder.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("interceptor")
public class InterceptorController {

    @GetMapping("show")
    @ResponseBody
    public String show(){
        log.info("show:info");
        return "success";
    }
    @GetMapping("test")
    @ResponseBody
    public String test(){
        log.info("test:info");
        return "success";
    }
}
