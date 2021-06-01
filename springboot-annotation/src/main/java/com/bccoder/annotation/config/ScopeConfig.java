package com.bccoder.annotation.config;

import com.bccoder.annotation.beans.ScopeEntity;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ScopeEntity oneScope(){
        ScopeEntity result = new ScopeEntity();
        result.setName("singleton");
        return result;
    }
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ScopeEntity twoScope(){
        ScopeEntity result = new ScopeEntity();
        result.setName("prototype");
        return result;
    }
}
