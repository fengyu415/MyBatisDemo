package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserListById(int id);

    List<User>  getUserListByMap(Map<String,Object> map);

    List<User> getUserListByNP(@Param("name") String name, @Param("pwd") String pwd);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
