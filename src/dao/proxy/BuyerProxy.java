package dao.proxy;
import java.util.List;

import dao.Ibuyer;
import dao.impl.BuyerImpl;
import factory.SqlServerFactory;
import vo.buyer;

public class BuyerProxy implements Ibuyer{
	private Ibuyer dao =null;
	public BuyerProxy() throws Exception{
		this.dao=new BuyerImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	
	public boolean doCreate(buyer emp) throws Exception{
		boolean flag=false;
		try{
			
				flag=this.dao.doCreate(emp);
			
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
	public List<buyer> findAll(String createrid) throws Exception{
		List<buyer> all=null;
		try{
			all=this.dao.findAll(createrid);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
	
	public void volumeAdd(String KW) throws Exception{
		try{
			this.dao.volumeAdd(KW);
			System.out.println("addhere");
		}catch(Exception e){
			throw e;
		}
	
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


	public void countapp(String KW) throws Exception{
		try{
			System.out.println("counthere");
			this.dao.countapp(KW);
		}catch(Exception e){
			throw e;
		}
		
	}
	
}
