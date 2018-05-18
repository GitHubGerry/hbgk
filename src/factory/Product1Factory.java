package factory;
import dao.IProduct1;
import dao.proxy.Product1Proxy;

public class Product1Factory {
	public static IProduct1 getIProduct1Instance() throws Exception{
		return new Product1Proxy();
	}

}
