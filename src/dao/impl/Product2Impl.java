package dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.IProduct2;

public class Product2Impl implements IProduct2{
	private Connection conn=null;
	private PreparedStatement pstmt=null;

	public Product2Impl(Connection conn){    //通过构造方法取得数据库连接//进货用
		this.conn=conn;
	}
	
	public boolean updateByKW(String KW,String KeyWord) throws Exception{
		boolean flag=false;
		String[] kw;
		kw=KW.split("\t");
		String[] value;
		value=KeyWord.split("\t");
		String sql=null;
		try{
			BigDecimal apc=null;
			BigDecimal apc2=new BigDecimal(value[0]);
			Integer quantity=null;
			Integer qadd=Integer.parseInt(value[1]);
			BigDecimal qaddd=new BigDecimal(qadd);
			
			sql="select averagePerCost,quantity from products where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()){
				BigDecimal bb=rs.getBigDecimal(2);
				if(bb==null || "".equals(bb)){
					bb=new BigDecimal("0");
				}
				apc=rs.getBigDecimal(1).multiply(bb);
				quantity=rs.getInt(2)+qadd;
				BigDecimal qq=new BigDecimal(quantity);
				apc=(apc.add(apc2.multiply(qaddd))).divide(qq,2);
			}
			this.pstmt.close();
			
			
			sql="update products set averagePerCost=?,quantity=? where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setBigDecimal(1,apc);
			this.pstmt.setInt(2,quantity);
			

			this.pstmt.setString(3,kw[0]);			
			this.pstmt.setString(4,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			
		}catch(Exception e){
			throw e;
		}
			
		return flag;
	}
}
