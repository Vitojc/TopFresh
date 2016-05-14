package com.youthlin.TopFresh.dao.impl;

import com.youthlin.TopFresh.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lin on 2016-05-03-003.
 * DAO组件的基类
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T get(Class<T> entityClazz, Serializable id) {
        return getSessionFactory().getCurrentSession().get(entityClazz, id);
    }

    @Override
    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Class<T> entityClazz, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?1")
                .setParameter("1", id).executeUpdate();
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        return find("select en from " + entityClass.getSimpleName() + " en");
    }

    @Override
    public long findCount(Class<T> entityClass) {
        List<?> list = find("select count(*) from " + entityClass.getSimpleName());
        if (list != null && list.size() == 1) {
            return (Long) list.get(0);
        }
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> find(String hql) {
        return (List<T>) getSessionFactory().getCurrentSession().createQuery(hql).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> find(String hql, Object... param) {
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        for (int i = 0, len = param.length; i < len; i++) {
            query.setParameter(i, param[i]);
        }
        return (List<T>) query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByPage(String hql, int pageNo, int pageSize) {
        return getSessionFactory().getCurrentSession().createQuery(hql)
                .setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByPage(String hql, int pageNo, int pageSize, Object... param) {
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        for (int i = 0, len = param.length; i < len; i++) {
            query.setParameter(i, param[i]);
        }
        return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
    }
}
