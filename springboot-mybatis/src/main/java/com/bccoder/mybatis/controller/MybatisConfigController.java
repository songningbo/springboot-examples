package com.bccoder.mybatis.controller;

import com.bccoder.mybatis.data.page.Page;
import com.bccoder.mybatis.data.page.PageDataFormat;
import com.bccoder.mybatis.data.page.PageParameter;
import com.bccoder.mybatis.data.persistence.entity.TUser;
import com.bccoder.mybatis.data.persistence.entity.TUserExample;
import com.bccoder.mybatis.data.persistence.mybatis.mappers.TUserMapper;
import com.bccoder.mybatis.protocol.req.UserReq;
import com.bccoder.mybatis.protocol.resp.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mybatis/config")
@ResponseBody
public class MybatisConfigController {

    @Resource
    TUserMapper userMapper;

    @PutMapping("add")
    public String add(){
        TUser user = new TUser();
        user.setId(2);
        user.setName("tom");
        user.setAge(18);
        user.setAddress("北京");
        userMapper.insert(user);
        return "add success";
    }
    @PutMapping("update")
    public String update(){
        TUser user= userMapper.selectByPrimaryKey(1);
        user.setName("updateName");
        userMapper.updateByPrimaryKey(user);
        return "update success";
    }

    @DeleteMapping("del")
    public String del(){
        userMapper.deleteByPrimaryKey(1);
        return "delete success";
    }

    @GetMapping("query")
    public TUser query(){
        TUser result = userMapper.selectByPrimaryKey(1);
        return result;
    }

    @PostMapping("queryPage")
    public UserResp queryPage(@RequestBody UserReq req){
        UserResp resp = new UserResp();
        Page p = new Page();
        PageParameter page = new PageParameter();
        page.setCurrentPage(req.getCurrPage());
        page.setPageSize(req.getPageCount());
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", page);
        List<TUser> list = userMapper.queryQueryPage(paramMap);
        p.setData(list);
        TUserExample example = new TUserExample();
        example.createCriteria();
        p.setTotalCount(userMapper.countByExample(example));
        resp.setList(PageDataFormat.formattMap(p));
        return resp;
    }
}
