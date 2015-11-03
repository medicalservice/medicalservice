package com.echarts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.echarts.daos.AddressDao;
import com.echarts.entities.Address;
import com.echarts.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao dao;

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Address address) {
		dao.save(address);

	}

}
