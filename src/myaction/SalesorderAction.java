package myaction;

import java.io.IOException;
import java.math.BigDecimal;
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

import vo.salesorder;
import factory.BuyerFactory;
import factory.SalesorderFactory;

public class SalesorderAction extends com.opensymphony.xwork2.ActionSupport{
	public void get() throws ServletException, IOException {
		System.out.println(1);
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
	
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		List<salesorder> all=null;
		try {
			all = SalesorderFactory.getISalesorderInstance().findAll(userid);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		Iterator<salesorder> iter=all.iterator();
		String data="[";			
		while(iter.hasNext()){
			salesorder emp=iter.next();
			data+="{\"orderid\":\""+emp.getOrderid().split("@")[1].trim()+"\",\"productid\":\""+emp.getProductid().trim()+"\",\"buyerid\":\""+emp.getBuyerid()+"\",\"housename\":\""+emp.getOrderid().split("@")[0].trim()+"\",\"perprice\":\""+emp.getPerprice()+"\",\"quantity\":\""+emp.getQuantity();
			data+="\",\"orderdate\":\""+emp.getOrderdate()+"\",\"amount\":\""+emp.getAmount();
			data+="\"},";
		}
		data=data.substring(0,data.length()-1);
		data+="]";

		response.setContentType("text/html;charset=UTF-8");   //解决中文是？ ------重要------
		response.getWriter().write(data);
	}


	public String post() throws ServletException, IOException {
		System.out.println(2);
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
	
		request.setCharacterEncoding("utf-8");
		salesorder emp=new salesorder();
		emp.setOrderid(request.getParameter("orderid"));
		HttpSession session=request.getSession();
		String createrid=(String) session.getAttribute("userid");
		emp.setCreaterid(createrid);
		String productid=request.getParameter("productid");
		emp.setProductid(productid);
		String buyerid=request.getParameter("buyerid");
		emp.setBuyerid(buyerid);
		String price=request.getParameter("perprice");
		BigDecimal bd=new BigDecimal(price);
		emp.setPerprice(bd);
		emp.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		BigDecimal bd2=new BigDecimal(request.getParameter("amount"));
		emp.setAmount(bd2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date orderdate = null;
		java.sql.Date orderdate2=null;
		try {
			orderdate = sdf.parse(sdf.format(new Date()));
			
			orderdate2 = new java.sql.Date(orderdate.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 
		emp.setOrderdate(orderdate2);
		String KW=createrid+"\t"+buyerid;
		String KW2=createrid+"\t"+productid+"\t"+buyerid+"\t"+price;
		try {
			BuyerFactory.getIbuyerInstance().volumeAdd(KW);//代理类不关数据库 //3个操作 +交易次数 ；算利润率；创建售货单
			BuyerFactory.getIbuyerInstance().countapp(KW2);
			SalesorderFactory.getISalesorderInstance().doCreate(emp);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;

	}
}
