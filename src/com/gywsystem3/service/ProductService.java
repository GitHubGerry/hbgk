package com.gywsystem3.service;
import java.math.BigDecimal;
import java.util.List;

import com.gywsystem3.po.Product;


public interface ProductService {
	
	List<Product> selectProduct(String createrid);
	List<Product> JQselect(String createrid,String key,String value);
	List<Product> MHselect(String createrid,String key,String value);
	
	boolean insertProduct(String productid,String productname,BigDecimal apc,String housename,String brand,
			String category,String feature1,String feature2,int quantity,String createrid);
	
	boolean updateProduct(String productname,BigDecimal apc,String housename,String brand,
			String category,String feature1,String feature2,String createrid,String productid);
	
	boolean deleteProduct(String createrid,String productid);



}
