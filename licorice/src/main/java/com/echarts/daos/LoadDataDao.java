package com.echarts.daos;

import com.echarts.entities.PieData;
import com.echarts.models.PieDataModel;

public interface LoadDataDao {
	public PieDataModel[] load(); 
	
	public void save(PieData data);
}
