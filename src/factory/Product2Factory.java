package factory;
import dao.IProduct2;
import dao.proxy.Product2Proxy;

public class Product2Factory {
	public static IProduct2 getIProduct2Instance() throws Exception{
		return new Product2Proxy();
	}

}