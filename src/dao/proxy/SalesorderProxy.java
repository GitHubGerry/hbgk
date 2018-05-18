package dao.proxy;

import java.util.List;
import dao.ISalesorder;
import dao.impl.SalesorderImpl;
import factory.SqlServerFactory;
import vo.salesorder;


public class SalesorderProxy implements ISalesorder{
	private ISalesorder dao =null;
	public SalesorderProxy() throws Exception{
		this.dao=new SalesorderImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	public boolean doCreate(salesorder emp) throws Exception{
		boolean flag=false;
		try{		
				flag=this.dao.doCreate(emp);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	public List<salesorder> findAll(String KW) throws Exception{
		List<salesorder> all=null;
		try{
			all=this.dao.findAll(KW);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
}
