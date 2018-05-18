package myaction;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import vo.users;
import factory.LoginFactory;

public class LoginAction extends com.opensymphony.xwork2.ActionSupport{

    public String login() throws Exception {
        System.out.println("正在执行的LoginAction。。。");
        
        //https://www.cnblogs.com/jonsnow/p/6549817.html 三种传参数方式
        
        HttpServletRequest request = ServletActionContext.getRequest();  
        
        String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		users users=new users();
		users.setUserid(userid);
		users.setPassword(password);
		request.setAttribute("info1",userid);
		System.out.println(request.getAttribute("info1"));
		
		String flag="";
		
		try{
			if(LoginFactory.getILoginInstance().findLogin(users)){
				request.setAttribute("info2",users.getNickname());
				flag=SUCCESS;
			}else{
				flag=ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return flag;
        
    }
}
