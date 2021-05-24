package com.bccoder.condition.beans;

public class TestConditionMissBean {
    private String name;

    public TestConditionMissBean() {
    }

    public TestConditionMissBean(TestMissBean bean) {
        this.name = bean.getConditionalOnMissBean();
    }

    public String getName() {
        return name;
    }
}
