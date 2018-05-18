package vo;
import java.math.BigDecimal;

public class situation {
	private String productid;
	private String productname;
	private String housename;
	private BigDecimal averagepercost;
	private Integer quantity;
	private String createrid;
	
	public String getProductid(){
		return this.productid;
	}
	public String getProductname(){
		return this.productname;
	}
	public BigDecimal getAveragepercost(){
		return this.averagepercost;
	}
	public Integer getQuantity(){
		return this.quantity;
	}
	public String getCreaterid(){
		return this.createrid;
	}
	public String getHousename(){
		return this.housename;
	}
	
	public void setProductid(String productid){
		this.productid=productid;
	}
	public void setProductname(String productname){
		this.productname=productname;
	}
	public void setAveragepercost(BigDecimal averagepercost){
		this.averagepercost=averagepercost;
	}
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}
	public void setCreaterid(String createrid){
		this.createrid=createrid;
	}
	public void setHousename(String housename){
		this.housename=housename;
	}
}
