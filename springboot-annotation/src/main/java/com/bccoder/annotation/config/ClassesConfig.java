package com.bccoder.annotation.config;

import com.bccoder.annotation.beans.UserNoAnnDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = UserNoAnnDao.class)
public class ClassesConfig {
}
