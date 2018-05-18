package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ISituation;
import vo.situation;

public class SituationImpl implements ISituation{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public SituationImpl(Connection conn){    //通过构造方法取得数据库连接
		this.conn=conn;
	}
	public List<situation> findAll(String createrid) throws Exception{
		List<situation> all=new ArrayList<situation>();	
		try{		
			String sql="select productid,productname,housename,averagePerCost,quantity from products where createrid=? order by housename";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,createrid);
			ResultSet rs=this.pstmt.executeQuery();
			situation emp=null;
			while(rs.next()){
				emp=new situation();
				emp.setProductid(rs.getString(1));
				emp.setProductname(rs.getString(2));
				emp.setHousename(rs.getString(3));
				emp.setAveragepercost(rs.getBigDecimal(4));
				emp.setQuantity(rs.getInt(5));
				all.add(emp);      //链表加一个对象
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return all;
	}
}
