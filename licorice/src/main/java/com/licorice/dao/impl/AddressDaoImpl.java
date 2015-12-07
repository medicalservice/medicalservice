package com.licorice.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.licorice.dao.AddressDao;
import com.licorice.entity.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.save(address);
	}

}
