package dao.impl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Ibuyer;
import vo.buyer;

public class BuyerImpl implements Ibuyer {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	
	public BuyerImpl(Connection conn){    //通过构造方法取得数据库连接
		this.conn=conn;
	}
	
	public boolean doCreate(buyer emp) throws Exception{
		boolean flag=false;
		try{
			String sql="insert into buyer(buyerid,companyname,linkman1,tele1,linkman2,tele2,wechat,volume,averageProfitPercent,createrid,lastProfitPercent) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			this.pstmt=this.conn.prepareStatement(sql); 			
			this.pstmt.setString(1,emp.getBuyerid());
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
			this.pstmt.setString(9,"0.00%");
			this.pstmt.setString(10,emp.getCreaterid());
			this.pstmt.setString(11,"0.00%");
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			this.pstmt.close();
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	public List<buyer> findAll(String createrid) throws Exception{
		List<buyer> all=new ArrayList<buyer>();
	
		try{			
			String sql="select * from buyer where createrid='"+createrid+"' order by buyerid";			
			this.stmt=this.conn.createStatement();
			ResultSet rs=this.stmt.executeQuery(sql);
			buyer emp=null;
			while(rs.next()){
				emp=new buyer();
				emp.setBuyerid(rs.getString(1));
				emp.setCompanyname(rs.getString(2));
				emp.setLinkman1(rs.getString(3));
				emp.setTele1(rs.getString(4));
				emp.setLinkman2(rs.getString(5));
				emp.setTele2(rs.getString(6));
				emp.setWechat(rs.getString(7));
				emp.setVolume(rs.getInt(8));
				emp.setApp(rs.getString(9));
				emp.setCreaterid(rs.getString(10));
				emp.setLpp(rs.getString(11));
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
			System.out.println(kw[0]);
			System.out.println(kw[1]);//死活不执行下面的 无解----------忘记写execute了
			String sql="update buyer set volume=volume+1 where createrid=? and buyerid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			pstmt.executeUpdate();
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
			String sql="update buyer set buyerid=?,companyname=?,linkman1=?,tele1=?,linkman2=?,tele2=?,wechat=? where createrid=? and buyerid=?";
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
			String sql="delete buyer where createrid=? and buyerid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,kw[0]);
			this.pstmt.setString(2,kw[1]);
			if(this.pstmt.executeUpdate()>0){
				flag=true;
			}
			this.pstmt.close();		
		}catch(Exception e){
			throw e;
		}
		return flag;
		
		
	}
	public void countapp(String KW) throws Exception{
		System.out.println("lm no idea?");
		String[] kw=KW.split("\t");
		String cid=kw[0];
		String pid=kw[1];
		String bid=kw[2];
		BigDecimal price=new BigDecimal(kw[3]);
		BigDecimal apc = null;
		BigDecimal hundred=new BigDecimal("100.00");
		BigDecimal two=new BigDecimal("2");
		BigDecimal one=new BigDecimal("1");
		String app = null;
		try{
			String sql="select averagepercost from products where createrid=? and productid=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,cid);
			this.pstmt.setString(2,pid);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()){
				apc=rs.getBigDecimal(1);
				System.out.println("apc："+apc);
			}
			this.pstmt.close();
			
			String sql2="select averageprofitpercent from buyer where createrid=? and buyerid=?";
			this.pstmt=this.conn.prepareStatement(sql2);
			this.pstmt.setString(1,cid);
			this.pstmt.setString(2,bid);
			ResultSet rs2=this.pstmt.executeQuery();
			if(rs2.next()){
				app=rs2.getString(1);
			}
			this.pstmt.close();
			
			BigDecimal app2=new BigDecimal(app.substring(0,app.length()-1));//0对应第1个字符，第2个参数指向最后一个字符，不包含。
			BigDecimal lpp=price.subtract(apc).divide(apc, 4, BigDecimal.ROUND_HALF_DOWN).multiply(hundred).divide(one,2, BigDecimal.ROUND_HALF_DOWN);
			BigDecimal appnew=app2.add(lpp).divide(two,2, BigDecimal.ROUND_HALF_DOWN);
			//7.5/20=5/20+10/20   要做加权的还得传本次交易数量，共交易数量，这里只能做不加权的。
			System.out.println("lpp："+lpp);
			System.out.println("appnew："+appnew);
			
			String sql3="update buyer set averageprofitpercent=?,lastprofitpercent=? where createrid=? and buyerid=?";
			this.pstmt=this.conn.prepareStatement(sql3);
			this.pstmt.setString(1,appnew.toString()+"%");
			this.pstmt.setString(2,lpp.toString()+"%"); //toString方法转型
			this.pstmt.setString(3,cid);
			this.pstmt.setString(4,bid);
			
			this.pstmt.executeUpdate();
			this.pstmt.close();
		
			}catch(Exception e){
				throw e;
			}
					
		}
		
		
		
	}
	

