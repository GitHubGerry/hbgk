package dao.proxy;

import java.util.List;
import dao.IPurchaseorder;
import dao.impl.PurchaseorderImpl;
import factory.SqlServerFactory;
import vo.purchaseorder;


public class PurchaseorderProxy implements IPurchaseorder{
	private IPurchaseorder dao =null;
	public PurchaseorderProxy() throws Exception{
		this.dao=new PurchaseorderImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	public boolean doCreate(purchaseorder emp) throws Exception{
		boolean flag=false;
		try{		
				flag=this.dao.doCreate(emp);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	public List<purchaseorder> findAll(String KW) throws Exception{
		List<purchaseorder> all=null;
		try{
			all=this.dao.findAll(KW);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
}
