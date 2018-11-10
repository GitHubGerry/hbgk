package com.gywsystem3.service;
import java.util.List;
import com.gywsystem3.po.Buyer;

public interface BuyerService {
	List<Buyer> selectBuyer(String createrid);
	boolean insertBuyer(String buyerid,String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,int volume,String app,String createrid,String lpp);
	boolean updateBuyer(String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,String createrid,String buyerid);
	boolean deleteBuyer(String createrid,String buyerid);
	
	
}
