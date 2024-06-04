package com.soft.park.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

public class BeanUtil {

    /**
     * 复制bean的属性
     * 支持同名字段类型不同
     *
     * @param source 源 要复制的对象
     * @param target 目标 复制到此对象
     */
    public static void copyProperties(Object source, Object target) {
       cn.hutool.core.bean.BeanUtil.copyProperties(source, target);
    }

    /**
     * 复制对象
     *
     * @param source 源 要复制的对象
     * @param target 目标 复制到此对象
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> target) {
        if(source == null){
            return null;
        }
        try {
            T newInstance = target.newInstance();
            BeanUtils.copyProperties(source, newInstance);
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 复制list
     *
     * @param source
     * @param target
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> List<K> copyList(List<T> source, Class<K> target) {

        if (null == source || source.isEmpty()) {
            return new ArrayList<>();
        }
        return source.stream().map(e -> copy(e, target)).collect(Collectors.toList());
    }

    /**
     * 复制list
     * 支持同名字段类型不同
     *
     * copyList() 方法不支持类型不同, 类型不同时同名字段值不能复制, 会是null
     *
     *
     *
     */
    public static <T, K> List<K> copyToList(List<T> source, Class<K> target) {
        return cn.hutool.core.bean.BeanUtil.copyToList(source, target);
    }



    /**
     * 把List<Object[]>转换成List<T>
     */
    public static <T> List<T> objectToBean(List<Object[]> objList, Class<T> clz) throws Exception {
        if (objList == null || objList.size() == 0) {
            return null;
        }

        Class<?>[] cz = null;
        Constructor<?>[] cons = clz.getConstructors();
        for (Constructor<?> ct : cons) {
            Class<?>[] clazz = ct.getParameterTypes();
            if (objList.get(0).length == clazz.length) {
                cz = clazz;
                break;
            }
        }

        List<T> list = new ArrayList<T>();
        for (Object[] obj : objList) {
            Constructor<T> cr = clz.getConstructor(cz);
            list.add(cr.newInstance(obj));
        }
        return list;

    }

    public static void copyNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullField(source));
    }

    /**
     * 获取属性中为空的字段
     *
     * @param target
     * @return
     */
    private static String[] getNullField(Object target) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(target);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        Set<String> notNullFieldSet = new HashSet<>();
        if (propertyDescriptors.length > 0) {
            for (PropertyDescriptor p : propertyDescriptors) {
                String name = p.getName();
                Object value = beanWrapper.getPropertyValue(name);
                if (Objects.isNull(value)) {
                    notNullFieldSet.add(name);
                }
            }
        }
        String[] notNullField = new String[notNullFieldSet.size()];
        return notNullFieldSet.toArray(notNullField);
    }

    // public static <T> Page<T> listConvertToPage(List<T> list, Pageable pageable) {
    //
    //     int start = ( int )pageable.getOffset();
    //     int end = Math.min((start + pageable.getPageSize()), list.size());
    //     if(start > end){
    //         return new PageImpl<>(new ArrayList<>(), pageable, list.size());
    //     }
    //     return new PageImpl<>(list.subList(start, end), pageable, list.size());
    // }
}
