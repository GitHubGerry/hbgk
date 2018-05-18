package factory;
import dao.Isupplier;
import dao.proxy.SupplierProxy;

public class SupplierFactory {
	public static Isupplier getIsupplierInstance() throws Exception{
		return new SupplierProxy();
	}
}
