package com.bccoder.mvc.controller;

import com.bccoder.mvc.exception.BizException;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class TestErrorController {
    @GetMapping({"/testException"})
    public String testException(String id) throws BizException{
        if (!"1".equals(id)) {
            throw new BizException("1000","id不符合要求");
        }
        return "index";
    }
}
