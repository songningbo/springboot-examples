package com.bccoder.mvc.bean;

import com.bccoder.mvc.annotation.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidatorBean implements ConstraintValidator<CustomValidator,Integer> {
    CustomValidator customValidator;
    int max;
    /**
     * 初始化方法
     */
    @Override
    public void initialize(CustomValidator constraintAnnotation) {
        this.customValidator = constraintAnnotation;
        max = constraintAnnotation.max();
    }
    /**
     * 逻辑处理
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(null == value){
            return true;
        }
        return value<max;
    }
}
