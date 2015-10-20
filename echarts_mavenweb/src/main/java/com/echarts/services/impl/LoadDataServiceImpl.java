package com.echarts.services.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.echarts.models.PieDataModel;
import com.echarts.services.LoadDataService;

@Service("loaddataservice")
public class LoadDataServiceImpl implements LoadDataService {

	public PieDataModel[] loadData() {
		PieDataModel data1 = new PieDataModel();
		data1.setName("A");
		data1.setValue(335);
		PieDataModel data2 = new PieDataModel();
		data2.setName("B");
		data2.setValue(679);
		PieDataModel data3 = new PieDataModel();
		data3.setName("C");
		data3.setValue(1548);
		
		PieDataModel[] datas = new PieDataModel[] { data1, data2, data3 };		
		
		return datas;
	}

}
