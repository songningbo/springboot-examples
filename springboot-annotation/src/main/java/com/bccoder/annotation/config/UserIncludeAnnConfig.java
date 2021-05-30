package com.bccoder.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = "com.bccoder.annotation",useDefaultFilters = false,includeFilters = {
        @ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class})} )
public class UserIncludeAnnConfig {
}
