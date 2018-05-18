package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.users;
import dao.ILogin;

public class LoginImpl implements ILogin{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public LoginImpl(Connection conn){
		this.conn=conn;
	}
	public boolean findLogin(users users) throws Exception{
		boolean flag=false;
		try{
			String sql="select * from users where userid=? and password=?";
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1,users.getUserid());
			this.pstmt.setString(2,users.getPassword());
			
			System.out.println(users.getUserid());
			System.out.println(users.getPassword());
			
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next()){
				users.setNickname(rs.getString(3));
				users.setParentUserId(rs.getString(6));
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pstmt!=null){
				try{
					this.pstmt.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}	
}
