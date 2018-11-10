package com.gywsystem3.service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.gywsystem3.po.SalesOrder;

public interface SalesOrderService {
	List<SalesOrder> selectSalesOrder(String createrid);
	//售货四件事
	String selectProductQuantity(String productid,String createrid);
	boolean insertSalesOrder(String orderid,String productid,String buyerid,BigDecimal perprice,int quantity,Date orderdate,String createrid,BigDecimal amount);
	boolean SOupdateBuyer(String lpp,int quantity,String createrid,String buyerid);
	boolean SOupdateProducts(int quantity,String createrid,String productid);

}
