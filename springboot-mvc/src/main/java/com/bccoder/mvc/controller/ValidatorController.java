package com.bccoder.mvc.controller;

import com.bccoder.mvc.bean.TestGroup;
import com.bccoder.mvc.bean.TestGroupSequence;
import com.bccoder.mvc.bean.TestValid;
import com.bccoder.mvc.bean.TestValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ValidatorController {

    @PostMapping(value = "test/validator",consumes = "application/json")
    public String testValidator(@Validated @RequestBody TestValidator testValidator){
        //返回错误信息
        return "success";
    }
    @PostMapping(value = "test/group",consumes = "application/json")
    public String testGroup(@Validated(value = TestGroup.Update.class) @RequestBody TestGroup testGroup){
        return "success";
    }
    @PostMapping(value = "test/valid",consumes = "application/json")
    public String testValid(@Valid @RequestBody TestValid testValid){
        return "success";
    }
    @PostMapping(value = "test/groupSeq",consumes = "application/json")
    public String testGroupSequence(@Validated(value = TestGroupSequence.class) @RequestBody TestValid testValid){
        return "success";
    }
}
