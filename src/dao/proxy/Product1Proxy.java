package dao.proxy;
import java.util.List;
import dao.IProduct1;
import dao.impl.Product1Impl;
import factory.SqlServerFactory;
import vo.product1;

public class Product1Proxy implements IProduct1{
	private IProduct1 dao =null;
	public Product1Proxy() throws Exception{
		this.dao=new Product1Impl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	
	public boolean doCreate(product1 emp) throws Exception{
		boolean flag=false;
		try{
			
				flag=this.dao.doCreate(emp);
			
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
	public List<product1> findAll(String createrid) throws Exception{
		List<product1> all=null;
		try{
			all=this.dao.findAll(createrid);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
	
	public boolean findByKW(String KW) throws Exception{
		boolean flag=false;
		try{
			flag=this.dao.findByKW(KW);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
		
	}
	
	public boolean updateByKW(String KW,String keyWord) throws Exception{
		boolean flag=false;
		try{
			flag=this.dao.updateByKW(KW, keyWord);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
	public boolean deleteByKW(String KW) throws Exception{
		boolean flag=false;
		try{
			flag=this.dao.deleteByKW(KW);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
}
