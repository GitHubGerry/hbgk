package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.transferorder;
import dao.ITransferorder;

public class TransferorderImpl implements ITransferorder{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
public TransferorderImpl(Connection conn){
	this.conn=conn;
}

public void doCreate(transferorder emp) throws Exception{
	try{
		String sql="insert into transferorder(orderid,productid,fromsh,tosh,quantity,orderdate,managerid,createrid) values(?,?,?,?,?,?,?,?)";	
		this.pstmt=this.conn.prepareStatement(sql); 	
		this.pstmt.setString(1,emp.getOrderid());
		this.pstmt.setString(2,emp.getProductid());
		this.pstmt.setString(3,emp.getFromsh());
		this.pstmt.setString(4,emp.getTosh());
		this.pstmt.setInt(5,emp.getQuantity());
		this.pstmt.setDate(6,emp.getOrderdate());
		this.pstmt.setString(7,emp.getManagerid());
		this.pstmt.setString(8,emp.getCreaterid());
		
		if(this.pstmt.executeUpdate()>0){

		}
		this.pstmt.close();
	}catch(Exception e){
		throw e;
	}

}
public List<transferorder> findAll(String KW) throws Exception{
	List<transferorder> all=new ArrayList<transferorder>();
	try{

		String sql="select '('+a.productid+')  '+b.productname as product,a.fromsh,a.tosh,a.quantity,a.orderdate,a.managerid,a.createrid,a.orderid from transferorder a join products b on a.productid=b.productid where a.createrid=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,KW);
		ResultSet rs=this.pstmt.executeQuery();
		transferorder emp=null;
		while(rs.next()){
			emp=new transferorder();
			
			emp.setProductid(rs.getString(1));
			emp.setFromsh(rs.getString(2));
			emp.setTosh(rs.getString(3));
			emp.setQuantity(rs.getInt(4));
			emp.setOrderdate(rs.getDate(5));
			emp.setManagerid(rs.getString(6));
			emp.setCreaterid(rs.getString(7));
			emp.setOrderid(rs.getString(8));
			
			all.add(emp);      //链表加一个对象
		}
		this.pstmt.close();
	}catch(Exception e){
		throw e;
	}
	return all;
			
}
	
}
