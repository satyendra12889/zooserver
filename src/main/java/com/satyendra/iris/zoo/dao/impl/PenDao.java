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

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addPen(String name) {
        return 0;
    }

    @Override
    public Pen getPen(int id) {
        //        Session s = sessionfactory.getCurrentSession();
        //        Criteria criteria = s.createCriteria(Pen.class);
        //        criteria.add(Restrictions.eq("id", id));
        //        return (Pen) criteria.list().get(0);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pen> query = em.createQuery("SELECT p from Pen p where p.id = :id", Pen.class);
        query.setParameter("id", id);
        List<Pen> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public List<Pen> list(int zooId) {

        //        Session s = sessionfactory.getCurrentSession();
        //        Criteria criteria = s.createCriteria(Pen.class);
        //        criteria.add(Restrictions.eq("zoo.id", zooId));
        //        return criteria.list();
        return null;
    }

    @Override
    public int addPen(Pen pen) {
        daoHelper.persist(emf, pen);
        return pen.id;
    }

    @Override
    public List<Pen> getAllPens() {
        //        Session s = sessionfactory.getCurrentSession();
        //        Criteria cr = s.createCriteria(Pen.class);
        //        List results = cr.list();
        //        return results;
        return null;
    }

}
