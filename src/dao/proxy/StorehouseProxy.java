package dao.proxy;
import java.util.List;
import dao.IStorehouse;
import dao.impl.StorehouseImpl;
import factory.SqlServerFactory;//用连接数据库的工厂类没有getConnection()?有啊。getDatabaseConnection().getConnection()
import vo.storehouse;

public class StorehouseProxy implements IStorehouse{
	//private SqlServerFactory dbc=null; 
	private IStorehouse dao =null;
	public StorehouseProxy() throws Exception{
		//this.dbc=new SqlServerFactory();
		this.dao=new StorehouseImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	
	public boolean doCreate(storehouse emp) throws Exception{
		boolean flag=false;
		try{		
				flag=this.dao.doCreate(emp);
			
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
	public List<storehouse> findAll(String keyWord1,String keyWord2) throws Exception{
		List<storehouse> all=null;
		try{
			all=this.dao.findAll(keyWord1, keyWord2);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
	
	public storehouse findById(String id) throws Exception{
		
		storehouse emp=null;
		try{
			emp=this.dao.findById(id);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return emp;
		
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
