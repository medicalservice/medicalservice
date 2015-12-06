package com.echarts.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.echarts.daos.LoadDataDao;
import com.echarts.entities.PieData;
import com.echarts.models.PieDataModel;
import com.echarts.services.LoadDataService;

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
