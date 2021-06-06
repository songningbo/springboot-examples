package com.bccoder.aop.entity;

import com.bccoder.aop.annotation.AdviceArgs;
import org.springframework.stereotype.Component;

@AdviceArgs
public class UserEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
