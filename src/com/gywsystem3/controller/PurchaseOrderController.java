package com.gywsystem3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.gywsystem3.po.PurchaseOrder;
import com.gywsystem3.service.PurchaseOrderService;


@Controller
public class PurchaseOrderController {
	@Autowired
	@Qualifier("purchaseOrderService")
	private PurchaseOrderService pos;
	
	@RequestMapping(value="/selectPurchaseOrder")
	@ResponseBody
	public List<PurchaseOrder> selectPurchaseOrder(HttpSession session){
		return pos.selectPurchaseOrder((String)session.getAttribute("userid"));
	}
	
	@RequestMapping(value="/insertPurchaseOrder")
	@ResponseBody
	public void insertPurchaseOrder(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date createdate = null;
		java.sql.Date createdate2=null;
		try {
			createdate = sdf.parse(sdf.format(new Date()));
			
			createdate2 = new java.sql.Date(createdate.getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String orderid=request.getParameter("orderid");
		String productid=request.getParameter("productid");
		String supplierid=request.getParameter("supplierid");
		BigDecimal perprice=new BigDecimal(request.getParameter("perprice"));     //字符转decimal
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		BigDecimal amount=new BigDecimal(request.getParameter("amount"));     //字符转decimal
		pos.insertPurchaseOrder(orderid, productid, supplierid, perprice, quantity, createdate2, createrid, amount);
		
	}
	@RequestMapping(value="addVolume")
	@ResponseBody
	public void addVolume(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String supplierid=request.getParameter("supplierid");
		pos.addVolume(createrid, supplierid);
	}
	
	@RequestMapping(value="updateCQ")
	@ResponseBody
	public void updateCQ(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String productid=request.getParameter("productid");
		String housename=request.getParameter("housename");
		BigDecimal percost=new BigDecimal(request.getParameter("percost"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		pos.updateCQ(createrid, productid,housename, percost,quantity);
	}
	
	
}
