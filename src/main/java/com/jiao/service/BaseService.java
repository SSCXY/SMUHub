package com.jiao.service;

import java.util.List;

public interface BaseService<T> {
//    增删改查
    public void add(T t);

    public void addForNotMatch(Object[] filedNames, Object[] fieldValues);

    public void delete(Integer id);

    public void update(T t);

    public T select(Integer id);

    public List<T> selectAll();
}
