package com.jiao.service;

import com.jiao.model.Resource;

import java.util.List;

public interface ResourceService extends BaseService<Resource> {
    void initPaths(List<String> paths);
}
