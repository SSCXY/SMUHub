package com.jiao.dao;

import org.apache.ibatis.annotations.Param;

public interface UserRoleDao extends BaseDao {
    public void deleteByUid(@Param("uid") Integer uid);
}
