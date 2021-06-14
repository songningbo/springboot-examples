package com.bccoder.mvc.bean;

import com.bccoder.mvc.annotation.CustomValidatorAnno;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomValidatorAnno,Integer> {
    CustomValidatorAnno customValidator;
    int max;
    /**
     * 初始化方法
     */
    @Override
    public void initialize(CustomValidatorAnno constraintAnnotation) {
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
