package com.bccoder.condition.beans;

public class TestConditionBean {
    private String name;

    public TestConditionBean() {
    }

    public TestConditionBean(TestBean bean) {
        this.name = bean.getConditionalOnBean();
    }

    public String getName() {
        return name;
    }
}
