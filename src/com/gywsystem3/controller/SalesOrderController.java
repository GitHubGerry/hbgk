package com.gywsystem3.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gywsystem3.service.SalesOrderService;
import com.gywsystem3.po.SalesOrder;;


@Controller
public class SalesOrderController {
	@Autowired
	@Qualifier("salesOrderService")
	private SalesOrderService sos;
	@RequestMapping(value="/selectSalesOrder")
	@ResponseBody
	public List<SalesOrder> selectSalesOrder(HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		return sos.selectSalesOrder(createrid);
	}
	@RequestMapping(value="/insertSalesOrder")
	@ResponseBody
	public void insertSalesOrder(HttpServletRequest request,HttpSession session){
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
		String buyerid=request.getParameter("buyerid");
		BigDecimal perprice=new BigDecimal(request.getParameter("perprice"));     //字符转decimal
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		BigDecimal amount=new BigDecimal(request.getParameter("amount"));     //字符转decimal
		sos.insertSalesOrder(orderid, productid, buyerid, perprice, quantity, createdate2, createrid, amount);
		
	}
	@RequestMapping(value="/selectProductQuantity")
	@ResponseBody
	public String selectProductQuantity(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String productid=request.getParameter("productid");
		return sos.selectProductQuantity(productid, createrid);

	}
	@RequestMapping(value="/SOupdateBuyer")
	@ResponseBody
	public void SOupdateBuyer(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String lpp=request.getParameter("lpp");
		int quantity=Integer.valueOf(request.getParameter("quantity"));
		String buyerid=request.getParameter("buyerid");
		System.out.println(lpp+"----"+quantity+"-----"+buyerid+createrid);
		sos.SOupdateBuyer(lpp, quantity, createrid, buyerid);
	}
	@RequestMapping(value="/SOupdateProducts")
	@ResponseBody
	public void SOupdateProducts(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String productid=request.getParameter("productid");
		int quantity=Integer.valueOf(request.getParameter("quantity"));
		sos.SOupdateProducts(quantity, createrid, productid);
	}
	
	
	
}
