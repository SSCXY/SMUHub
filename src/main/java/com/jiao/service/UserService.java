package com.jiao.service;

import com.jiao.model.User;

public interface UserService extends BaseService<User> {
    void addUser(User user, Integer[] roleIds);
}
