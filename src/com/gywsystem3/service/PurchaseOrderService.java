package com.gywsystem3.service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.gywsystem3.po.PurchaseOrder;

public interface PurchaseOrderService {
	
	List<PurchaseOrder> selectPurchaseOrder(String createrid);
	boolean insertPurchaseOrder(String orderid,String productid,String supplierid,BigDecimal perprice,int quantity,Date orderdate,String createrid,BigDecimal amount);
	boolean addVolume(String createrid,String supplierid);
	boolean updateCQ(String createrid,String productid,String housename,BigDecimal percost,int quantity);
}
