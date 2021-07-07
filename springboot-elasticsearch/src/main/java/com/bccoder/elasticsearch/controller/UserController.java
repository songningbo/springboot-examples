package com.bccoder.elasticsearch.controller;

import com.bccoder.elasticsearch.dao.UserDao;
import com.bccoder.elasticsearch.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("es")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("save")
    public String save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setName("tom");
        userEntity.setAddress("北京");
        userDao.save(userEntity);
        return "success";
    }

    @GetMapping("get/id")
    public UserEntity getUserById(){
        Optional<UserEntity> opt = userDao.findById("1");
        UserEntity userEntity = opt.get();
        return userEntity;
    }

    @GetMapping("get/search")
    public List<UserEntity> getUserSearch(){
        List<UserEntity> list = userDao.getByName("tom");
        return list;
    }

    @GetMapping("get/page")
    public Page<UserEntity> getUserSearchPage(){
        int pageCount = 1;
        int pageSize = 0;
        PageRequest request = PageRequest.of(pageSize,pageCount);
        Page<UserEntity> pages = userDao.getByName("tom",request);
        return pages;
    }
}
