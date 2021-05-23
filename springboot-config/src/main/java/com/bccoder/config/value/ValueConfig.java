package com.bccoder.config.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class ValueConfig {

    @Value("${testValue:test1}")
    private String testValue;

    @Value("${testfilepath}")
    private String testpath;

    public String getTestValue() {
        return testValue;
    }

    public String getTestpath() {
        return testpath;
    }
}
