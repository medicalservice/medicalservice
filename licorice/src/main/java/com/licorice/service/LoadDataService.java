package com.licorice.service;

import com.licorice.entity.PieData;
import com.licorice.model.PieDataModel;

public interface LoadDataService {
	public PieDataModel[] load();

	public void save(PieData data);
}
