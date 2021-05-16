package com.bccoder.web.controller;

import com.bccoder.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UrlMatchController {

    @RequestMapping(value = "get/{id}.json")
    public @ResponseBody User query(@PathVariable("id") Long id){
        User user = new User();
        user.setId(id);
        user.setUserName("菠菜编程");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "get/test/{id}.json")
    public @ResponseBody User queryTest(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setUserName("菠菜编程");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query1/*.json")
    public @ResponseBody User query1(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query1");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query2/**/1.json")
    public @ResponseBody User query2(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query2");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query3/?.json")
    public @ResponseBody User query3(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query3");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "${test.url}.json")
    public @ResponseBody User query4(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query4");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query5/1.json")
    public @ResponseBody User query5(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query5");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query5/*.json")
    public @ResponseBody User query6(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query6");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query7/*/1.json")
    public @ResponseBody User query7(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query7");
        user.setAge("1");
        return user;
    }

    @RequestMapping(value = "query7/**/1.json")
    public @ResponseBody User query8(){
        User user = new User();
        user.setId(1L);
        user.setUserName("菠菜编程 method:"+"query8");
        user.setAge("1");
        return user;
    }
}
