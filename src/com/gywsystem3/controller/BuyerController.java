package com.gywsystem3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gywsystem3.po.Buyer;
import com.gywsystem3.service.BuyerService;

@Controller
public class BuyerController {
	@Autowired
	private BuyerService bs;
	
	@RequestMapping(value="/selectBuyer")
	@ResponseBody
	public List<Buyer> selectBuyer(HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		return bs.selectBuyer(createrid);
	}
	
	@RequestMapping(value="/insertBuyer")
	@ResponseBody
	public void insertBuyer(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String buyerid=request.getParameter("buyerid");
		String companyname=request.getParameter("companyname");
		String linkman1=request.getParameter("linkman1");
		String tele1=request.getParameter("tele1");
		String linkman2=request.getParameter("linkman2");
		String tele2=request.getParameter("tele2");
		String wechat=request.getParameter("wechat");
		bs.insertBuyer(buyerid, companyname, linkman1, tele1, linkman2, tele2, wechat, 0, "0%",createrid,"0%");
	}
	@RequestMapping(value="/updateBuyer")
	@ResponseBody
	public void updateBuyer(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String buyerid=request.getParameter("buyerid");
		String companyname=request.getParameter("companyname");
		String linkman1=request.getParameter("linkman1");
		String tele1=request.getParameter("tele1");
		String linkman2=request.getParameter("linkman2");
		String tele2=request.getParameter("tele2");
		String wechat=request.getParameter("wechat");
		
		bs.updateBuyer(companyname, linkman1, tele1, linkman2, tele2, wechat,createrid,buyerid);
	
	}
	
	@RequestMapping(value="/deleteBuyer")
	@ResponseBody
	public boolean deleteBuyer(HttpServletRequest request,HttpSession session){
		String createrid=(String)session.getAttribute("userid");
		String buyerid=request.getParameter("buyerid");
		return bs.deleteBuyer(createrid, buyerid);
	}
}
