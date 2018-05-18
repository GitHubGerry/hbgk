package dao;
import vo.transferorder;
import java.util.List;

public interface ITransferorder {
	public List<transferorder> findAll(String KW) throws Exception;
	public void doCreate(transferorder emp) throws Exception;
	
}
