package factory;
import dao.ISituation;
import dao.proxy.SituationProxy;

public class SituationFactory {
	public static ISituation getSituationInstance() throws Exception{
		return new SituationProxy();
	}
}
