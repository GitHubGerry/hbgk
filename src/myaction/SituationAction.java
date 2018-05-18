package myaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import vo.situation;
import factory.SituationFactory;

public class SituationAction extends com.opensymphony.xwork2.ActionSupport{
	public void get() throws ServletException, IOException {
		System.out.println(1);
		HttpServletRequest request = ServletActionContext.getRequest();  //搞定request
		ActionContext ac = ActionContext.getContext();
        HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);//搞定response

		HttpSession session=request.getSession();
		String createrid=(String)session.getAttribute("userid");
		List<situation> all=null;
		try{
			all=SituationFactory.getSituationInstance().findAll(createrid);
		}catch(Exception e){
			e.printStackTrace();
		}
		Iterator<situation> iter=all.iterator();
		String data="[";
		while(iter.hasNext()){
			situation emp=iter.next();
			data+="{\"productid\":\""+emp.getProductid()+"\",\"productname\":\""+emp.getProductname()+"\",\"housename\":\""+emp.getHousename();
			data+="\",\"averagepercost\":\""+emp.getAveragepercost()+"\",\"quantity\":\""+emp.getQuantity();
			data+="\"},";
		}
		data=data.substring(0, data.length()-1);
		data+="]";
		response.setContentType("text/html;charset=UTF-8");   //解决中文是？ ------重要------
		response.getWriter().write(data);

		
	}
}
