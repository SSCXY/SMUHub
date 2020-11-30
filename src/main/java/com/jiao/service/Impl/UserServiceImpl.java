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

    @Transactional
    @Override
    public void updateUser(User user, Integer[] roleIds) {
        if(user.getPassword().trim().equals("")) user.setPassword(null);
//        先修改用户信息
        this.update(user);
//        再修改关联的角色信息
//        1.删除id是user.getId()的角色
        userRoleDao.deleteByUid(user.getId());
//        2.把接收到的roleIds关联的id从新添加到表中
        for (Integer rid: roleIds) {
            userRoleDao.add("t_user_role", new Object[]{null,user.getId(),rid});
        }
    }

    @Transactional
    @Override
    public void deleteByUidRelRole(Integer id) {
        userRoleDao.deleteByUid(id);
        this.delete(id);
    }

    @Override
    public void batchDelUserBuIds(Integer[] uidArr) {
        for (Integer id : uidArr) {
            this.deleteByUidRelRole(id);
        }
    }

    @Override
    public PageInfo<User> selectUserBySearchPage(int pageNum, int pageSize, String userInfo) {
        Page<User> pager = PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userDao.selectUserBySearchPage("%" + userInfo + "%");
        PageInfo<User> info = new PageInfo<>(userList);
        return info;
    }

    @Override
    public User login(String userInfo, String password) {
        User user = userDao.selectByUserInfo(userInfo);
        if(user == null) throw new RuntimeException("用户名或密码有误");
        if(!password.equals(user.getPassword())){
            throw new RuntimeException("用户名或密码有误");
        }
        return user;
    }
}
