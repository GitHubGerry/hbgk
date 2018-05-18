package dao.proxy;
import java.util.List;
import dao.Isupplier;
import dao.impl.SupplierImpl;
import factory.SqlServerFactory;
import vo.supplier;

public class SupplierProxy implements Isupplier{
	private Isupplier dao =null;
	public SupplierProxy() throws Exception{
		this.dao=new SupplierImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	
	public boolean doCreate(supplier emp) throws Exception{
		boolean flag=false;
		try{
			
				flag=this.dao.doCreate(emp);
			
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return flag;
	}
	
	public List<supplier> findAll(String createrid) throws Exception{
		List<supplier> all=null;
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
	
}
