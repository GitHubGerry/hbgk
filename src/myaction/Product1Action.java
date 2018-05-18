package myaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import vo.product1;
import factory.Product1Factory;

public class Product1Action extends com.opensymphony.xwork2.ActionSupport{
	
	public void get() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
  
		
		System.out.println(1);
		HttpSession session=request.getSession();			
		String key=request.getParameter("key");			
		String value1=request.getParameter("value1");//模糊查找、精确查找用到。
		String value2=request.getParameter("value2");
		String userid=(String) session.getAttribute("userid");
		String createrid=null;
		if(key==null){	
			createrid=userid;
			}else if(value2==null){
				value1=URLDecoder.decode(value1,"utf8");
				createrid=userid+"' and "+key+" like '%"+value1+"%";
			}else{
				value2=URLDecoder.decode(value2,"utf8");
				createrid=userid+"' and "+key+"='"+value2;
			}
			

		List<product1> all=null;

		try {
			all = Product1Factory.getIProduct1Instance().findAll(createrid);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		Iterator<product1> iter=all.iterator();
		String data="[";			
		while(iter.hasNext()){
			product1 emp=iter.next();
			data+="{\"productid\":\""+emp.getProductid()+"\",\"productname\":\""+emp.getProductname()+"\",\"housename\":\""+emp.getHousename()+"\",\"averagepercost\":\""+emp.getAveragepercost()+"\",\"brand\":\""+emp.getBrand()+"\",\"category\":\""+emp.getCategory();
			data+="\",\"feature1\":\""+emp.getFeature1()+"\",\"feature2\":\""+emp.getFeature2();
			data+="\"},";
		}
		if(data!="["){data=data.substring(0,data.length()-1);}
		data+="]";

		response.setContentType("text/html;charset=UTF-8");   //解决中文是？ ------重要------
		response.getWriter().write(data);

	}
	
	public String post() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
  
		request.setCharacterEncoding("utf-8");         //表单解决中文乱码就这一句
		System.out.println(2);
		product1 emp=new product1();
		emp.setProductid(request.getParameter("productid"));
		HttpSession session=request.getSession();
		emp.setCreaterid((String) session.getAttribute("userid"));
		emp.setProductname(request.getParameter("productname"));
		emp.setHousename(request.getParameter("housename"));
		BigDecimal bd=new BigDecimal(request.getParameter("averagepercost"));     //字符转decimal
		emp.setAveragepercost(bd);
		emp.setBrand(request.getParameter("brand"));
		emp.setCategory(request.getParameter("category"));
		emp.setFeature1(request.getParameter("feature1"));
		emp.setFeature2(request.getParameter("feature2"));
		
		try {
			
			Product1Factory.getIProduct1Instance().doCreate(emp);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String edit() throws ServletException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext acc = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) acc.get(ServletActionContext.HTTP_RESPONSE);
  
		HttpSession session = request.getSession();
		System.out.println(3);
		String createrid=(String) session.getAttribute("userid");
		
		
		String productid=request.getParameter("productid");		
		String productname=request.getParameter("productname");
		productname=URLDecoder.decode(productname,"utf8");
		String housename=request.getParameter("housename");
		housename=URLDecoder.decode(housename,"utf8");
		String ac=request.getParameter("averagepercost");
		String brand=request.getParameter("brand");
		brand=URLDecoder.decode(brand,"utf8");
		String category=request.getParameter("category");
		category=URLDecoder.decode(category,"utf8");
		String feature1=request.getParameter("feature1");
		feature1=URLDecoder.decode(feature1,"utf8");
		String feature2=request.getParameter("feature2");
		feature2=URLDecoder.decode(feature2,"utf8");
		if(feature2==null||"".equals(feature2)){
			feature2=" ";
		}
		
		
		String KW=createrid+'\t'+productid;
		String keyword=productid+'\t'+productname+'\t'+housename+'\t'+ac+'\t'+brand+'\t'+category+'\t'+feature1+'\t'+feature2;
		try {
			boolean flag=Product1Factory.getIProduct1Instance().updateByKW(KW,keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	
	}
	
	public String delete() throws ServletException, IOException {
		System.out.println(4);
		HttpServletRequest request = ServletActionContext.getRequest(); 
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
  
		HttpSession session=request.getSession();
		String createrid=(String) session.getAttribute("userid");
		String productid=request.getParameter("productid");
		
		String KW=createrid+'\t'+productid;
		try {
			boolean flag=Product1Factory.getIProduct1Instance().deleteByKW(KW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
