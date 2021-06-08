package com.bccoder.mvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.bccoder.mvc.bean.OrderFrom;
import com.bccoder.mvc.bean.User;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/user")
public class ModelViewController {

    @GetMapping("/{userId}/get.html")
    public String getUser(@PathVariable long userId, Model model){
        User userInfo = new User();
        userInfo.setId(userId);
        userInfo.setName("tom");
        //model.addAttribute(userInfo);与下面效果一致
        model.addAttribute("user",userInfo);
        return "/userInfo.html";
    }
    @GetMapping("/{userId}/get1.html")
    public ModelAndView getUser2(@PathVariable long userId, ModelAndView view){
        User userInfo = new User();
        userInfo.setId(userId);
        userInfo.setName("tom");
        view.addObject("user",userInfo);
        view.setViewName("/userInfo.html");
        return view;
    }
    @GetMapping("/{userId}/get2.html")
    public ModelAndView getUser3(@PathVariable long userId){
        ModelAndView view = new ModelAndView();
        User userInfo = new User();
        userInfo.setId(userId);
        userInfo.setName("tom");
        view.addObject("user",userInfo);
        view.setViewName("/userInfo.html");
        return view;
    }
    @GetMapping("/getOrder.html")
    public ModelAndView getOrder(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/order.html");
        return view;
    }
    @PostMapping("/saveOrder.json")
    @ResponseBody
    public String saveOrder(OrderFrom from){
        log.info("OrderFrom JSON:"+ JSONObject.toJSONString(from));
        return "success";
    }
    @GetMapping("/upload.html")
    public ModelAndView getUpload(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/upload.html");
        return view;
    }
    @PostMapping("/upload")
    @ResponseBody
    public String formUpload(String name, MultipartFile[] files) {
        for (MultipartFile file:files) {
            String fileName = file.getOriginalFilename();
            File dest = new File("E:\\",fileName);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
    @ModelAttribute
    public void findUser(@PathVariable Long id,Model model){
        User user = new User();
        user.setId(1);
        user.setName("job");
        model.addAttribute("user",user);
    }
    @GetMapping("/{id}/getUser.json")
    @ResponseBody
    public String getUser(Model model){
        log.info("getUser:"+model.containsAttribute("user"));
        log.info("getUser:"+JSONObject.toJSONString(model.getAttribute("user")));
        return "success";
    }
    @ModelAttribute
    public User findUserSingle(@PathVariable Long id){
        User user = new User();
        user.setId(1);
        user.setName("job2");
        return user;
    }
}
