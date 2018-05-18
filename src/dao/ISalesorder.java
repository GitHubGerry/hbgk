package dao;
import vo.salesorder;
import java.util.List;

public interface ISalesorder {
	public boolean doCreate(salesorder emp) throws Exception;
	public List<salesorder> findAll(String kW) throws Exception;
}
