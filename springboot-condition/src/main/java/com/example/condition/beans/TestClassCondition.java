package com.example.condition.beans;

public class TestClassCondition {
    private String name;

    public TestClassCondition() {
    }

    public TestClassCondition(TestBean bean) {
        this.name = bean.getConditionalOnBean();
    }

    public String getName() {
        return name;
    }
}
