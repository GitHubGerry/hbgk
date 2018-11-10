package com.gywsystem3.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gywsystem3.po.SalesOrder;

public interface SalesOrderMapper {
	
	@Select("select b.housename,a.orderid,'('+a.productid+')  '+b.productname as productid,'('+a.buyerid+')  '+c.companyname as buyerid,"
			+"a.perprice,a.quantity,a.orderdate,a.createrid,a.amount from salesOrder a "
			+"join products b on a.productid=b.productid join buyer c on a.buyerid=c.buyerid where a.createrid=#{createrid} order by a.orderid")
	List<SalesOrder> selectBuyerOrder(String createrid);
	
	@Insert("insert into salesorder(orderid,productid,buyerid,perprice,quantity,orderdate,createrid,amount) values (#{orderid},#{productid}"
			+ ",#{buyerid},#{perprice},#{quantity},#{orderdate},#{createrid},#{amount})")
	boolean insertPurchaseOrder(@Param("orderid")String orderid,@Param("productid")String productid,@Param("buyerid")String buyerid,@Param("perprice")BigDecimal perprice,
			@Param("quantity")int quantity,@Param("orderdate")Date orderdate,@Param("createrid")String createrid,@Param("amount")BigDecimal amount);
	
	@Select("select CAST(quantity AS varchar)+';'+CAST(averagepercost AS varchar) from products where createrid=#{createrid} and productid=#{productid}")
	String selectProductQuantity(@Param("productid")String productid,@Param("createrid")String createrid);
	
	//权重是什么？是交易次数还是交易数量。应该是后者。新app=旧app*旧数量+lpp*本次数量/旧数量+本次数量       ,lpp=售卖单价-产品单价/产品单价          算app用了三个cast 第一次将旧app转化为小数(几位无所谓)，第二次将计算结果转化为2位小数，第三次将计算结果转化为字符。
	@Update("declare @q1 int select @q1=SUM(quantity) from salesOrder where buyerid=#{buyerid} group by buyerid update buyer set volume=volume+1,averageprofitpercent=Cast(Cast((Cast(substring(averageProfitPercent,1,LEN(averageProfitPercent)-1) as numeric(12,5))*@q1+#{lpp}*#{quantity})/(@q1+#{quantity}) as numeric(12,2)) as varchar)+'%',"
			+"lastprofitpercent=Cast(Cast(#{lpp} as numeric(12,2)) as varchar)+'%' where createrid=#{createrid} and buyerid=#{buyerid}")
	boolean SOupdateBuyer(@Param("lpp")String lpp,@Param("quantity")int quantity,@Param("createrid")String createrid,@Param("buyerid")String buyerid);
	
	@Update("update products set quantity=quantity-#{quantity} where createrid=#{createrid} and productid=#{productid}")
	boolean SOupdateProducts(@Param("quantity")int quantity,@Param("createrid")String createrid,@Param("productid")String productid);
}
