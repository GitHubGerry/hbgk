package dao;
import vo.purchaseorder;
import java.util.List;

public interface IPurchaseorder {
	public boolean doCreate(purchaseorder emp) throws Exception;
	public List<purchaseorder> findAll(String kW) throws Exception;
}
