package com.gywsystem3.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.List;
import com.gywsystem3.po.Supplier;
import com.gywsystem3.service.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService ss;
	
	@RequestMapping(value="/selectSupplier")
	@ResponseBody
	public List<Supplier> selectSupplier(HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		return ss.selectSupplier(createrid);
	}
	
	@RequestMapping(value="/insertSupplier")
	@ResponseBody
	public boolean insertSupplier(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String supplierid=request.getParameter("supplierid");
		String companyname=request.getParameter("companyname");
		String linkman1=request.getParameter("linkman1");
		String tele1=request.getParameter("tele1");
		String linkman2=request.getParameter("linkman2");
		String tele2=request.getParameter("tele2");
		String wechat=request.getParameter("wechat");
		//int volume=Integer.valueOf(request.getParameter("volume"));
		
		return ss.insertSupplier(supplierid, companyname, linkman1, tele1, linkman2, tele2, wechat,0, createrid);
		
	}
	
	@RequestMapping(value="/updateSupplier")
	@ResponseBody
	public boolean updateSupplier(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String supplierid=request.getParameter("supplierid");
		String companyname=request.getParameter("companyname");
		String linkman1=request.getParameter("linkman1");
		String tele1=request.getParameter("tele1");
		String linkman2=request.getParameter("linkman2");
		String tele2=request.getParameter("tele2");
		String wechat=request.getParameter("wechat");
		System.out.println(createrid+"---"+supplierid+"---"+companyname+"---"+linkman1+"---"+tele1+"---"+linkman2+"---"+tele2+"---"+wechat);
		return ss.updateSupplier(companyname, linkman1, tele1, linkman2, tele2, wechat,createrid,supplierid);
		
	}
	
	@RequestMapping(value="/deleteSupplier")
	@ResponseBody
	public boolean deleteSupplier(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String supplierid=request.getParameter("supplierid");
		return ss.deleteSupplier(createrid, supplierid);
	}
	
	
}
