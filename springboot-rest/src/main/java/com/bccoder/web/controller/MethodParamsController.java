package com.bccoder.web.controller;

import com.bccoder.web.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @RestControlloer = @Controller + @ResponseBody
 */
@RestController
@RequestMapping("/user/{name}")
public class MethodParamsController {

    @RequestMapping(path = "/{address}")
    public String query(@PathVariable("name") String username,@PathVariable("address") String address){
        return "hello,你叫什么？我叫"+username+",你住在哪里？我住在"+address;
    }

    @RequestMapping(path = "/info")
    public String queryVariable(@PathVariable("name") String name){
        return "hello,你是谁啊？我是"+name;
    }

    @RequestMapping(path = "/info1")
    public String queryVariable1(@PathVariable String name){
        return "hello,你是谁啊？我是"+name;
    }

    @RequestMapping(path = "/{age}/info1")
    public String queryVariable2(@PathVariable String name,@PathVariable Long age){
        return "hello,你是谁啊？我是"+name+"你多大了？我"+age+"岁了";
    }

    @GetMapping(path="/update2.json")
    public String getUser2(Integer id,String name){
        return "id:"+id+",name:"+name;
    }

    @GetMapping(path="/update3.json")
    public String getUser3(@RequestParam(value = "addr") String address,@RequestParam(value = "name",required = true) String name,
                           @RequestParam(value = "age",required = false) Integer age,@RequestParam(value = "sex",defaultValue = "男")String sex){
        return "address:"+address+",name:"+name+",age:"+age+",sex:"+sex;
    }

    @GetMapping(path="/update4.json")
    public User getUser4(User user){
        return user;
    }
}
