package vo;
import java.sql.Date;

public class transferorder {
	private String orderid;
	private String createrid;
	private String productid;
	private String managerid;
	private Integer quantity;
	private Date orderdate;
	private String fromsh;
	private String tosh;
	
	
	public String getOrderid(){
		return this.orderid;
	}
	public String getCreaterid(){
		return this.createrid;
	}
	public String getProductid(){
		return this.productid;
	}
	public String getManagerid(){
		return this.managerid;
	}
	public Integer getQuantity(){
		return this.quantity;
	}
	public Date getOrderdate(){
		return this.orderdate;
	}
	public String getFromsh(){
		return this.fromsh;
	}
	public String getTosh(){
		return this.tosh;
	}
	
	public void setOrderid(String orderid){
		this.orderid=orderid;
	}
	public void setCreaterid(String createrid){
		this.createrid=createrid;
	}
	public void setProductid(String productid){
		this.productid=productid;
	}
	public void setManagerid(String managerid){
		this.managerid=managerid;
	}
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}	
	public void setOrderdate(Date orderdate){
		this.orderdate=orderdate;
	}
	public void setFromsh(String fromsh){
		this.fromsh=fromsh;
	}	
	public void setTosh(String tosh){
		this.tosh=tosh;
	}	
  
}
