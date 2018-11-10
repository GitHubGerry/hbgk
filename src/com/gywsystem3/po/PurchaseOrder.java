package com.gywsystem3.po;
import java.math.BigDecimal;
import java.sql.Date;

public class PurchaseOrder {
	private String housename;//外援
	private BigDecimal perprice; 
	private int quantity;//这些都是进货表外的                        好像不用啊？用，查询时数据的容器，增删改时用不到！    我称之为“表外模型内！”
	
	private String orderid;
	private String createrid;
	private String productid;
	private String supplierid;//这个字段就是即是本模型有 ，又是其他模型有的，有点怪
	private Date orderdate;
	private BigDecimal amount;
	
	public String getHousename(){
		return this.housename;
	}
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
	public int getQuantity(){
		return this.quantity;
	}
	public Date getOrderdate(){
		return this.orderdate;
	}
	public BigDecimal getAmount(){
		return this.amount;
	}
	
	public void setHousename(String housename){
		this.housename=housename;
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
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}	
	public void setOrderdate(Date orderdate){
		this.orderdate=orderdate;
	}
	public void setAmount(BigDecimal amount){
		this.amount=amount;
	}	
 
}
