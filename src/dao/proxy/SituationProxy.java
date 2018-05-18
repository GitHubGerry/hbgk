package dao.proxy;
import java.util.List;

import dao.ISituation;
import dao.impl.SituationImpl;
import factory.SqlServerFactory;
import vo.situation;

public class SituationProxy implements ISituation{
	private ISituation dao=null;
	public SituationProxy() throws Exception{
		this.dao=new SituationImpl(SqlServerFactory.getDatabaseConnection().getConnection());
	}
	public List<situation> findAll(String createrid) throws Exception{
		List<situation> all=null;
		try{
			all=this.dao.findAll(createrid);
		}catch(Exception e){
			throw e;
		}
		SqlServerFactory.getDatabaseConnection().close();
		return all;		
	}
	
}
