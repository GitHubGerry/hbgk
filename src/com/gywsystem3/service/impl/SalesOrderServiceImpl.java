package com.gywsystem3.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.mapper.SalesOrderMapper;
import com.gywsystem3.service.SalesOrderService;
import com.gywsystem3.po.SalesOrder;

@Service("salesOrderService")
public class SalesOrderServiceImpl implements SalesOrderService{
	@Autowired
	private SalesOrderMapper som;
	public List<SalesOrder> selectSalesOrder(String createrid){
		return som.selectBuyerOrder(createrid);
	}
	public String selectProductQuantity(String productid,String createrid){
		return som.selectProductQuantity(productid, createrid);
	}
	public boolean insertSalesOrder(String orderid,String productid,String buyerid,BigDecimal perprice,int quantity,Date orderdate,String createrid,BigDecimal amount){
		return som.insertPurchaseOrder(orderid, productid, buyerid, perprice, quantity, orderdate, createrid, amount);
	}
	public boolean SOupdateBuyer(String lpp,int quantity,String createrid,String buyerid){
		return som.SOupdateBuyer(lpp, quantity, createrid, buyerid);
	}
	public boolean SOupdateProducts(int quantity,String createrid,String productid){
		return som.SOupdateProducts(quantity, createrid, productid);
	}
}
