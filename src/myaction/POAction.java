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

import vo.purchaseorder;
import factory.PurchaseorderFactory;
import factory.SupplierFactory;

public class POAction extends com.opensymphony.xwork2.ActionSupport{
	public void get() throws ServletException, IOException {
		System.out.println(1);
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response
		
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		List<purchaseorder> all=null;
		try {
			all = PurchaseorderFactory.getIPurchaseorderInstance().findAll(userid);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		Iterator<purchaseorder> iter=all.iterator();
		String data="[";			
		while(iter.hasNext()){
			purchaseorder emp=iter.next();
			data+="{\"orderid\":\""+emp.getOrderid().split("@")[1].trim()+"\",\"productid\":\""+emp.getProductid().trim()+"\",\"supplierid\":\""+emp.getSupplierid()+"\",\"housename\":\""+emp.getOrderid().split("@")[0].trim()+"\",\"perprice\":\""+emp.getPerprice()+"\",\"quantity\":\""+emp.getQuantity();
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
		purchaseorder emp=new purchaseorder();
		emp.setOrderid(request.getParameter("orderid"));
		HttpSession session=request.getSession();
		String createrid=(String) session.getAttribute("userid");
		emp.setCreaterid(createrid);
		emp.setProductid(request.getParameter("productid"));
		String supplierid=request.getParameter("supplierid");
		emp.setSupplierid(supplierid);
		BigDecimal bd=new BigDecimal(request.getParameter("perprice"));
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
		String KW=createrid+"\t"+supplierid;
		try {
			SupplierFactory.getIsupplierInstance().volumeAdd(KW);//代理类不关数据库-----两个操作1.供货商交易次数+1；2.生成订单。
			PurchaseorderFactory.getIPurchaseorderInstance().doCreate(emp);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;

	}


}
