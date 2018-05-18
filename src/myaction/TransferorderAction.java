package myaction;

import java.io.IOException;
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

import vo.transferorder;
import factory.TransferorderFactory;

public class TransferorderAction extends com.opensymphony.xwork2.ActionSupport{
	public void get() throws ServletException, IOException {
		System.out.println(1);
		HttpServletRequest request = ServletActionContext.getRequest();  //�㶨request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//�㶨response
	
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		List<transferorder> all=null;
		try {
			all = TransferorderFactory.getITransferorderInstance().findAll(userid);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		Iterator<transferorder> iter=all.iterator();
		String data="[";			
		while(iter.hasNext()){
			transferorder emp=iter.next();
			data+="{\"orderid\":\""+emp.getOrderid()+"\",\"productid\":\""+emp.getProductid()+"\",\"fromsh\":\""+emp.getFromsh()+"\",\"tosh\":\""+emp.getTosh()+"\",\"managerid\":\""+emp.getManagerid()+"\",\"quantity\":\""+emp.getQuantity();
			data+="\",\"orderdate\":\""+emp.getOrderdate();
			data+="\"},";
		}
		data=data.substring(0,data.length()-1);
		data+="]";

		response.setContentType("text/html;charset=UTF-8");   //��������ǣ� ------��Ҫ------
		response.getWriter().write(data);
	}


	public String post() throws ServletException, IOException {
		System.out.println(2);
		HttpServletRequest request = ServletActionContext.getRequest();  //�㶨request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//�㶨response
	
		request.setCharacterEncoding("utf-8");
		transferorder emp=new transferorder();
		emp.setOrderid(request.getParameter("orderid"));
		HttpSession session=request.getSession();
		String createrid=(String) session.getAttribute("userid");
		emp.setManagerid(createrid);
		emp.setCreaterid(createrid);
		String productid=request.getParameter("productid");
		emp.setProductid(productid);
		String fromsh=request.getParameter("fromsh");
		emp.setFromsh(fromsh);
		String tosh=request.getParameter("tosh");
		emp.setTosh(tosh);
		emp.setQuantity(Integer.valueOf(request.getParameter("quantity")));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		Date orderdate = null;
		java.sql.Date orderdate2=null;
		try {
			orderdate = sdf.parse(sdf.format(new Date()));
			
			orderdate2 = new java.sql.Date(orderdate.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		} 
		emp.setOrderdate(orderdate2);
		try {
			//�����಻�����ݿ�?���룡  �����һ�����������ݿ���С� //1������  �����ۻ��� ���ཻ��product2��3servlet��
			
			TransferorderFactory.getITransferorderInstance().doCreate(emp);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;

	}
}
