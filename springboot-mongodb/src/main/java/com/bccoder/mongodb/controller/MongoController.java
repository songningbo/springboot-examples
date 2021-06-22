package com.bccoder.mongodb.controller;

import com.bccoder.mongodb.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mongo")
public class MongoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("document/insert")
    public String insertDoc(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setName("tom");
        userEntity.setAge(18);
        userEntity.setAddress("北京");
        mongoTemplate.insert(userEntity);
        return "mongo insert document";
    }
    @GetMapping("collection/insert")
    public String insertCol(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(2);
        userEntity.setName("tom");
        userEntity.setAge(18);
        userEntity.setAddress("北京");
        mongoTemplate.insert(userEntity,"myCollection");
        return "mongo insert collection";
    }
    @GetMapping("document/save")
    public String saveDoc(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(3);
        userEntity.setName("tom");
        userEntity.setAge(18);
        userEntity.setAddress("北京");
        mongoTemplate.save(userEntity);
        return "mongo save document";
    }

    @GetMapping("document/findById")
    public UserEntity findDoc(){
        UserEntity userEntity = mongoTemplate.findById(1,UserEntity.class,"demo_collection");
        return userEntity;
    }

    @GetMapping("document/find")
    public List<UserEntity> find(){
        Criteria criteria = Criteria.where("id").gt(1);
        List<UserEntity> list = mongoTemplate.find(Query.query(criteria),UserEntity.class);
        return list;
    }
}
