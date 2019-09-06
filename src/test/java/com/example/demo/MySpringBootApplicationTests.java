package com.example.demo;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MySpringBootApplicationTests {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private AyUserService ayUserService;
    @Test
    public void  testRepository(){
        //查询所有的数据
        List<AyUser> userList =ayUserService.findAll();
        System.out.println("findAll:"+ userList.size());
       //删除数据
        try {
            ayUserService.delete("5");
            System.out.println("cg");
        } catch (Exception e) {
            System.out.println("失败");
        }
        //新增数据
        AyUser ayUser = new AyUser();
        ayUser.setId("66");
        ayUser.setName("test");
        ayUserService.save(ayUser);
    }
    /*
     mysql Spring Boot 测试
     */
    @Test
    public void MysqlTest() {
        String sql1 = "select id,name,password from ay_user ";
        List<AyUser> userlist = (List<AyUser>) jdbcTemplate.query(sql1, new RowMapper<AyUser>() {
            @Override
            public AyUser mapRow(ResultSet resultSet, int i) throws SQLException {
                AyUser user = new AyUser();

                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        System.out.println("查询成功：");
        for (AyUser user : userlist) {
            System.out.println("[id]:" + user.getId() + "[name]:" + user.getName() + "[password]:" + user.getPassword());
        }
    }
}
