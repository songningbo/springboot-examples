package com.bccoder.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequestMapping("redirect")
public class DirectContrller {
    @RequestMapping("login")
    public String login(){
        log.info("==========登录成功==========");
        return "redirect:/redirect/index";
    }
    @RequestMapping("index")
    public String index(){
        log.info("==========跳转首页成功==========");
        return "redirect";
    }
    @RequestMapping("mav")
    public ModelAndView mavShow(){
        ModelAndView view = new ModelAndView("redirect:/redirect/index");
        log.info("==========ModelAndView成功==========");
        return view;
    }
}
