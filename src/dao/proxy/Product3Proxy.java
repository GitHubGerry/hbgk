package dao.proxy;

import dao.IProduct3;
import dao.impl.Product3Impl;
import factory.SqlServerFactory;



public class Product3Proxy implements IProduct3{
	private IProduct3 dao =null;
	public Product3Proxy() throws Exception{
		this.dao=new Product3Impl(SqlServerFactory.getDatabaseConnection().getConnection());
	}

	public boolean updateByKW(String KW, String keyWord) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.updateByKW(KW, keyWord);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
	
	
	
	
}
