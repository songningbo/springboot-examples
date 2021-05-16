package com.bccoder.web.controller;

import com.bccoder.web.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HttpMethodController {

    @GetMapping(value = "get/all/get.json")
    public @ResponseBody User get(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:get()");
        user.setAge("18");
        return user;
    }
    @PostMapping(value = "get/all/post.json")
    public @ResponseBody User post(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:post()");
        user.setAge("18");
        return user;
    }
    @PutMapping(value = "get/all/put.json")
    public @ResponseBody User put(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:put()");
        user.setAge("18");
        return user;
    }
    @DeleteMapping(value = "get/all/delete.json")
    public @ResponseBody User delete(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:delete()");
        user.setAge("18");
        return user;
    }
    @PatchMapping(value = "get/all/patch.json")
    public @ResponseBody User patch(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:patch()");
        user.setAge("18");
        return user;
    }

    @GetMapping(value = "consumes/test.json",consumes = "application/json")
    @ResponseBody
    public User forJson(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:forJson()");
        user.setAge("18");
        return user;
    }
    @GetMapping(value = "get/test.json",produces = "application/json")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程:Method:getUser()");
        user.setAge("18");
        return user;
    }
    @GetMapping(value = "get/testStr.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getStr(){
        return "Hello";
    }
}
