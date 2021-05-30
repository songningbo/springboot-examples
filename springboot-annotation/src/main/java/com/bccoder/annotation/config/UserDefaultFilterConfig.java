package com.bccoder.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.bccoder.annotation",useDefaultFilters = false)
public class UserDefaultFilterConfig {
}
