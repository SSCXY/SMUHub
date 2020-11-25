package com.jiao.service;

import com.github.pagehelper.PageInfo;
import com.jiao.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    void addUser(User user, Integer[] roleIds);

    List<User> selectRelevanceUsers();

    public PageInfo<User> selectUserByPager(int pageNum, int pageSize);
}
