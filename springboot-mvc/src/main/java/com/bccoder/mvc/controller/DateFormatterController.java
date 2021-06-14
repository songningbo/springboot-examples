package com.bccoder.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("df")
public class DateFormatterController {

    @GetMapping("test")
    public String show (Date date){
        log.info(date.toString());
        return "success";
    }
}
