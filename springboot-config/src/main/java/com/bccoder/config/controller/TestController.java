package com.bccoder.config.controller;

import com.bccoder.config.environment.EnvConfig;
import com.bccoder.config.multivalue.MultiValue;
import com.bccoder.config.random.RandomConfig;
import com.bccoder.config.value.ValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class TestController {

    @Autowired
    private EnvConfig envConfig;
    @Autowired
    private MultiValue multiValue;
    @Autowired
    private ValueConfig valueConfig;
    @Autowired
    private RandomConfig randomConfig;
    @Value("${testRef}")
    private String testRef;

    @GetMapping("env")
    public String showEnv(){
        return envConfig.getEnv()+"::::"+envConfig.getFilePath();
    }

    @GetMapping("value")
    public String showValue(){
        return valueConfig.getTestValue()+"::::"+valueConfig.getTestpath();
    }

    @GetMapping("conf")
    public String showConf(){
        return multiValue.getTestConfig()+"::::"+multiValue.getServers().get(0)+"::::"+multiValue.getServers().get(1);
    }

    @GetMapping("ref")
    public String showRef(){
        return testRef;
    }

    @GetMapping("random")
    public String random(){
        return randomConfig.getValue()+"::::"+randomConfig.getNumber()+"::::"+randomConfig.getBignumber()
                +"::::"+randomConfig.getTest1()+"::::"+randomConfig.getTest2();
    }
}
