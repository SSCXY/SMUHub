package com.jiao.service.Impl;

import com.jiao.dao.BaseDao;
import com.jiao.dao.ResourceDao;
import com.jiao.model.Resource;
import com.jiao.service.BaseService;
import com.jiao.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    @Autowired
    ResourceDao resourceDao;
    @Override
    public BaseDao getBaseDao() {
        return resourceDao;
    }

    @Override
    public void initPaths(List<String> paths) {
//        1.把数据插入到数据库表
        Resource resource = null;
        int resCount = 0;
        resCount = resourceDao.selectCountResByPath();
        for (String path : paths) {
            if (resCount == 0){
                this.add(new Resource(path));
            }
        }
    }
}
