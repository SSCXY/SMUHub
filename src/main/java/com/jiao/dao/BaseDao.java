package com.jiao.dao;

import org.apache.ibatis.annotations.Param;
import sun.net.idn.Punycode;

import java.util.List;
import java.util.Map;

public interface BaseDao {
//    增删改查的公用方法
    public void add(@Param("tableName") String tableName, @Param("objects") Object[] objects);
    public void delete(@Param("tableName") String tableName, @Param("id") Integer id);
    public void update(@Param("tableName") String tableName, @Param("id") Integer id, @Param("objects") Object[] objects);
    public Map<Object, Object> select(@Param("tableName") String tableName, @Param("id") Integer id);
    public List<Map<Object, Object>> selectAll(@Param("tableName") String tableName);

    public void addForNotMatch(@Param("tableName") String tableName,@Param("filedNames")Object[] filedNames, @Param("fieldValues")Object[] fieldValues);
}
