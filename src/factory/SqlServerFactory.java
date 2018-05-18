package factory;
import dbc.DatabaseConnection;
import dbc.impl.SqlServerDatabaseConnection;


public class SqlServerFactory {//DatabaseConnection 是返回的类型
		public static DatabaseConnection getDatabaseConnection() throws Exception{
			return new SqlServerDatabaseConnection();
		}
	
}
