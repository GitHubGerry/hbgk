package vo;
import java.sql.Date;

public class storehouse {
	private String housename;
	private String createrid;
	private String managerid;
	private String on_off;
	private Date createdate;
	
	public String getHousename(){
		return this.housename;
	}
	public String getCreaterid(){
		return this.createrid;
	}
	public String getManagerid(){
		return this.managerid;
	}
	public String getOn_off(){
		return this.on_off;
	}
	public Date getCreatedate(){
		return this.createdate;
	}
	public void setHousename(String housename){
		this.housename=housename;
	}
	public void setCreaterid(String createrid){
		this.createrid=createrid;
	}
	public void setManagerid(String managerid){
		this.managerid=managerid;
	}
	public void setOn_off(String on_off){
		this.on_off=on_off;
	}
	public void setCreatedate(Date createdate){
		this.createdate=createdate;
	}
	 
}
