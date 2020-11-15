package com.jiao.dao;

import com.jiao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao {
    public User getUserByName(@Param("username") String username);
}
