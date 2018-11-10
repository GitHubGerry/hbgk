package com.gywsystem3.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gywsystem3.po.Buyer;

public interface BuyerMapper {
	@Select("select * from buyer where createrid=#{createrid}")
	List<Buyer> selectBuyer(String createrid);

	@Insert("insert into buyer values(#{buyerid},#{companyname},#{linkman1},#{tele1},#{linkman2},#{tele2},#{wechat},#{volume},#{app},#{createrid},#{lpp})")
	boolean insertBuyer(@Param("buyerid")String buyerid,@Param("companyname")String companyname,@Param("linkman1")String linkman1,@Param("tele1")String tele1,
			@Param("linkman2")String linkman2,@Param("tele2")String tele2,@Param("wechat")String wechat,@Param("volume")int volume,@Param("app")String app,
			@Param("createrid")String createrid,@Param("lpp")String lpp);
	
	@Update("update buyer set companyname=#{companyname},linkman1=#{linkman1},tele1=#{tele1},linkman2=#{linkman2},tele2=#{tele2},wechat=#{wechat} where createrid=#{createrid} and buyerid=#{buyerid}")
	boolean updateBuyer(@Param("companyname")String companyname,@Param("linkman1")String linkman1,@Param("tele1")String tele1,
			@Param("linkman2")String linkman2,@Param("tele2")String tele2,@Param("wechat")String wechat,@Param("createrid")String createrid,@Param("buyerid")String buyerid);
	
	@Delete("delete buyer where createrid=#{createrid} and buyerid=#{buyerid}")
	boolean deleteBuyer(@Param("createrid")String createrid,@Param("buyerid")String buyerid);
	
}
