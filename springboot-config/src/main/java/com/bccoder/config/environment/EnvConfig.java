package com.bccoder.config.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvConfig {

    @Autowired
    private Environment env;

    public String getEnv(){
        return env.getProperty("testEnv");
    }
    public String getFilePath(){return env.getProperty("testfilepath");}
}
