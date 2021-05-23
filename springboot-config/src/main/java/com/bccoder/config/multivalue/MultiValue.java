package com.bccoder.config.multivalue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "my")
public class MultiValue {

    private String testConfig;
    private List<String> servers = new ArrayList<String>();

    public String getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(String testConfig) {
        this.testConfig = testConfig;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
