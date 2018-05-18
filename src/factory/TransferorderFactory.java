package factory;
import dao.ITransferorder;
import dao.proxy.TransferorderProxy;

public class TransferorderFactory {

	public static ITransferorder getITransferorderInstance() throws Exception{
		return new TransferorderProxy();
	}
}
