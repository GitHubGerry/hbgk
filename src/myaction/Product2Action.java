package myaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import factory.Product2Factory;

public class Product2Action extends com.opensymphony.xwork2.ActionSupport{
	public String edit() throws ServletException, IOException {
		System.out.println(3);
		HttpServletRequest request = ServletActionContext.getRequest();  //¸ã¶¨request
		ActionContext acc = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) acc.get(ServletActionContext.HTTP_RESPONSE);//¸ã¶¨response
	
		HttpSession session = request.getSession();
		String createrid=(String) session.getAttribute("userid");
		String productid=request.getParameter("productid");	
		String ac=request.getParameter("perprice");
		String quantity=request.getParameter("quantity");
		
		String KW=createrid+'\t'+productid;
		String keyword=ac+'\t'+quantity;

		try {
			Product2Factory.getIProduct2Instance().updateByKW(KW,keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
