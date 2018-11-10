package com.gywsystem3.service;
import java.util.List;
import com.gywsystem3.po.Supplier;

public interface SupplierService {
	List<Supplier> selectSupplier(String createrid);
	boolean insertSupplier(String supplierid,String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,int volume,String createrid);
	boolean updateSupplier(String companyname,String linkman1,String tele1,String linkman2,String tele2,String wechat,String createrid,String supplierid);
	boolean deleteSupplier(String createrid,String supplierid);

}
