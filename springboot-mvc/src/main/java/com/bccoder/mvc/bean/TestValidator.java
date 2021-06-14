package com.bccoder.mvc.bean;

import com.bccoder.mvc.annotation.CustomValidatorAnno;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TestValidator {

    @NotNull
    @Length(min = 3)
    private String name;

    @Min(value = 10000)
    private int id;

    @CustomValidatorAnno(max = 2)
    private int lookTime;

    @NotNull(message = "{test.prop}")
    private String testProp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLookTime() {
        return lookTime;
    }

    public void setLookTime(int lookTime) {
        this.lookTime = lookTime;
    }
}
