package com.echarts.daos.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.echarts.daos.LoadDataDao;
import com.echarts.entities.PieData;
import com.echarts.models.PieDataModel;

@Repository
public class LoadDataDaoImpl implements LoadDataDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public LoadDataDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
	public PieDataModel[] loadData() {
		// TODO Auto-generated method stub
		PieData data1 = new PieData();
		data1.setName("A");
		data1.setValue(335);
		PieData data2 = new PieData();
		data2.setName("B");
		data2.setValue(679);
		PieData data3 = new PieData();
		data3.setName("C");
		data3.setValue(1548);
		
		PieData[] datas = new PieData[] { data1, data2, data3 };		
		
		//Session session = sessionFactory.openSession();
	
		 String hsql="from piedata";	    
	    // Query query = session.createQuery(hsql);
	        
	    // List s = query.list();
		return null;
	}

	public PieDataModel[] load() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PieData data) {
		Session session = sessionFactory.getCurrentSession();
		session.save("piedata", data);		
	}

}
