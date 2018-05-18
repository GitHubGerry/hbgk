package factory;
import dao.Ibuyer;
import dao.proxy.BuyerProxy;

public class BuyerFactory {
	public static Ibuyer getIbuyerInstance() throws Exception{
		return new BuyerProxy();
	}
}
