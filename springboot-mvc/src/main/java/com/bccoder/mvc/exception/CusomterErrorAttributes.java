package com.bccoder.mvc.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CusomterErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        // 0是从Request中获取数据，1是从session域中获取数据
        Map<String, Object> extMsg = (Map<String, Object>) webRequest.getAttribute("extMsg",0);
        map.put("test","testExtMsg");
        map.put("extMsg",extMsg);
        map.put("message","test");
        return map;
    }
}
