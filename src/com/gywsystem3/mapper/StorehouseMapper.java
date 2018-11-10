package com.gywsystem3.mapper;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gywsystem3.po.Storehouse;

public interface StorehouseMapper {
	@Select("select * from storehouse where createrid=#{createrid} or managerid=#{createrid}")
	List<Storehouse> selectStorehouse(String createrid);
	
	@Insert("insert into storehouse(housename,createrid,managerid,on_off,createdate) values(#{housename},#{createrid},#{managerid},"
			+ "#{on_off},#{createdate})")
	boolean insertStorehouse(@Param("housename")String housename,@Param("createrid")String createrid,@Param("managerid")String managerid,
			@Param("on_off")String on_off,@Param("createdate")Date createdate);
	
	@Update("update storehouse set housename=#{housename},managerid=#{managerid},on_off=#{on_off} where createrid=#{createrid} "
			+ "and housename=#{housename0}")
	boolean updateStorehouse(@Param("housename")String housename,@Param("createrid")String createrid,@Param("managerid")String managerid,
			@Param("on_off")String on_off,@Param("housename0")String housename0);
	
	@Delete("delete storehouse where createrid=#{createrid} and housename=#{housename}")
	boolean deleteStorehouse(@Param("createrid")String createrid,@Param("housename")String housename);

}
