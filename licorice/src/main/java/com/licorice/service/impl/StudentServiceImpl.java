package com.licorice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.licorice.dao.AddressDao;
import com.licorice.dao.StudentDao;
import com.licorice.entity.Address;
import com.licorice.entity.Student;
import com.licorice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(Student student) {
		// TODO Auto-generated method stub
		Address address = student.getAddress();
		//addressDao.save(address);
		studentDao.save(student);
	}

}
