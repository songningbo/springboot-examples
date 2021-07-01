package com.bccoder.elasticsearch.dao;

import com.bccoder.elasticsearch.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserEntity,String> {
    public List<UserEntity> getByName(String key);
    public Page<UserEntity> getByName(String key, Pageable request);
}
