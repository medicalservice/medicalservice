package com.echarts.daos.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.echarts.daos.StudentDao;
import com.echarts.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);		

	}

}
