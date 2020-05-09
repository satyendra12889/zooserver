package com.satyendra.iris.zoo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Service;

@Service
public class DaoHelper {

    void persist(EntityManagerFactory emf, Object object) {
        try {
//            Session s = sessionfactory.getCurrentSession();
//            Transaction t = sessionfactory.getTransaction();
//            beginTransaction();
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
//            t.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
