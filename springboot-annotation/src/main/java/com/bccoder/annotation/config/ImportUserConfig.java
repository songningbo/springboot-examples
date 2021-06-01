package com.bccoder.annotation.config;

import com.bccoder.annotation.beans.ImportEntity;
import com.bccoder.annotation.beans.UserEntity;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@Import(ImportConfig.class)
public class ImportUserConfig {
    @Bean
    @Primary
    public ImportEntity testImport(ImportEntity importEntity){
        System.out.println(importEntity.getName());
        importEntity.setName("test @import success");
        return importEntity;
    }
}
