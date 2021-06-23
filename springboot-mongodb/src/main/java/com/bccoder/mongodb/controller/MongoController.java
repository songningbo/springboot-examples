package com.bccoder.mongodb.controller;

import com.bccoder.mongodb.entity.UserEntity;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        Criteria criteria2 = Criteria.where("id").lt(2);
        List<UserEntity> list = mongoTemplate.find(Query.query(criteria.andOperator(criteria2)),UserEntity.class);
        return list;
    }

    @GetMapping("document/findPage")
    public List<UserEntity> findPage(){
        Criteria criteria = Criteria.where("id").in(1,2,3,4,5);
        Query query = Query.query(criteria);
        //查询总数
        long totalCount = mongoTemplate.count(query,UserEntity.class);
        //每页个数
        int numOfPage=10;
        //当前页
        int pageNum = 1;
        //计算总数
        long totalPage = totalCount%numOfPage==0?(totalCount/numOfPage):(totalCount/numOfPage+1);
        int skip=(pageNum-1)*numOfPage;
        query.skip(skip).limit(numOfPage);
        List<UserEntity> list = mongoTemplate.find(query,UserEntity.class);
        return list;
    }
    @GetMapping("document/update")
    public String update(){
        Criteria criteria = Criteria.where("id").in(1);
        Update update = new Update();
        //自增
        update.inc("age",1);
        UpdateResult result = mongoTemplate.updateMulti(Query.query(criteria),update,UserEntity.class);
        return "修改条数："+result.getModifiedCount();
    }

    @GetMapping("document/delete")
    public String delete(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(3);
        DeleteResult result = mongoTemplate.remove(userEntity);
        return "删除条数："+result.getDeletedCount();
    }

}
