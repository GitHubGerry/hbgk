package factory;
import dbc.DatabaseConnection;
import dbc.impl.SqlServerDatabaseConnection;


public class SqlServerFactory {//DatabaseConnection �Ƿ��ص�����
		public static DatabaseConnection getDatabaseConnection() throws Exception{
			return new SqlServerDatabaseConnection();
		}
	
}
