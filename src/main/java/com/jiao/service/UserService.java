package com.jiao.service;

import com.github.pagehelper.PageInfo;
import com.jiao.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    void addUser(User user, Integer[] roleIds);

    List<User> selectRelevanceUsers();

    public PageInfo<User> selectUserByPager(int pageNum, int pageSize);

    public User selectRelUserByUid(Integer uid);

    public void updateUser(User user, Integer[] roleIds);

    public void deleteByUidRelRole(Integer id);

    void batchDelUserBuIds(Integer[] uidArr);


    PageInfo<User> selectUserBySearchPage(int pageNum, int pageSize, String userInfo);

    User login(String userInfo, String password);
}
