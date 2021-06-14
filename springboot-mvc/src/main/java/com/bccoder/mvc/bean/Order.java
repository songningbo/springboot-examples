package com.bccoder.mvc.bean;

import javax.validation.constraints.NotNull;

public class Order {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
