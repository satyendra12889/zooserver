package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Area;

@Repository
public class PenDao implements IPenDao {

	@PersistenceContext
    private EntityManager em;

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
    	return null;
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
//        daoHelper.persist(sessionfactory, pen);
//        return pen.id;
    	return 0;
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
