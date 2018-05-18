package myaction;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import vo.buyer;
import factory.BuyerFactory;

public class BuyerAction extends com.opensymphony.xwork2.ActionSupport{
	public void get() throws ServletException, IOException {
		System.out.println(1);
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
	
		HttpSession session=request.getSession();
		String userid=(String) session.getAttribute("userid");
		List<buyer> all=null;
		try {
			all = BuyerFactory.getIbuyerInstance().findAll(userid);				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator<buyer> iter=all.iterator();
		String data="[";			
		while(iter.hasNext()){
			buyer emp=iter.next();
			data+="{\"buyerid\":\""+emp.getBuyerid()+"\",\"companyname\":\""+emp.getCompanyname()+"\",\"linkman1\":\""+emp.getLinkman1()+"\",\"tele1\":\""+emp.getTele1()+"\",\"linkman2\":\""+emp.getLinkman2();
			data+="\",\"tele2\":\""+emp.getTele2()+"\",\"wechat\":\""+emp.getWechat()+"\",\"volume\":\""+emp.getVolume()+"\",\"app\":\""+emp.getApp()+"\",\"lpp\":\""+emp.getLpp();
			data+="\"},";
		}
		if(data!="["){data=data.substring(0,data.length()-1);}
		data+="]";
		response.setContentType("text/html;charset=UTF-8");   //解决中文是？ ------重要------
		response.getWriter().write(data);

	}

	
	public String post() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
	
        
		request.setCharacterEncoding("utf-8");         //表单解决中文乱码就这一句
		System.out.println(2);
		buyer emp=new buyer();
		emp.setBuyerid(request.getParameter("buyerid"));
		HttpSession session=request.getSession();
		emp.setCreaterid((String) session.getAttribute("userid"));
		emp.setCompanyname(request.getParameter("companyname"));
		emp.setLinkman1(request.getParameter("linkman1"));
		emp.setTele1(request.getParameter("tele1"));
		emp.setLinkman2(request.getParameter("linkman2"));
		emp.setTele2(request.getParameter("tele2"));
		emp.setWechat(request.getParameter("wechat"));
		emp.setVolume(0);
		emp.setApp("0%");
		try {
			BuyerFactory.getIbuyerInstance().doCreate(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String edit() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
	
		HttpSession session = request.getSession();
		System.out.println(3);
		String createrid=(String) session.getAttribute("userid");
					
		String buyerid=request.getParameter("buyerid");		
		String companyname=request.getParameter("companyname");
		companyname=URLDecoder.decode(companyname,"utf8");
		String linkman1=request.getParameter("linkman1");
		linkman1=URLDecoder.decode(linkman1,"utf8");
		String tele1=request.getParameter("tele1");
		tele1=URLDecoder.decode(tele1,"utf8");
		String linkman2=request.getParameter("linkman2");
		linkman2=URLDecoder.decode(linkman2,"utf8");
		String tele2=request.getParameter("tele2");
		tele2=URLDecoder.decode(tele2,"utf8");
		String wechat=request.getParameter("wechat");
		wechat=URLDecoder.decode(wechat,"utf8");

		
		String KW=createrid+'\t'+buyerid;
		String keyword=buyerid+'\t'+companyname+'\t'+linkman1+'\t'+tele1+'\t'+linkman2+'\t'+tele2+'\t'+wechat;
		try {
			boolean flag=BuyerFactory.getIbuyerInstance().updateByKW(KW,keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
		
	
	}
	public String delete() throws ServletException, IOException {
		System.out.println(4);
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
	
		HttpSession session=request.getSession();
		String createrid=(String) session.getAttribute("userid");
		String buyerid=request.getParameter("buyerid");
		String KW=createrid+'\t'+buyerid;

		try {
			boolean flag=BuyerFactory.getIbuyerInstance().deleteByKW(KW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
