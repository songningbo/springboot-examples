package com.bccoder.web.controller;

import com.bccoder.web.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
