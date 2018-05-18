package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.salesorder;
import dao.ISalesorder;

public class SalesorderImpl implements ISalesorder{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
public SalesorderImpl(Connection conn){
	this.conn=conn;
}

public boolean doCreate(salesorder emp) throws Exception{
	boolean flag=false;
	try{
		System.out.println(emp.getAmount());
		String sql="insert into salesorder(orderid,productid,buyerid,perprice,quantity,orderdate,createrid,amount) values(?,?,?,?,?,?,?,?)";	
		this.pstmt=this.conn.prepareStatement(sql); 	
		this.pstmt.setString(1,emp.getOrderid());
		this.pstmt.setString(2,emp.getProductid());
		this.pstmt.setString(3,emp.getBuyerid());
		this.pstmt.setBigDecimal(4,emp.getPerprice());
		this.pstmt.setInt(5,emp.getQuantity());
		this.pstmt.setDate(6,emp.getOrderdate());
		this.pstmt.setString(7,emp.getCreaterid());
		this.pstmt.setBigDecimal(8,emp.getAmount());
		
		if(this.pstmt.executeUpdate()>0){
			flag=true;
		}
		this.pstmt.close();
	}catch(Exception e){
		throw e;
	}
	return flag;
}
public List<salesorder> findAll(String KW) throws Exception{
	List<salesorder> all=new ArrayList<salesorder>();
	try{

		String sql="select b.housename+'@'+a.orderid,'('+a.productid+')  '+b.productname as product,'('+a.buyerid+')  '+c.companyname as buyer,";
		sql+="a.perprice,a.quantity,a.orderdate,a.createrid,a.amount from salesOrder a ";
		sql+="join products b on a.productid=b.productid join buyer c on a.buyerid=c.buyerid where a.createrid=? order by a.orderid";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,KW);
		ResultSet rs=this.pstmt.executeQuery();
		salesorder emp=null;
		while(rs.next()){
			emp=new salesorder();
			emp.setOrderid(rs.getString(1));
			emp.setProductid(rs.getString(2));
			emp.setBuyerid(rs.getString(3));
			emp.setPerprice(rs.getBigDecimal(4));
			emp.setQuantity(rs.getInt(5));
			emp.setOrderdate(rs.getDate(6));
			emp.setCreaterid(rs.getString(7));
			emp.setAmount(rs.getBigDecimal(8));
			all.add(emp);      //链表加一个对象
		}
		this.pstmt.close();
	}catch(Exception e){
		throw e;
	}
	return all;
			
}
	
}
