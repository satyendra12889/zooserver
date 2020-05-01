package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IZooDao;
import com.satyendra.iris.zoo.model.Zoo;
@Repository
public class ZooDao implements IZooDao {

	@Autowired
    private SessionFactory sessionfactory;
	
	
	@Override
	public int addZoo(Zoo zoo) {
		
		Session s = sessionfactory.getCurrentSession();
		s.save(zoo);
		return zoo.id;
	}

	@Override
	public Zoo getZoo(int id) {
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Zoo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Zoo) criteria.list().get(0);
	}

	@Override
	public List<Zoo> list() {
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Zoo.class);
		return criteria.list();
	}
	

}
