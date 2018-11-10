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
	@Qualifier("userService")//不写qualifier 有两个继承userService接口的就会报错，这里应该不写没事。
	private UserService userService;

	{
		
		System.out.println("这里是gywsystem3的 UserController");
	}
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		User user=userService.login(userid,password);
		if(user!=null){
			//登录成功
			session.setAttribute("userid", user.getUserid().trim());
			mv.setViewName("home.jsp");
		}else{
			mv.addObject("message","登录名或密码错误，请重新输入！");
			mv.setViewName("login.jsp");
		}
	return mv;
	}
	
	
}
