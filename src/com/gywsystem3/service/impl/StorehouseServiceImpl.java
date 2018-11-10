package com.gywsystem3.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.po.Storehouse;
import com.gywsystem3.mapper.StorehouseMapper;
import com.gywsystem3.service.StorehouseService;

@Service("storehouseService")
public class StorehouseServiceImpl implements StorehouseService{
	@Autowired
	private StorehouseMapper sm;
	public List<Storehouse> selectStorehouse(String createrid){
		return sm.selectStorehouse(createrid);
	}
	public boolean insertStorehouse(String housename,String createrid,String managerid,String on_off,Date createdate){
		//System.out.println(createrid+"    "+on_off+"      "+housename+"   date"+createdate);
		return sm.insertStorehouse(housename,createrid, managerid, on_off,createdate);
	}
	public boolean updateStorehouse(String housename,String createrid,String managerid,String on_off,String housename0){
		//System.out.println(housename+createrid+managerid+on_off+housename0);
		return sm.updateStorehouse(housename,createrid,managerid,on_off,housename0);
	}
	public boolean deleteStorehouse(String createrid,String housename){
		System.out.println(housename+createrid);
		return sm.deleteStorehouse(createrid, housename);
	}

	
}
