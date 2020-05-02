package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

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

    @Autowired
    private SessionFactory sessionfactory;

    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addPen(String name) {
        return 0;
    }

    @Override
    public Pen getPen(int id) {
        Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Pen.class);
        criteria.add(Restrictions.eq("id", id));
        return (Pen) criteria.list().get(0);
    }

    @Override
    public List<Pen> list(int zooId) {

        Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Pen.class);
        criteria.add(Restrictions.eq("zoo.id", zooId));
        return criteria.list();
    }

    @Override
    public int addPen(Pen pen) {
        daoHelper.persist(sessionfactory, pen);
        return pen.id;
    }

    @Override
    public List<Pen> getAllPens() {
        Session s = sessionfactory.getCurrentSession();
        Criteria cr = s.createCriteria(Pen.class);
        List results = cr.list();
        return results;
    }

}
