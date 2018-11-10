package com.gywsystem3.service;

import java.util.Date;
import java.util.List;

import com.gywsystem3.po.Storehouse;

/**
 * 
 * 业务层接口
 *
 */
public interface StorehouseService {
	List<Storehouse> selectStorehouse(String createrid);
	boolean insertStorehouse(String housename,String createrid,String managerid,String on_off,Date createdate);
	boolean updateStorehouse(String housename,String createrid,String managerid,String on_off,String housename0);
	boolean deleteStorehouse(String housename,String createrid);
	
	
}
