package com.licorice.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.licorice.dao.StudentDao;
import com.licorice.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);		

	}

}
