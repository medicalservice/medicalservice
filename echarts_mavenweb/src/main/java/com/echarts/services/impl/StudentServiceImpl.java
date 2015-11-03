package com.echarts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.echarts.daos.AddressDao;
import com.echarts.daos.StudentDao;
import com.echarts.entities.Address;
import com.echarts.entities.Student;
import com.echarts.services.StudentService;

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
