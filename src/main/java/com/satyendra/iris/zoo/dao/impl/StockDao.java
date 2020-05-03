package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IStockDao;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;
@Repository
public class StockDao implements IStockDao {

	@Autowired
	DaoHelper daoHelper; 
	
	@Autowired
    private SessionFactory sessionfactory;

	
	@Override
	public int add(Stock s) {
		daoHelper.persist(sessionfactory, s);
		return s.getId();
	}

	@Override
	public List<Stock> list() {
		Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Stock.class);
		return criteria.list();
	}

	@Override
	public Stock get(int stockId) {
		Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Stock.class);
        criteria.add(Restrictions.eq("id", stockId));
        return (Stock) criteria.list().get(0);
	}

	@Override
	public void update(Stock s) {
		
		Session session = sessionfactory.getCurrentSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.update(s);
		t.commit();
		
		
	}

}
