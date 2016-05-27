package com.youthlin.TopFresh.dao.impl;

import com.youthlin.TopFresh.dao.ProductTypeDAO;
import com.youthlin.TopFresh.po.ProductType;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016-05-13-013.
 * 种类DAO组件实现类
 */
public class ProductTypeDAOImpl extends BaseDaoImpl<ProductType> implements ProductTypeDAO {
    //删除父类时子类一并删除
    @Override
    public void delete(Class<ProductType> entityClazz, Serializable id) {
        Session session = getSessionFactory().getCurrentSession();
        List list = session.createQuery("from " + entityClazz.getSimpleName()
                + " en where en.typeParent.id = ?1").setParameter("1", id).list();
        System.out.println("将要删除:" + list);
//        session.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?1").setParameter("1", id).executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductType> willDelete(Class<ProductType> entityClazz, Serializable id) {
        Session session = getSessionFactory().getCurrentSession();
        List list = session.createQuery("from " + entityClazz.getSimpleName()
                + " en where en.typeParent.id = ?1").setParameter("1", id).list();
//        System.out.println("将要删除:" + list);
        List<ProductType> toDelete = new ArrayList<>();
        toDelete.add(get(entityClazz, id));
        toDelete.addAll(list);
        return toDelete;
    }
}
