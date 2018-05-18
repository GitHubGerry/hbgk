package dao;
import java.util.List;
import vo.storehouse;

public interface IStorehouse {
	public boolean doCreate(storehouse emp) throws Exception;
	
	public List<storehouse> findAll(String keyWord1,String keyWord2) throws Exception;
	
	public storehouse findById(String id) throws Exception;//服务于增，删，改，后面用也没办法~
	
	public boolean updateByKW(String KW,String keyWord) throws Exception;
	
	public boolean deleteByKW(String KW) throws Exception;
	
}
