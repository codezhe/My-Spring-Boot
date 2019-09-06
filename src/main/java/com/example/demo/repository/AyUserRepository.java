package com.example.demo.repository;

import com.example.demo.model.AyUser;
import org.atmosphere.config.service.Delete;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

/**
 * @author Somebody
 */
public interface AyUserRepository extends JpaRepository<AyUser, String> {
    /*
    通过名字相等查询，参数为name
    ==selec u from ay_user u where u.name = ?1
     */
    List<AyUser> findByName(String name);

    /*
    name like查询
     */
    List<AyUser> findByNameLike(String name);

    /*
    查询id集合
     */
    List<AyUser> findByIdIn(Collection<String> ids);



}
