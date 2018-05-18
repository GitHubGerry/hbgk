package myaction;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import vo.storehouse;
import factory.StorehouseFactory;

public class StorehouseAction extends com.opensymphony.xwork2.ActionSupport{

	public void get() throws Exception {
		System.out.println(1);
		
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
		
		HttpSession session=request.getSession();
		String userid=(String) session.getAttribute("userid");
		List<storehouse> all=null;
		try {
			String aa="managerid='"+userid+"' or createrid";
			all = StorehouseFactory.getIStorehouseInstance().findAll(aa,userid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator<storehouse> iter=all.iterator();
		String data="[";			
		while(iter.hasNext()){
			storehouse emp=iter.next();
			data+="{\"housename\":\""+emp.getHousename()+"\",\"createrid\":\""+emp.getCreaterid().trim()+"\",\"managerid\":\""+emp.getManagerid().trim()+"\",\"on_off\":\""+emp.getOn_off()+"\",\"createdate\":\""+emp.getCreatedate();
			data+="\"},";
		}
		data=data.substring(0,data.length()-1);
		data+="]";
		
		response.setContentType("text/html;charset=UTF-8");   //解决中文是？ ------重要------
		response.getWriter().write(data);

		
	}
	
	public String post() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
        
		request.setCharacterEncoding("utf-8");
		System.out.println(2);
		storehouse emp=new storehouse();
		emp.setHousename(request.getParameter("housename"));
		HttpSession session=request.getSession();
		emp.setCreaterid((String) session.getAttribute("userid"));
		emp.setManagerid(request.getParameter("managerid"));
		emp.setOn_off(request.getParameter("onoff"));
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
		emp.setCreatedate(createdate2);
		
		try {
			
			StorehouseFactory.getIStorehouseInstance().doCreate(emp);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	public String edit() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
       
		HttpSession session = request.getSession();
		System.out.println(3);
		String createrid=(String) session.getAttribute("userid");
		
		
		String housename=request.getParameter("housename");
		housename=URLDecoder.decode(housename,"utf8"); //二次次编码解决url传递中文
		String hn0=request.getParameter("hn0");
		hn0=URLDecoder.decode(hn0,"utf8"); //二次次编码解决url传递中文
		
		String managerid=request.getParameter("managerid");
		String on_off=request.getParameter("onoff2");					
		String KW=createrid+'\t'+hn0;
		String keyword=housename+'\t'+managerid+'\t'+on_off;
		try {
			boolean flag=StorehouseFactory.getIStorehouseInstance().updateByKW(KW,keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	
	}
	
	
	public String delete() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);

		System.out.println(4);
		String createrid=request.getParameter("createrid");
		String housename=request.getParameter("housename");
		housename=URLDecoder.decode(housename,"utf8"); //二次次编码解决url传递中文
		String KW=createrid+'\t'+housename;
		try {
			boolean flag=StorehouseFactory.getIStorehouseInstance().deleteByKW(KW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
}
