package com.bccoder.mvc.config;

import com.bccoder.mvc.interceptor.CustomHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 增加一个拦截器，检查会话URL以user开头都使用此拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new CustomHandlerInterceptor())
                .addPathPatterns("/interceptor/**")
                .excludePathPatterns("/interceptor/");
    }

    /**
     * 1. 允许所有跨域访问。
     * 2. 细粒度控制跨域访问。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //1. 允许所有跨域访问
//        registry.addMapping("/**");
        //2. 细粒度控制跨域访问 仅允许bccoder.cn的跨域访问，并且限定访问路径为/cors，方法是POST和GET方法。
        registry.addMapping("/cors/*")
                .allowedOrigins("http://bccoder.cn")
                .allowedMethods("POST","GET");
    }

    /**
     * DateFormatter类实现将字符串转为日期类型java.util.Data
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

}
