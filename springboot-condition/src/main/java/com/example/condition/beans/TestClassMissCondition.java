package com.example.condition.beans;

public class TestClassMissCondition {
    private String name;

    public TestClassMissCondition() {
    }

    public TestClassMissCondition(TestMissBean bean) {
        this.name = bean.getConditionalOnMissBean();
    }

    public String getName() {
        return name;
    }
}
