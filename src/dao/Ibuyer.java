package dao;
import java.util.List;
import vo.buyer;

public interface Ibuyer {
	public boolean doCreate(buyer emp) throws Exception;
	
	public List<buyer> findAll(String createrid) throws Exception;
	
	public void volumeAdd(String KW) throws Exception;
		
	public boolean updateByKW(String KW,String keyWord) throws Exception;
	
	public boolean deleteByKW(String KW) throws Exception;
	
	public void countapp(String KW) throws Exception;
	
}
