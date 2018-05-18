package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.Isupplier;
import vo.supplier;

public class SupplierImpl implements Isupplier {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	
	public SupplierImpl(Connection conn){    //通过构造方法取得数据库连接
		this.conn=conn;
	}
	
	public boolean doCreate(supplier emp) throws Exception{
		boolean flag=false;
		try{
			String sql="insert into supplier(supplierid,companyname,linkman1,tele1,linkman2,tele2,wechat,volume,createrid) values(?,?,?,?,?,?,?,?,?)";
			
			this.pstmt=this.conn.prepareStatement(sql); 			
			this.pstmt.setString(1,emp.getSupplierid());
			this.pstmt.setString(2,emp.getCompanyname());
			this.pstmt.setString(3,emp.getLinkman1());
			this.pstmt.setString(4,emp.getTele1());
			
			if(emp.getLinkman2()==null || "".equals(emp.getLinkman2())){
				this.pstmt.setString(5," ");
			}else{
				this.pstmt.setString(5,emp.getLinkman2());	
			}
			if(emp.getTele2()==null || "".equals(emp.getTele2())){
				this.pstmt.setString(6," ");
			}else{
				this.pstmt.setString(6,emp.getTele2());	
			}
			this.pstmt.setString(7,emp.getWechat());
			this.pstmt.setInt(8,emp.getVolume());
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
	public List<supplier> findAll(String createrid) throws Exception{
		List<supplier> all=new ArrayList<supplier>();
	
		try{			
			String sql="select * from supplier where createrid='"+createrid+"' order by supplierid";			
			this.stmt=this.conn.createStatement();
			ResultSet rs=this.stmt.executeQuery(sql);
			supplier emp=null;
			while(rs.next()){
				emp=new supplier();
				emp.setSupplierid(rs.getString(1));
				emp.setCompanyname(rs.getString(2));
				emp.setLinkman1(rs.getString(3));
				emp.setTele1(rs.getString(4));
				emp.setLinkman2(rs.getString(5));
				emp.setTele2(rs.getString(6));
				emp.setWechat(rs.getString(7));
				emp.setVolume(rs.getInt(8));
				emp.setCreaterid(rs.getString(9));				
				all.add(emp);      //链表加一个对象
			}
			this.stmt.close();
		}catch(Exception e){
			throw e;
		}
		return all;
				
	}
	
	public void volumeAdd(String KW) throws Exception{
		
		String[] kw;
		kw=KW.split("\t");

		try{
			System.out.println("here!");
			System.out.println(kw[0]);
			System.out.println(kw[1]);//死活不执行下面的 无解----------
			String sql="update supplier set volume=volume+1 where createrid=? and supplierid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			this.pstmt.executeUpdate();
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}			
	}
	
	public boolean updateByKW(String KW,String keyWord) throws Exception{
		boolean flag=false;
		String[] kw;
		kw=KW.split("\t");

		String[] value;
		value=keyWord.split("\t");
		try{
			String sql="update supplier set supplierid=?,companyname=?,linkman1=?,tele1=?,linkman2=?,tele2=?,wechat=? where createrid=? and supplierid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,value[0]);
			this.pstmt.setString(2,value[1]);
			this.pstmt.setString(3,value[2]);
			this.pstmt.setString(4,value[3]);			
			this.pstmt.setString(5,value[4]);
			this.pstmt.setString(6,value[5]);			
			this.pstmt.setString(7,value[6]);
			
			this.pstmt.setString(8,kw[0]);			
			this.pstmt.setString(9,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			
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
			String sql="delete supplier where createrid=? and supplierid=?";
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
