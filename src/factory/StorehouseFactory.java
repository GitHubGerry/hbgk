package factory;
import dao.IStorehouse;
import dao.proxy.StorehouseProxy;

public class StorehouseFactory {
	public static IStorehouse getIStorehouseInstance() throws Exception{//¾²Ì¬·½·¨
		return new StorehouseProxy();
	}

}
