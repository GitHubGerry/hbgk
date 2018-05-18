package factory;
import dao.IPurchaseorder;
import dao.proxy.PurchaseorderProxy;

public class PurchaseorderFactory {

	public static IPurchaseorder getIPurchaseorderInstance() throws Exception{
		return new PurchaseorderProxy();
	}
}
