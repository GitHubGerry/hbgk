package com.gywsystem3.service.impl;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.service.PurchaseOrderService;
import com.gywsystem3.mapper.PurchaseOrderMapper;
import com.gywsystem3.po.PurchaseOrder;

@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
	@Autowired
	private PurchaseOrderMapper pom;
	public List<PurchaseOrder> selectPurchaseOrder(String createrid){

		return pom.selectPurchaseOrder(createrid);
	}
	
	public boolean insertPurchaseOrder(String orderid,String productid,String supplierid,BigDecimal perprice,int quantity,Date orderdate,String createrid,BigDecimal amount){
		return pom.insertPurchaseOrder(orderid, productid, supplierid, perprice, quantity, orderdate, createrid, amount);
		
	}
	
	public boolean addVolume(String createrid,String supplierid){
		return pom.addVolume(createrid, supplierid);
	}
	
	public boolean updateCQ(String createrid,String productid,String housename,BigDecimal percost,int quantity){
		return pom.updateCQ(createrid, productid,housename, percost, quantity);
	}

}
