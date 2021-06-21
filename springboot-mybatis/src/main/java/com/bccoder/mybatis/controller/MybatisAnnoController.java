package com.bccoder.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.bccoder.mybatis.data.annotation.entity.TUser;
import com.bccoder.mybatis.data.annotation.mappers.UserAnnoMapper;
import com.bccoder.mybatis.protocol.req.UserReq;
import com.bccoder.mybatis.protocol.resp.UserResp;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mybatis/anno")
public class MybatisAnnoController {

    @Resource
    private UserAnnoMapper userAnnoMapper;

    @RequestMapping("query")
    public TUser query(){
        return userAnnoMapper.findById(2);
    }

    @PostMapping("queryPage")
    public UserResp queryPage(UserReq req){
        UserResp resp = new UserResp();
        List<TUser> list = userAnnoMapper.findAllUserPage(req.getCurrPage(),req.getPageCount());
        resp.setList(JSONObject.toJSONString(list));
        return resp;
    }

    @RequestMapping("add")
    public String insert(){
        TUser tUser = new TUser();
        tUser.setName("薛毛");
        tUser.setAge(30);
        tUser.setAddress("王店");
        userAnnoMapper.insert(tUser);
        return "success";
    }

    @RequestMapping("batchAdd")
    public String batchAdd(){
        List<TUser> list = new ArrayList<>();
        TUser tUser = new TUser();
        tUser.setName("薛毛");
        tUser.setAge(30);
        tUser.setAddress("王店");

        TUser tUser2 = new TUser();
        tUser2.setName("薛毛");
        tUser2.setAge(30);
        tUser2.setAddress("王店");
        list.add(tUser);
        list.add(tUser2);
        userAnnoMapper.batchInsert(list);
        return "success";
    }

    @RequestMapping("update")
    public String update(){
        userAnnoMapper.update(2,"big Tom");
        return "success";
    }

    @RequestMapping("del")
    public String del(){
        userAnnoMapper.delete(2);
        return "success";
    }

    @RequestMapping("batchDel")
    public String batchDel(){
        List<TUser> list = new ArrayList<>();
        TUser tUser = new TUser();
        tUser.setId(10);
        tUser.setName("薛毛");
        tUser.setAge(30);
        tUser.setAddress("王店");

        TUser tUser2 = new TUser();
        tUser2.setId(11);
        tUser2.setName("薛毛");
        tUser2.setAge(30);
        tUser2.setAddress("王店");
        list.add(tUser);
        list.add(tUser2);
        userAnnoMapper.batchDelete(list);
        return "success";
    }
}
