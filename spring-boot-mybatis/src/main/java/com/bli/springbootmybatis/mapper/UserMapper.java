package com.bli.springbootmybatis.mapper;

import com.bli.springbootmybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author bo li
 * @date 2019-06-20 17:27
 */
public interface UserMapper {

    @Select("SELECT * FROM USER")
    List<User> selectAll();

    @Insert("INSERT INTO USER (username, password) VALUES(#{username}, #{password})")
    void insert(User user);
}
