package com.jiao.dao;

import com.jiao.model.Role;
import com.jiao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao {
    public User getUserByName(@Param("username") String username);

    List<User> selectRelevanceUsers();

    Role getRoleByUid();

    public User getUserByUid(@Param("uid") Integer uid);

    List<User> selectUserBySearchPage(@Param("userInfo") String userInfo);
}
