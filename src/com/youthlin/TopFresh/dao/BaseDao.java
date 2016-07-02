package com.youthlin.TopFresh.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lin on 2016-05-03-003.
 * DAO组件的基接口
 */
public interface BaseDao<T> {

    T get(Class<T> entityClazz, Serializable id);

    Serializable save(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(Class<T> entityClazz, Serializable id);

    List<T> findAll(Class<T> entityClass);

    long findCount(Class<T> entityClass);

    List<T> find(String hql);

    List<T> find(String hql, Object... param);

    List<T> findByPage(String hql, int pageNo, int pageSize);

    List<T> findByPage(String hql, int pageNo, int pageSize, Object... param);

    void clear();
}
