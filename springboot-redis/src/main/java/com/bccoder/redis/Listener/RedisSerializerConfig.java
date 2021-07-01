package com.bccoder.redis.Listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

@Configuration
public class RedisSerializerConfig {
    /**
     * 配置key的序列化策略
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object,Object> keySerializerConfig(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object,Object> template = new RedisTemplate<Object,Object>();
        template.setConnectionFactory(redisConnectionFactory);
        //对Key进行自定义序列化
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        return template;
    }
    @Bean
    public RedisTemplate<Object,Object> jsonSerializerConfig(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object,Object> template = new RedisTemplate<Object,Object>();
        template.setConnectionFactory(redisConnectionFactory);
        //使用JSON自定义序列化
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
    @Bean
    public RedisTemplate<Object,Object> mapperSerializerConfig(RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) throws UnknownHostException {
        RedisTemplate<Object,Object> template = new RedisTemplate<Object,Object>();
        template.setConnectionFactory(redisConnectionFactory);
        //使用JSON自定义序列化
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        return template;
    }

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        return mapper;
    }

    @Bean
    @Primary
    public MessageListenerAdapter listenerAdapterSerializer() {
        MessageListenerAdapter adapter = new MessageListenerAdapter(new MyRedisChannelListener());
        //改成使用JDK序列化机制
        adapter.setSerializer(new JdkSerializationRedisSerializer());
        return adapter;
    }
}
