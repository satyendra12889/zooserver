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


@Repository
public class PenDao  implements IPenDao {
	
	@Autowired
    private SessionFactory sessionfactory;

	@Override
	public int addPen(String name) {
		return 0;
	}

	@Override
	public Pen getPen(int id) {
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Pen.class);
		criteria.add(Restrictions.eq("id", id));
		return  (Pen) criteria.list().get(0);        
	}

	@Override
	public List<Pen> list(int zooId) {
		
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Pen.class);
		criteria.add(Restrictions.eq("zoo.id", zooId));
		return  criteria.list();        
	}

	@Override
	public int addPen(Pen p) {
		Session s = sessionfactory.getCurrentSession();
		s.save(p);
		return p.id;
	}
	
	

}
