package com.gywsystem3.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.mapper.ProductMapper;
import com.gywsystem3.po.Product;
import com.gywsystem3.service.ProductService;


@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper pm;
	
	
	public List<Product> selectProduct(String createrid){
		return pm.selectProduct(createrid);
	}
	
	public List<Product> JQselect(String createrid,String key,String value){
		//System.out.println(createrid+key+value);
		return pm.JQselect(createrid, key, value);
	}
	
	public List<Product> MHselect(String createrid,String key,String value){
		//System.out.println(createrid+key+value);
		return pm.MHselect(createrid, key, value);
	}
	
	public boolean insertProduct(String productid,String productname,BigDecimal apc,String housename,String brand,
			String category,String feature1,String feature2,int quantity,String createrid){
		return pm.insertProduct(productid, productname, apc, housename, brand, category, feature1, feature2, quantity, createrid);
	}
	
	public boolean updateProduct(String productname,BigDecimal apc,String housename,String brand,
			String category,String feature1,String feature2,String createrid,String productid){
		return pm.updateProduct(productname, apc, housename, brand, category, feature1, feature2, createrid, productid);
	}
	
	public boolean deleteProduct(String createrid,String productid){
		return pm.deleteProduct(createrid, productid);
	}
}
