package factory;
import dao.ISalesorder;
import dao.proxy.SalesorderProxy;

public class SalesorderFactory {

	public static ISalesorder getISalesorderInstance() throws Exception{
		return new SalesorderProxy();
	}
}
