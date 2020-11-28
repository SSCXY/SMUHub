package com.jiao.dao;

import com.jiao.model.Resource;
import org.apache.ibatis.annotations.Param;

public interface ResourceDao extends BaseDao {
    int selectCountResByPath();
}
