package com.satyendra.iris.zoo.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class DaoHelper {

    void persist(EntityManager em, Object object) {
        try {
//            Session s = sessionfactory.getCurrentSession();
//            Transaction t = sessionfactory.getTransaction();
//            beginTransaction();
        	em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
//            t.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
