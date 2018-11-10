package com.gywsystem3.controller;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.gywsystem3.service.ProductService;
import com.gywsystem3.po.Product;

@Controller
public class ProductController {
	@Autowired
	@Qualifier("productService")
	private ProductService ps;
	@RequestMapping(value="/selectProduct")
	@ResponseBody
	public List<Product> selectProduct(HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		List<Product> product=ps.selectProduct(createrid);
		return product;
	}
	
	@RequestMapping(value="/JQselect")
	@ResponseBody
	public List<Product> JQselect(HttpServletRequest request){
		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		String key=request.getParameter("key");
		String value=request.getParameter("value");
		List<Product> product=ps.JQselect(createrid, key, value);
		return product;
	}
	
	@RequestMapping(value="/MHselect")
	@ResponseBody
	public List<Product> MHselect(HttpServletRequest request){
		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		String key=request.getParameter("key");
		String value=request.getParameter("value");
		List<Product> product=ps.MHselect(createrid, key, value);
		return product;
	}
	
	@RequestMapping(value="/insertProduct")
	@ResponseBody
	public void insertProduct(HttpServletRequest request){
		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		
		String productid=request.getParameter("productid");
		String productname=request.getParameter("productname");
		BigDecimal apc=new BigDecimal(request.getParameter("apc"));     //×Ö·û×ªdecimal
		String housename=request.getParameter("housename");
		String brand=request.getParameter("brand");
		//System.out.println("brandÊÇ£º"+brand);
		String category=request.getParameter("category");
		String feature1=request.getParameter("feature1");
		String feature2=request.getParameter("feature2");
		int quantity=0;
		ps.insertProduct(productid, productname, apc, housename, brand, category, feature1, feature2, quantity, createrid);
			
	}
	
	@RequestMapping(value="/updateProduct")
	@ResponseBody
	public void updateProduct(HttpServletRequest request){
		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		
		String productid=request.getParameter("productid");
		String productname=request.getParameter("productname");
		BigDecimal apc=new BigDecimal(request.getParameter("apc"));     //×Ö·û×ªdecimal
		String housename=request.getParameter("housename");
		String brand=request.getParameter("brand");
		String category=request.getParameter("category");
		String feature1=request.getParameter("feature1");
		String feature2=request.getParameter("feature2");
		
		ps.updateProduct(productname, apc, housename, brand, category, feature1, feature2, createrid, productid);
		
		
		
	}
	
	@RequestMapping(value="/deleteProduct")
	@ResponseBody
	public void deleteProduct(HttpServletRequest request){
		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		String productid=request.getParameter("productid");
		ps.deleteProduct(createrid, productid);
	}
	
	
}
