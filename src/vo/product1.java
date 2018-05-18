package vo;
import java.math.BigDecimal;

public class product1 {
	private String productid;
	private String productname;
	private String housename;
	private BigDecimal averagepercost;
	private String brand;
	private String category;
	private String feature1;
	private String feature2;
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
	public String getBrand(){
		return this.brand;
	}
	public String getCategory(){
		return this.category;
	}
	public String getFeature1(){
		return this.feature1;
	}
	public String getFeature2(){
		return this.feature2;
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
	public void setBrand(String brand){
		this.brand=brand;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public void setFeature1(String feature1){
		this.feature1=feature1;
	}
	public void setFeature2(String feature2){
		this.feature2=feature2;
	}
	public void setCreaterid(String createrid){
		this.createrid=createrid;
	}
	public void setHousename(String housename){
		this.housename=housename;
	}
}
