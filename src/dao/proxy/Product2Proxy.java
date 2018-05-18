package dao.proxy;

import dao.IProduct2;
import dao.impl.Product2Impl;
import factory.SqlServerFactory;



public class Product2Proxy implements IProduct2{
	private IProduct2 dao =null;
	public Product2Proxy() throws Exception{
		this.dao=new Product2Impl(SqlServerFactory.getDatabaseConnection().getConnection());
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
