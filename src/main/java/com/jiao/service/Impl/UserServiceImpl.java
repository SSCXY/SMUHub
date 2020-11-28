package com.jiao.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiao.dao.BaseDao;
import com.jiao.dao.UserDao;
import com.jiao.dao.UserRoleDao;
import com.jiao.model.User;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

        this.addForNotMatch(new Object[]{"username", "password", "email", "phone", "enable", "add_date"}
                            , new Object[]{user.getUsername(), user.getPassword(), user.getEmail(),user.getPhone(),1, new Date()});
        User u = userDao.getUserByName(user.getUsername());
        for(Integer rid : roleIds){
            userRoleDao.add("t_user_role", new Object[] {null,u.getId(), rid});
        }
    }

    @Override
    public List<User> selectRelevanceUsers() {
        List<User> users = userDao.selectRelevanceUsers();
        return users;
    }

    @Override
    public PageInfo<User> selectUserByPager(int pageNum, int pageSize) {
        Page<User> pager = PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userDao.selectRelevanceUsers();
        PageInfo<User> info = new PageInfo<>(userList);
        return info;
    }

    @Override
    public User selectRelUserByUid(Integer uid) {
        User user = userDao.getUserByUid(uid);
        return user;
    }
}
