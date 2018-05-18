package factory;
import dao.IProduct3;
import dao.proxy.Product3Proxy;

public class Product3Factory {
	public static IProduct3 getIProduct3Instance() throws Exception{
		return new Product3Proxy();
	}

}