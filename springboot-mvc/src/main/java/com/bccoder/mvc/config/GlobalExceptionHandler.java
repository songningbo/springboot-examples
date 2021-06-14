package com.bccoder.mvc.config;

import com.bccoder.mvc.bean.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截@Validated注解验证异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public HttpResult<Object> springValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder errMsg = new StringBuilder();
        allErrors.forEach(error -> {
            String objectName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errMsg.append(objectName).append(":").append(message).append(", ");
        });
        int len = errMsg.length();
        if (len > 1) {
            errMsg.delete(len - 2, len);
        }
        HttpResult<Object> data = HttpResult.builder()
                .code("400")
                .message(errMsg.toString())
                .build();
        log.warn("validated参数校验错误: {}", data);
        return data;
    }

    /**
     * 拦截@Valid注解验证异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public HttpResult<Object> jsr303ValidException(ConstraintViolationException e) {
        HttpResult<Object> data = HttpResult.builder()
                .code("400")
                .message(e.getMessage())
                .build();
        log.warn("valid参数校验错误: {}", data);
        return data;
    }

}
