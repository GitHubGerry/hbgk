package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.IStorehouse;
import vo.storehouse;

public class StorehouseImpl implements IStorehouse {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	
	public StorehouseImpl(Connection conn){    //通过构造方法取得数据库连接
		this.conn=conn;
	}
	
	public boolean doCreate(storehouse emp) throws Exception{
		boolean flag=false;
		try{
			String sql="insert into storehouse(housename,createrid,managerid,on_off,createdate) values(?,?,?,?,?)";
			
			
			this.pstmt=this.conn.prepareStatement(sql); 
			//取得实例对象三步：1.Class.forName() 2.conn=DriverManager.getConnection() 3.pstmt=conn.prepareStatement(sql)
			
			this.pstmt.setString(1,emp.getHousename());
			this.pstmt.setString(2,emp.getCreaterid());
			this.pstmt.setString(3,emp.getManagerid());
			this.pstmt.setString(4,emp.getOn_off());
			this.pstmt.setDate(5,emp.getCreatedate());
			
			
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	public List<storehouse> findAll(String keyWord1,String keyWord2) throws Exception{
		List<storehouse> all=new ArrayList<storehouse>();
	
		try{
			
			
			String sql="select * from storehouse where "+keyWord1+"='"+keyWord2+"'";			
			this.stmt=this.conn.createStatement();  //preparestatement自动加引号，并且转意你的单引号比statement安全。
			
			//System.out.println("11"+keyWord1+keyWord2);
			//System.out.println(sql);
			ResultSet rs=this.stmt.executeQuery(sql);//执行查询、executeUpdate执行增删改、execute返回多个结果集，太高级...
			//System.out.println(this.pstmt.toString());mysql可以查sql，sqlserver只能计数......
			
			storehouse emp=null;
			while(rs.next()){
				emp=new storehouse();
				emp.setHousename(rs.getString(1));
				emp.setCreaterid(rs.getString(2));
				emp.setManagerid(rs.getString(3));
				emp.setOn_off(rs.getString(4));
				emp.setCreatedate(rs.getDate(5));
				all.add(emp);      //链表加一个对象
			}
			this.stmt.close();
		}catch(Exception e){
			throw e;
		}
		return all;
				
	}
	
	public storehouse findById(String id) throws Exception{
		storehouse emp=null;
		
		try{
			String sql="select * from storehouse where housename=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,id);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next()){
				emp=new storehouse();
				emp.setHousename(rs.getString(1));
				emp.setCreaterid(rs.getString(2));
				emp.setManagerid(rs.getString(3));
				emp.setOn_off(rs.getString(4));
				emp.setCreatedate(rs.getDate(5));
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return emp;				
	}
	
	public boolean updateByKW(String KW,String keyWord) throws Exception{
		boolean flag=false;
		System.out.println(keyWord);
		String[] kw;
		kw=KW.split("\t");

		String[] value;
		value=keyWord.split("\t");
		try{
			String sql="update storehouse set housename=?,managerid=?,on_off=? where createrid=? and housename=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,value[0]);
			this.pstmt.setString(2,value[1]);
			this.pstmt.setString(3,value[2]);
			this.pstmt.setString(4,kw[0]);			
			this.pstmt.setString(5,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	public boolean deleteByKW(String KW) throws Exception{
		boolean flag=false;
		String[] kw;
		kw=KW.split("\t");
		try{
			String sql="delete storehouse where createrid=? and housename=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
					
		}catch(Exception e){
			throw e;
		}
		return flag;
		
		
	}
	
}
