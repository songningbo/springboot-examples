package com.bccoder.annotation.config;

import com.bccoder.annotation.beans.ImportEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ImportConfig {
    @Bean
    public ImportEntity importConfigTest(){
        return new ImportEntity();
    }
}
