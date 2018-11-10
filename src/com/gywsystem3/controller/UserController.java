package com.gywsystem3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gywsystem3.po.User;
import com.gywsystem3.service.UserService;


@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")//��дqualifier �������̳�userService�ӿڵľͻᱨ������Ӧ�ò�дû�¡�
	private UserService userService;

	{
		
		System.out.println("������gywsystem3�� UserController");
	}
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		User user=userService.login(userid,password);
		if(user!=null){
			//��¼�ɹ�
			session.setAttribute("userid", user.getUserid().trim());
			mv.setViewName("home.jsp");
		}else{
			mv.addObject("message","��¼��������������������룡");
			mv.setViewName("login.jsp");
		}
	return mv;
	}
	
	
}
