package com.bccoder.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value = "com.bccoder.annotation",useDefaultFilters = false,includeFilters =
        {@ComponentScan.Filter(type = FilterType.REGEX,pattern = ".*Service")})
public class UserRegexConfig {
}
