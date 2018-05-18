package dao.proxy;

import java.util.List;
import dao.ITransferorder;
import dao.impl.TransferorderImpl;
import factory.SqlServerFactory;
import vo.transferorder;


public class TransferorderProxy implements ITransferorder{
	private ITransferorder dao =null;
	public TransferorderProxy() throws Exception{
		this.dao=new TransferorderImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	public void doCreate(transferorder emp) throws Exception{

		try{		
				this.dao.doCreate(emp);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();

	}
	public List<transferorder> findAll(String KW) throws Exception{
		List<transferorder> all=null;
		try{
			all=this.dao.findAll(KW);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
}
