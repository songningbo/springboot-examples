package com.bccoder.mvc.bean;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TestValid {

    @NotNull(message = "名字不能为空",groups = TestGroup.IGroupA.class)
    private String name;

    @Min(value = 18,message = "年龄不能为空",groups = TestGroup.IGroupB.class)
    private Integer age;

    @Valid
    @Size(min = 2)
    private List<Order> order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
