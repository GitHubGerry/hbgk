package factory;
import dao.IStorehouse;
import dao.proxy.StorehouseProxy;

public class StorehouseFactory {
	public static IStorehouse getIStorehouseInstance() throws Exception{//��̬����
		return new StorehouseProxy();
	}

}
