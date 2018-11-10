package com.gywsystem3.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gywsystem3.po.User;

public interface UserMapper {
	@Select("select * from users where userid=#{userid} and password=#{password}")
	User login(@Param("userid")String userid,@Param("password")String password);
}
