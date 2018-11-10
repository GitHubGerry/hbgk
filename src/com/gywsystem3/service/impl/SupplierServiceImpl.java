package com.gywsystem3.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.mapper.SupplierMapper;
import com.gywsystem3.po.Supplier;
import com.gywsystem3.service.SupplierService;


@Service("supplierService")
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupplierMapper sm;
	
	public List<Supplier> selectSupplier(String createrid){
		return sm.selectSupplier(createrid);
	}
	public boolean insertSupplier(String supplierid,String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,int volume,String createrid){
		return sm.insertSupplier(supplierid, companyname, linkman1, tele1, linkman2, tele2, wechat, volume, createrid);
	}
	
	public boolean updateSupplier(String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,String createrid,String supplierid){
		return sm.updateSupplier(companyname, linkman1, tele1, linkman2, tele2, wechat,createrid,supplierid);
	}
	
	public boolean deleteSupplier(String createrid,String supplierid){
		return sm.deleteSupplier(createrid, supplierid);
	}
	
}
