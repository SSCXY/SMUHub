package com.jiao.service.Impl;

import com.jiao.dao.BaseDao;
import com.jiao.dao.RoleDao;
import com.jiao.model.Role;
import com.jiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public BaseDao getBaseDao() {
        return roleDao;
    }
}
