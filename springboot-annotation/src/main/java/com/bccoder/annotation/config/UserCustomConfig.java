package com.bccoder.annotation.config;

import com.bccoder.annotation.typefilter.CustomTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value = "com.bccoder.annotation",useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,
                classes = {CustomTypeFilter.class}))
public class UserCustomConfig {
}
