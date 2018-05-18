package myaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import factory.Product3Factory;

public class Product3Action extends com.opensymphony.xwork2.ActionSupport{
	public String edit() throws ServletException, IOException {
		System.out.println(3);
		HttpServletRequest request = ServletActionContext.getRequest();  //¸ã¶¨request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//¸ã¶¨response

		HttpSession session = request.getSession();
		String createrid=(String) session.getAttribute("userid");
		String productid=request.getParameter("productid");	
		String quantity=request.getParameter("quantity");
		
		String KW=createrid+'\t'+productid;
		String keyword=quantity;

		try {
			Product3Factory.getIProduct3Instance().updateByKW(KW,keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
