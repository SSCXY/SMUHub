package com.jiao.service.Impl;

import com.jiao.dao.BaseDao;
import com.jiao.service.BaseService;
import com.jiao.tools.MapToEntityTool;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
//    直接注入无法获得BaseDao中的方法 需要通过子类的重写来获取
    public abstract BaseDao getBaseDao();
//    子类需要知道T是什么类
    public Class<?> clazz;
    public String tableName;
    public BaseServiceImpl(){

        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type[] types = pt.getActualTypeArguments();
        clazz = (Class<?>)types[0];
        tableName = "t_" + clazz.getSimpleName().toLowerCase();
    }


    @Override
    public void add(T t) {
//        把所有字段都放到list集合里面
        List<Object> list = new ArrayList<>();
        for (Field field:t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                list.add(field.get(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getBaseDao().add(tableName, list.toArray());
    }

    @Override
    public void delete(Integer id) {

        getBaseDao().delete(tableName,id);
    }

    @Override
    public void update(T t) {
        List<Object> list = new ArrayList<>();
        int id = 0;
        for (Field field:t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(t) == null){
                    continue;
                }
                if ("id".equals(field.getName())){
                    id = (int)field.get(t);
                    continue;
                }
//                剩下的才是要修改的字段
                list.add(field.getName() + "='" + field.get(t) + "'");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        getBaseDao().update(tableName, id, list.toArray());
    }

    @Override
    public T select(Integer id) {
        Map<Object, Object> rsMap = getBaseDao().select(tableName, id);
//        需要把map转换成相应的类型
        T t = (T) MapToEntityTool.map2entity(rsMap, clazz);
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> selectAll() {
        List<Map<Object, Object>> rsList = getBaseDao().selectAll(tableName);
        List<T> list = new ArrayList<>();
        T t = null;
        for (Map<Object, Object> map: rsList
             ) {
//            需要把每一个Map转换成T
            t = (T) MapToEntityTool.map2entity(map, clazz);
            list.add(t);
        }
        return list;
    }
}
