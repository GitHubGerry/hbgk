package com.gywsystem3.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import com.gywsystem3.po.Supplier;

public interface SupplierMapper {
	@Select("select * from supplier where createrid=#{createrid} order by supplierid")
	List<Supplier> selectSupplier(String createrid);
	
	@Insert("insert into supplier values(#{supplierid},#{companyname},#{linkman1},#{tele1},#{linkman2},#{tele2},#{wechat},#{volume},#{createrid})")
	boolean insertSupplier(@Param("supplierid")String supplierid,@Param("companyname")String companyname,@Param("linkman1")String linkman1,@Param("tele1")String tele1,
			@Param("linkman2")String linkman2,@Param("tele2")String tele2,@Param("wechat")String wechat,@Param("volume")int volume,@Param("createrid")String createrid);
	
	@Update("update supplier set companyname=#{companyname},linkman1=#{linkman1},tele1=#{tele1},linkman2=#{linkman2},tele2=#{tele2},wechat=#{wechat} where createrid=#{createrid} and supplierid=#{supplierid}")
	boolean updateSupplier(@Param("companyname")String companyname,@Param("linkman1")String linkman1,@Param("tele1")String tele1,
			@Param("linkman2")String linkman2,@Param("tele2")String tele2,@Param("wechat")String wechat,@Param("createrid")String createrid,@Param("supplierid")String supplierid);
	
	@Delete("delete supplier where createrid=#{createrid} and supplierid=#{supplierid}")
	boolean deleteSupplier(@Param("createrid")String createrid,@Param("supplierid")String supplierid);

}
