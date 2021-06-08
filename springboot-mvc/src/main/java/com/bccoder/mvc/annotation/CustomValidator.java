package com.bccoder.mvc.annotation;

import com.bccoder.mvc.bean.CustomValidatorBean;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CustomValidatorBean.class})
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidator {
    String message() default "玩手机时间，不能超过{max}小时";
    int max() default 3;
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
