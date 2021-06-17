package com.bccoder.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(BizException.class)
    public String handlerException(Exception ex, HttpServletRequest request){
        BizException exception = (BizException) ex;
        Map<String,Object> map = new HashMap<>();
        map.put("code",exception.getCode());
        map.put("message",exception.getMsg());
        request.setAttribute("extMsg",map);
        return "forward:/error";
    }
}
