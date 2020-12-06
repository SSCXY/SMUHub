package com.jiao.service.Impl;

import com.jiao.dao.BaseDao;
import com.jiao.dao.UploadfileDao;
import com.jiao.model.Uploadfile;
import com.jiao.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("fileService")
public class UploadfileServiceImpl extends BaseServiceImpl<Uploadfile> implements UploadfileService {
    @Autowired
    private UploadfileDao uploadfileDao;
    @Override
    public BaseDao getBaseDao() {
        return uploadfileDao;
    }
}
