package com.bccoder.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootConfigApplication {

    public static void main(String[] args) {
        //1. 默认配置文件
//        SpringApplication.run(SpringbootConfigApplication.class, args);
        //2. 指定配置文件目录
//        new SpringApplicationBuilder(SpringbootConfigApplication.class)
//                .properties("spring.config.location=classpath:/test/application.properties")
//                .run(args);
        //3. 指定配置文件名称
        new SpringApplicationBuilder(SpringbootConfigApplication.class)
                .properties("spring.config.name=test").run(args);
    }

}
