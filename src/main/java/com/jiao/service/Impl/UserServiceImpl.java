package com.jiao.service.Impl;

import com.jiao.dao.BaseDao;
import com.jiao.dao.UserDao;
import com.jiao.dao.UserRoleDao;
import com.jiao.model.User;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public BaseDao getBaseDao() {
        return userDao;
    }

    @Transactional
    @Override
    public void addUser(User user, Integer[] roleIds) {
//        同时添加user和相关联的role表
        user.setEnable(1);
        user.setAddDate(new Date());
        this.add(user);
        User u = userDao.getUserByName(user.getUsername());
        for(Integer rid : roleIds){
            userRoleDao.add("t_user_role", new Object[] {u.getId(), rid});
        }
    }
}
