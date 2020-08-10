package com.briup.service;

import java.util.List;

import com.briup.bean.ShopAddress;

/**
 * 
 * @author LuHua
 * 收货地址逻辑层接口
 */
public interface IShopAddressService {
	
	List<ShopAddress> getShopAddressByCid(int id);
	
	void saveShopAddress(ShopAddress address);

}
