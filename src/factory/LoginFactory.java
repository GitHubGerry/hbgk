package factory;
import dao.ILogin;
import dao.proxy.LoginProxy;
public class LoginFactory {
	public static ILogin getILoginInstance() throws Exception{
		return new LoginProxy();
	}
}

