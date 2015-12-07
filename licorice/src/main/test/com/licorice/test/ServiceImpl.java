package com.licorice.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.licorice.entity.PieData;

public class ServiceImpl implements IService {
	private SessionFactory sessionFactory;
	
	public ServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void save() {
		// TODO Auto-generated method stub
		PieData data = new PieData();
		data.setName("A");
		data.setValue(335);
		Session session = sessionFactory.getCurrentSession();
		//session.save("piedata", data);	
	}

}
