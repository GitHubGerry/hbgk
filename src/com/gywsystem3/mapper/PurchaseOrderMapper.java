package com.gywsystem3.mapper;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gywsystem3.po.PurchaseOrder;

public interface PurchaseOrderMapper {
	
	@Select("select b.housename,a.orderid,'('+a.productid+')  '+b.productname as productid,'('+a.supplierid+')  '+c.companyname as supplierid,"
		+"a.perprice,a.quantity,a.orderdate,a.createrid,a.amount from purchaseOrder a "
		+"join products b on a.productid=b.productid join supplier c on a.supplierid=c.supplierid where a.createrid=#{createrid} order by a.orderid")
	List<PurchaseOrder> selectPurchaseOrder(String createrid);
	
	@Insert("insert into purchaseorder(orderid,productid,supplierid,perprice,quantity,orderdate,createrid,amount) values (#{orderid},#{productid}"
			+ ",#{supplierid},#{perprice},#{quantity},#{orderdate},#{createrid},#{amount})")
	boolean insertPurchaseOrder(@Param("orderid")String orderid,@Param("productid")String productid,@Param("supplierid")String supplierid,@Param("perprice")BigDecimal perprice,
			@Param("quantity")int quantity,@Param("orderdate")Date orderdate,@Param("createrid")String createrid,@Param("amount")BigDecimal amount);

	
	@Update("update supplier set volume=volume+1 where createrid=#{createrid} and supplierid=#{supplierid}")
	boolean addVolume(@Param("createrid")String createrid,@Param("supplierid")String supplierid);
	
	//��ô����sql�����ƽ�������أ����㵫������ ȷ��һ����Ʒ����Ҫhousename����һ��product����һ����Ʒ���ܷ������ֿ⣬������bug��
	@Update("declare @cost decimal,@q int select @cost=averagepercost,@q=quantity from products where createrid=#{createrid} and housename=#{housename} and productid=#{productid}"
			+ " update products set averagePerCost=(@cost*@q+#{percost}*#{quantity})/(@q+#{quantity}),quantity=@q+#{quantity} where createrid=#{createrid} and housename=#{housename} and productid=#{productid}")
	boolean updateCQ(@Param("createrid")String createrid,@Param("productid")String productid,@Param("housename")String housename,@Param("percost")BigDecimal percost,@Param("quantity")int quantity);
}
