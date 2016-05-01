package com.youthlin.TopFresh.test;

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

//        DBTest test = new DBTest();
//        test.setKkey("key");
//        test.setVvalue("value");
//
//        session.save(test);
        DBTest test = session.get(DBTest.class, 1);
        System.out.println(test);
        tx.commit();
        session.close();
        sf.close();
    }
}
