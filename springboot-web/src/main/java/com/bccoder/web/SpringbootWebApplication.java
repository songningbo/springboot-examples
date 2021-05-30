package com.bccoder.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }
}
