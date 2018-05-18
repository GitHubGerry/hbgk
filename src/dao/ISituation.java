package dao;
import java.util.List;
import vo.situation;


public interface ISituation {
	public List<situation> findAll(String createrid) throws Exception;
	
}