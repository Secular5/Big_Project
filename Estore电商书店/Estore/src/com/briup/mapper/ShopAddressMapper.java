package com.briup.mapper;

import java.util.List;

import com.briup.bean.ShopAddress;

/**
 * @author LuHua
 * 收货地址的映射接口
 */
public interface ShopAddressMapper {
	
	List<ShopAddress> findShopAddressByCId(int id);
	
	void insertShopAddress(ShopAddress address);
	
}
