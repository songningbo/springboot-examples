package com.bccoder.mvc.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bccoder.mvc.interceptor.CustomHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 增加一个拦截器，检查会话URL以user开头都使用此拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
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
                .allowedMethods("POST", "GET");
    }

    /**
     * DateFormatter类实现将字符串转为日期类型java.util.Data
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 可以直接将URI请求转到对模版的渲染上
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //对于index.jsp的请求，设置返回/index.html视图
        //所有以.do结尾的请求重定向到/index.jsp
        registry.addViewController("/index.jsp").setViewName("/index.html");
        registry.addRedirectViewController("/**/*.do", "/index.jsp");
    }

    /**
     * 配置静态资源位置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //可以通过http://localhost:8080/img/test.jpeg访问resources/web/test.jpeg
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1. 调用父类的配置
        WebMvcConfigurer.super.configureMessageConverters(converters);
        //2. 创建fastjson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //3. 创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //4. 修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //5. 将fastjson添加到视图消息转换器列表中
        converters.add(fastConverter);
    }

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        Map<String , MediaType> mediaTypeMap = new HashMap<>();
//        mediaTypeMap.put("html",MediaType.TEXT_HTML);
//        mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
//        configurer
//                //设置时候禁止进行对request头的accept检查
//                .ignoreAcceptHeader(true)
//                //设置要用于确定请求的媒体类型的参数的名称，默认为format
//                .parameterName("mediaType")
//                //设置默认的mediaType
//                .defaultContentType(MediaType.TEXT_HTML)
//                // 以.html结尾会被当成MediaType.TEXT_HTML
//                // 以.json结尾会被当成MediaType.APPLICATION_JSON
//                .mediaTypes(mediaTypeMap);
//    }
}