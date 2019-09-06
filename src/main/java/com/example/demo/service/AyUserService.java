package com.example.demo.service;

import com.example.demo.model.AyUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AyUserService {
    //增删改查
    AyUser findByid(String id);
    List<AyUser> findAll();//查询所有
    AyUser save(AyUser ayUser);//保存
    void  delete(String id);//删除
    //分页
    Page<AyUser> findAll(Pageable pageable);

    List<AyUser>findByName(String name);
    List<AyUser>findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<String> ids);


}
