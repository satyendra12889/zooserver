package com.satyendra.iris.zoo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;

@Service
public class DaoHelper {
	
	@PersistenceUnit
    private  EntityManagerFactory emf;
	
	
	 EntityManagerFactory getEMFInstance() {
		return emf;
		
	}
	
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
