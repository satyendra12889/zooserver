package com.satyendra.iris.zoo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class DaoHelper {

    void persist(SessionFactory sessionfactory, Object object) {
        try {
            Session s = sessionfactory.getCurrentSession();
            Transaction t = s.beginTransaction();
            s.save(object);
            t.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
