package com.echarts.daos.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.echarts.daos.AddressDao;
import com.echarts.entities.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.save(address);
	}

}
