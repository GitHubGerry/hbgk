package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IProduct1;
import vo.product1;


public class Product1Impl implements IProduct1 {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	
	public Product1Impl(Connection conn){    //通过构造方法取得数据库连接
		this.conn=conn;
	}
	
	public boolean doCreate(product1 emp) throws Exception{
		boolean flag=false;
		try{
			String sql="insert into products(productid,productname,housename,averagePerCost,brand,category,feature1,feature2,createrid) values(?,?,?,?,?,?,?,?,?)";			
			this.pstmt=this.conn.prepareStatement(sql); 
			this.pstmt.setString(1,emp.getProductid());
			this.pstmt.setString(2,emp.getProductname());
			this.pstmt.setString(3,emp.getHousename());
			this.pstmt.setBigDecimal(4,emp.getAveragepercost());
			this.pstmt.setString(5,emp.getBrand());
			this.pstmt.setString(6,emp.getCategory());
			this.pstmt.setString(7,emp.getFeature1());
			if(emp.getFeature2()==null || "".equals(emp.getFeature2())){
				this.pstmt.setString(8," ");
			}else{
				this.pstmt.setString(8,emp.getFeature2());	
			}
			this.pstmt.setString(9,emp.getCreaterid());
			
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	public List<product1> findAll(String createrid) throws Exception{
		List<product1> all=new ArrayList<product1>();	
		try{		
			String sql="select productid,productname,housename,averagePerCost,brand,category,feature1,feature2 from products where createrid='"+createrid+"' order by productid";
			System.out.println(sql);
			this.stmt=this.conn.createStatement(); 
			ResultSet rs=this.stmt.executeQuery(sql);
			product1 emp=null;
			while(rs.next()){
				emp=new product1();
				emp.setProductid(rs.getString(1));
				emp.setProductname(rs.getString(2));
				emp.setHousename(rs.getString(3));
				emp.setAveragepercost(rs.getBigDecimal(4));
				emp.setBrand(rs.getString(5));
				emp.setCategory(rs.getString(6));
				emp.setFeature1(rs.getString(7));
				emp.setFeature2(rs.getString(8));
				
				all.add(emp);      //链表加一个对象
			}
			this.stmt.close();
		}catch(Exception e){
			throw e;
		}
		return all;
				
	}
	public boolean findByKW(String KW) throws Exception{
		boolean flag=false;
		String[] value=KW.split("\t");
		try{
			String sql="select 1 from products where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,value[0]);
			this.pstmt.setString(2,value[1]);
			
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return flag;				
	}

	
	public boolean updateByKW(String KW,String keyWord) throws Exception{
		boolean flag=false;
		String[] kw;
		kw=KW.split("\t");

		String[] value;
		value=keyWord.split("\t");
		try{
			String sql="update products set productid=?,productname=?,housename=?,averagePerCost=?,brand=?,category=?,feature1=?,feature2=? where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,value[0]);
			this.pstmt.setString(2,value[1]);
			this.pstmt.setString(3,value[2]);
			this.pstmt.setString(4,value[3]);			
			this.pstmt.setString(5,value[4]);
			this.pstmt.setString(6,value[5]);			
			this.pstmt.setString(7,value[6]);
			this.pstmt.setString(8,value[7]);
			
			this.pstmt.setString(9,kw[0]);			
			this.pstmt.setString(10,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			
		}catch(Exception e){
			throw e;
		}
		this.pstmt.close();
		return flag;
	}
	public boolean deleteByKW(String KW) throws Exception{
		boolean flag=false;
		String[] kw;
		kw=KW.split("\t");
		try{
			String sql="delete products where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
					
		}catch(Exception e){
			throw e;
		}
		this.pstmt.close();
		return flag;
		
		
	}
	
}
