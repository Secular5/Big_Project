package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.ShopAddress;
import com.briup.mapper.ShopAddressMapper;
import com.briup.service.IShopAddressService;
import com.briup.util.GetSqlSession;

/**
 * @author LuHua
 * 收货地址逻辑层实现类
 */ 
public class ShopAddressServiceImpl implements IShopAddressService{

	@Override
	public List<ShopAddress> getShopAddressByCid(int id) {
		SqlSession sqlSession = GetSqlSession.openSession();
		ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
		return mapper.findShopAddressByCId(id);
	}

	@Override
	public void saveShopAddress(ShopAddress address) {
		SqlSession sqlSession = GetSqlSession.openSession();
		ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
		mapper.insertShopAddress(address);
		sqlSession.commit();
	}

}
