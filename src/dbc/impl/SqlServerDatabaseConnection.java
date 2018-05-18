package dbc.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import dbc.DatabaseConnection;

public class SqlServerDatabaseConnection implements DatabaseConnection{
	private Connection conn=null;
	public SqlServerDatabaseConnection() throws Exception{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=mysystem","sa","sqlserver2008");
		}catch(Exception e){
			System.out.println("SqlServerDatabaseConnection find a error!");
			throw e;		
		}
		
	}
	public Connection getConnection(){
		
		return this.conn;
	}
	public void close(){
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch(Exception e){
				System.out.println("conn close error!");
			}
			
		}
		
	}
}
