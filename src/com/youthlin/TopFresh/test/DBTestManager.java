package com.youthlin.TopFresh.test;

import com.youthlin.TopFresh.po.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by lin on 2016-05-01-001.
 * 测试Hibernate
 * 操作类
 */
public class DBTestManager {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        ProductType type = new ProductType();
        type.setTypeName("type2");
        type.setTypeLevel(1);
        type.setTypeOrderInLevel(1);
        session.save(type);

        ProductType sub = new ProductType();
        sub.setTypeName("type2.1");
        sub.setTypeLevel(2);
        sub.setTypeOrderInLevel(1);
        type.addChild(sub);

        sub = new ProductType();
        sub.setTypeName("type2.2");
        sub.setTypeLevel(2);
        sub.setTypeOrderInLevel(2);
        type.addChild(sub);

        tx.commit();
        session.close();
        sf.close();
    }
}
