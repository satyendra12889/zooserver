package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IAreaDao;
import com.satyendra.iris.zoo.model.Area;

@Repository
public class AreaDao implements IAreaDao {

    @Autowired
    private SessionFactory sessionfactory;
    
    @Autowired
    private DaoHelper daoHelper;


    @Override
	public int addArea(Area Area) {
        daoHelper.persist(sessionfactory, Area);
        return Area.id; 
	}

    @Override
    public Area getArea(int id) {
        Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Area.class);
        criteria.add(Restrictions.eq("id", id));
        return (Area) criteria.list().get(0);
    }

    @Override
    public List<Area> list() {
        Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Area.class);
        return criteria.list();
    }

}
