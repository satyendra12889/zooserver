package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.model.Pen;

@Repository
public class PenDao implements IPenDao {

   

    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addPen(String name) {
        return 0;
    }

    @Override
    public Pen getPen(int id) {
        EntityManager em = daoHelper.getEMFInstance().createEntityManager();
        TypedQuery<Pen> query = em.createQuery("SELECT p from Pen p where p.id = :id", Pen.class);
        query.setParameter("id", id);
        List<Pen> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public List<Pen> list(int zooId) {

        return null;
    }

    @Override
    public int addPen(Pen pen) {
        daoHelper.persist(daoHelper.getEMFInstance(), pen);
        return pen.id;
    }

    @Override
    public List<Pen> getAllPens() {
    	EntityManager em = daoHelper.getEMFInstance().createEntityManager();
        TypedQuery<Pen> query = em.createQuery("SELECT p from Pen p", Pen.class);
        List<Pen> result = query.getResultList();
        return result;
    }

}
