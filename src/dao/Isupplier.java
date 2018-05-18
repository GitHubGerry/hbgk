package dao;
import java.util.List;
import vo.supplier;

public interface Isupplier {
	public boolean doCreate(supplier emp) throws Exception;
	
	public List<supplier> findAll(String createrid) throws Exception;
	
	public void volumeAdd(String KW) throws Exception;
		
	public boolean updateByKW(String KW,String keyWord) throws Exception;
	
	public boolean deleteByKW(String KW) throws Exception;
	
}
