package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.IProduct3;

public class Product3Impl implements IProduct3{
	private Connection conn=null;
	private PreparedStatement pstmt=null;

	public Product3Impl(Connection conn){    //通过构造方法取得数据库连接//卖货用
		this.conn=conn;
	}
	
	public boolean updateByKW(String KW,String KeyWord) throws Exception{
		boolean flag=false;
		String[] kw;
		kw=KW.split("\t");
		String sql=null;
		try{

			Integer quantity=null;
			Integer qminus=Integer.parseInt(KeyWord);

			
			sql="select quantity from products where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()){

				quantity=rs.getInt(1)-qminus;

			}
			this.pstmt.close();
					
			sql="update products set quantity=? where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,quantity);

			this.pstmt.setString(2,kw[0]);			
			this.pstmt.setString(3,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			
		}catch(Exception e){
			throw e;
		}
			
		return flag;
	}
}
