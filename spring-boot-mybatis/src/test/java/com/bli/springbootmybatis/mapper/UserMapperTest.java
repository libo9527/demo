package com.bli.springbootmybatis.mapper;

import com.bli.springbootmybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author bo li
 * @date 2019-07-08 16:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();
        Assert.notEmpty(users, "users is empty.");
    }

    @Test
    public void testInsert() {
        userMapper.insert(User.builder().username("test").password("123456").build());
    }
}
