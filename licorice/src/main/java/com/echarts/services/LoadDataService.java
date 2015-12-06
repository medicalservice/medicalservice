package com.echarts.services;

import com.echarts.entities.PieData;
import com.echarts.models.PieDataModel;

public interface LoadDataService {
	public PieDataModel[] load();

	public void save(PieData data);
}
