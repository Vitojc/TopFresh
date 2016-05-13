package com.youthlin.TopFresh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

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

        DBTest test;
        test = new DBTest();
        test.setName("name");
        Set<String> set = new HashSet<>();
        set.add("item1");
        set.add("item2");
        test.setSet(set);
        session.save(test);
//
//        test = session.get(DBTest.class, 2);
//        System.out.println(test);


//        ImageUpload iu = session.get(ImageUpload.class, 1);
//
//        ProductType t = session.get(ProductType.class, 1);

//        Product p = new Product();
//        p.setProductName("name6");
//        p.setProductDescribe("desc6");
//        p.setProductPrice(1.32);
//        p.setProductType(t);
//
//        p.getProductImage().add(iu);
//        p.getProductImage().add(session.get(ImageUpload.class,2));

//        session.save(p);
//        Product p = session.get(Product.class, 6);
//        System.out.println(p.getProductDescribe());
        tx.commit();
        session.close();
        sf.close();
    }
}
