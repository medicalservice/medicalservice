package com.licorice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.licorice.dao.LoadDataDao;
import com.licorice.entity.PieData;
import com.licorice.model.PieDataModel;
import com.licorice.service.LoadDataService;

@Service("loaddataservice")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class LoadDataServiceImpl implements LoadDataService {
	@Autowired
	private LoadDataDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public PieDataModel[] load() {
		return dao.load();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(PieData data) {
		dao.save(data);		
	}

}
