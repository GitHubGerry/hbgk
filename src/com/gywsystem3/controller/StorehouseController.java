package com.gywsystem3.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.gywsystem3.po.Storehouse;
import com.gywsystem3.service.StorehouseService;

@Controller
public class StorehouseController {
	@Autowired
	@Qualifier("storehouseService")
	private StorehouseService sm;
	@RequestMapping(value="/selectStorehouse")
	@ResponseBody
	public List<Storehouse> selectStorehouse(HttpServletRequest request){

		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		List<Storehouse> storehouse=sm.selectStorehouse(createrid);
		/*注解的力量！
		String return1="[";
		for(Storehouse aa:storehouse){
			return1+="{housename:\""+aa.getHousename()+"\",managerid=\""+aa.getManagerid().trim()+"\",on_off=\""+aa.getOn_off();
			return1+="\",createdate=\""+aa.getCreatedate()+"\"},";
		}
		return1=return1.substring(0,return1.length()-1);
		return1+="]";
		System.out.println(return1);*/
		return storehouse;
	}
	
	@RequestMapping(value="/insertStorehouse")
	@ResponseBody
	public void insertStorehouse(HttpServletRequest request){

		HttpSession session=request.getSession();
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
		sm.insertStorehouse(request.getParameter("housename"),createrid,request.getParameter("managerid"),request.getParameter("onoff"),createdate2);

	}
	
	@RequestMapping(value="/updateStorehouse")
	@ResponseBody
	public void updateStorehouse(HttpServletRequest request){

		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		sm.updateStorehouse(request.getParameter("housename"),createrid,request.getParameter("managerid"),request.getParameter("onoff"),request.getParameter("housename0"));

	}
	
	@RequestMapping(value="/deleteStorehouse")
	@ResponseBody
	public void deleteStorehouse(HttpServletRequest request){

		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		System.out.println(request.getParameter("housename"));
		sm.deleteStorehouse(createrid,request.getParameter("housename"));

	}
}
