package com.licorice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.licorice.dao.AddressDao;
import com.licorice.entity.Address;
import com.licorice.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao dao;

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Address address) {
		dao.save(address);

	}

}
