package com.bccoder.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class RestShowController {

    @RequestMapping("show")
    @ResponseBody
    public String show(){
        return "hello restful!!!";
    }

    @RequestMapping("show2")
    public @ResponseBody String showVoid(){
        return "hello restful2!!!";
    }
}
