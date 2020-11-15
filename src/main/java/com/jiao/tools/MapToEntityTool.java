package com.jiao.tools;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToEntityTool {

    private static Map<String , EntityCacheItem> convertItemCache = new HashMap<>();

    public static <T> T map2entity(Map<Object, Object> map, Class<T> entityClass) {
//        通过entityClass类型参数，获取类型里面的属性名称集合
//        再获取类型里面的set方法的map集合

        EntityCacheItem entityCacheItem = convertItemCache.get(entityClass.getName());
        if(entityCacheItem == null){
            entityCacheItem = EntityCacheItem.createEntityCacheItem(entityClass);
            convertItemCache.put(entityClass.getName(), entityCacheItem);
        }
        List<String> fieldNameList = entityCacheItem.getFieldNameList();
        Map<String, Method> setMethodMap = entityCacheItem.getSetMethodMap();

        String key;
        String key1;
        String key2;

        Map<Object, Object> targetMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry: map.entrySet()) {
            key = (String)entry.getKey();

            while (key.contains("_")) {
                key1 = key.substring(0, key.indexOf("_"));
                key2 = key.substring(key.indexOf("_") + 1);
                key = key1 + key2.substring(0,1).toUpperCase() + key2.substring(1);
            }
            targetMap.put(key, entry.getValue());
        }

        T entity = null;
        try {
            entity = entityClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Class<?>[] parameterTypes = null;
        Method setMethod1 = null;
        Object mapFieldValue = null;
        for (String fieldName1 : fieldNameList) {
            mapFieldValue = targetMap.get(fieldName1);
            if (mapFieldValue == null) continue;
            setMethod1 = setMethodMap.get(fieldName1);
            if (setMethod1 == null) continue;
//            获取set方法中参数的对象
            parameterTypes = setMethod1.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length > 1) {
                continue;
            }
            if (parameterTypes[0].isAssignableFrom(mapFieldValue.getClass())) {
//                如果参数map传来的属性值的类型和set方法中参数的类型一致就可以调用set方法
                try {
                    setMethod1.invoke(entity, mapFieldValue);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        return entity;
    }

    static class EntityCacheItem {
        private List<String> fieldNameList = new ArrayList<>();
        private Map<String, Method> setMethodMap = new HashMap<>();

        private EntityCacheItem(){

        }

        public List<String> getFieldNameList() {
            return fieldNameList;
        }

        public Map<String, Method> getSetMethodMap() {
            return setMethodMap;
        }

        public void parseEntity(Class<?> entityClass) {
            Field[] fields = entityClass.getDeclaredFields();
            String fieldName;
            String setMethodName;
            Method setMethod = null;
            for (Field field : fields) {
                field.setAccessible(true);
//            打开获取private属性
                fieldName = field.getName();
                fieldNameList.add(fieldName);
                setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    setMethod = entityClass.getDeclaredMethod(setMethodName, field.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setMethodMap.put(fieldName, setMethod);
            }

        }

        public static EntityCacheItem createEntityCacheItem(Class<?> entityClass){
            EntityCacheItem ci = new EntityCacheItem();
            ci.parseEntity(entityClass);
            return ci;
        }


    }
}