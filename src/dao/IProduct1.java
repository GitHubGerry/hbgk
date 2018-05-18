package dao;
import java.util.List;
import vo.product1;


public interface IProduct1 {
	public boolean doCreate(product1 emp) throws Exception;
	
	public List<product1> findAll(String createrid) throws Exception;
	
	public boolean findByKW(String KW) throws Exception;
		
	public boolean updateByKW(String KW,String keyWord) throws Exception;
	
	public boolean deleteByKW(String KW) throws Exception;
	
}