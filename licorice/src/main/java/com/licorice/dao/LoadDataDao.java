package com.licorice.dao;

import com.licorice.entity.PieData;
import com.licorice.model.PieDataModel;

public interface LoadDataDao {
	public PieDataModel[] load(); 
	
	public void save(PieData data);
}
