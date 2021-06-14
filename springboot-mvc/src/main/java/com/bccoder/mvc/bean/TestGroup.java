package com.bccoder.mvc.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class TestGroup {
    public interface Update{}
    public interface Add{}
    public interface IGroupA{}
    public interface IGroupB{}

    @NotNull(groups = Add.class,message = "添加时id不能为空")
    @Null(groups = Update.class,message = "更新时id可以为空")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
