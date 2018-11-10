package com.gywsystem3.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.mapper.BuyerMapper;
import com.gywsystem3.po.Buyer;
import com.gywsystem3.service.BuyerService;

@Service("buyerService")
public class BuyerServiceImpl implements BuyerService{
	@Autowired
	private BuyerMapper bm;
	
	public List<Buyer> selectBuyer(String createrid){
		return bm.selectBuyer(createrid);
	}
	public boolean insertBuyer(String buyerid,String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,int volume,String app,String createrid,String lpp){
		return bm.insertBuyer(buyerid, companyname, linkman1, tele1, linkman2, tele2, wechat, volume, app, createrid,lpp);
	}
	public boolean updateBuyer(String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,String createrid,String buyerid){
		return bm.updateBuyer(companyname, linkman1, tele1, linkman2, tele2, wechat, createrid, buyerid);
	}
	public boolean deleteBuyer(String createrid,String buyerid){
		return bm.deleteBuyer(createrid, buyerid);
	}


}
