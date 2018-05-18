package vo;
import java.math.BigDecimal;
import java.sql.Date;

public class purchaseorder {
	private String orderid;
	private String createrid;
	private String productid;
	private String supplierid;
	private BigDecimal perprice;
	private Integer quantity;
	private Date orderdate;
	private BigDecimal amount;
	
	public String getOrderid(){
		return this.orderid;
	}
	public String getCreaterid(){
		return this.createrid;
	}
	public String getProductid(){
		return this.productid;
	}
	public String getSupplierid(){
		return this.supplierid;
	}
	public BigDecimal getPerprice(){
		return this.perprice;
	}
	public Integer getQuantity(){
		return this.quantity;
	}
	public Date getOrderdate(){
		return this.orderdate;
	}
	public BigDecimal getAmount(){
		return this.amount;
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
	public void setSupplierid(String supplierid){
		this.supplierid=supplierid;
	}
	public void setPerprice(BigDecimal perprice){
		this.perprice=perprice;
	}	
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}	
	public void setOrderdate(Date orderdate){
		this.orderdate=orderdate;
	}
	public void setAmount(BigDecimal amount){
		this.amount=amount;
	}	
 
}
