package com.bccoder.condition.beans;

public class MyService {
    private String name;

    public MyService() {
    }

    public MyService(TestBean bean) {
        this.name = bean.getName();
    }

    public String getName() {
        return name;
    }
}
