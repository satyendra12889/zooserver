package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IPegDao;
import com.satyendra.iris.zoo.model.Peg;
import com.satyendra.iris.zoo.model.Zoo;

@Repository
public class PegDao  implements IPegDao {
	
	@Autowired
    private SessionFactory sessionfactory;

	@Override
	public int addPeg(String name) {
		return 0;
	}

	@Override
	public Peg getPeg(int id) {
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Peg.class);
		criteria.add(Restrictions.eq("id", id));
		return  (Peg) criteria.list().get(0);        
	}

	@Override
	public List<Peg> list(int zooId) {
		
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Peg.class);
		criteria.add(Restrictions.eq("zoo.id", zooId));
		return  criteria.list();        
	}

	@Override
	public int addPeg(Peg p) {
		Session s = sessionfactory.getCurrentSession();
		s.save(p);
		return p.id;
	}
	
	

}
