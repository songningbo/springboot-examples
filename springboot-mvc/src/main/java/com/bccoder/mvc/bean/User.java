package com.bccoder.mvc.bean;

import com.bccoder.mvc.annotation.CustomValidator;

public class User {
    private long id;
    private String name;

    @CustomValidator(max = 10)
    private int look;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLook() {
        return look;
    }

    public void setLook(int look) {
        this.look = look;
    }
}
