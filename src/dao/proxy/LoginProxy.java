package dao.proxy;
import dao.ILogin;
import dao.impl.LoginImpl;
import vo.users;
import factory.SqlServerFactory;

public class LoginProxy implements ILogin{
	private ILogin dao=null;
	public LoginProxy() throws Exception{
		this.dao=new LoginImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	public boolean findLogin(users users)throws Exception{
		boolean flag=false;
		try{
			flag=this.dao.findLogin(users);  //?
		}catch(Exception e){
			throw e;
		}finally{
			SqlServerFactory.getDatabaseConnection().close();
		}	
		return flag;
	}
	
}
