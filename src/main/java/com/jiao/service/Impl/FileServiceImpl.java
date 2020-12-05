package com.jiao.service.Impl;

import com.jiao.dao.BaseDao;
import com.jiao.dao.FileDao;
import com.jiao.model.UploadFile;
import com.jiao.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileServiceImpl extends BaseServiceImpl<UploadFile> implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public BaseDao getBaseDao() {
        return fileDao;
    }
}
