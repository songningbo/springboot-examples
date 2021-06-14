package com.bccoder.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CorsController {

    @GetMapping("cors/cors.html")
    public ModelAndView cors(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/cors.html");
        return view;
    }

    @GetMapping("cors/ajax")
    @ResponseBody
    public String ajax(){
        return "success";
    }
}
