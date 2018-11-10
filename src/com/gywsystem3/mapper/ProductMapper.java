package com.gywsystem3.mapper;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gywsystem3.po.Product;
public interface ProductMapper {
	@Select("select * from products where createrid=#{createrid} order by productid")
	List<Product> selectProduct(@Param("createrid")String createrid);
	
	@Select("select * from products where createrid=#{createrid} and ${key}=#{value} order by productid")
	List<Product> JQselect(@Param("createrid")String createrid,@Param("key")String key,@Param("value")String value);
	
	@Select("select * from products where createrid=#{createrid} and ${key} like '%'+#{value}+'%' order by productid")
	List<Product> MHselect(@Param("createrid")String createrid,@Param("key")String key,@Param("value")String value);
	
	@Insert("insert into products values(#{productid},#{productname},#{apc},#{housename},#{brand},#{category},#{feature1},#{feature2},#{quantity},#{createrid})")
	boolean insertProduct(@Param("productid")String productid,@Param("productname")String productname,@Param("apc")BigDecimal apc,@Param("housename")String housename,@Param("brand")String brand,
			@Param("category")String category,@Param("feature1")String feature1,@Param("feature2")String feature2,@Param("quantity")int quantity,@Param("createrid")String createrid);
	
	@Update("update products set productname=#{productname},averagePerCost=#{apc},housename=#{housename},brand=#{brand},category=#{category},"
			+ "feature1=#{feature1},feature2=#{feature2} where createrid=#{createrid} and productid=#{productid}")
	boolean updateProduct(@Param("productname")String productname,@Param("apc")BigDecimal apc,@Param("housename")String housename,@Param("brand")String brand,@Param("category")String category,
			@Param("feature1")String feature1,@Param("feature2")String feature2,@Param("createrid")String createrid,@Param("productid")String productid);

	@Delete("delete products where createrid=#{createrid} and productid=#{productid}")
	boolean deleteProduct(@Param("createrid")String createrid,@Param("productid")String productid);
}
