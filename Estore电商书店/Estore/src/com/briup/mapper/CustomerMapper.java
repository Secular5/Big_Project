package com.briup.mapper;

import com.briup.bean.Customer;

/**
 * @author LuHua
 * 客户的映射接口
 */
public interface CustomerMapper {

	//根据用户名查找用户
	Customer findCustomerByName(String name);
	
	//保存用户信息
	void insertCustomer(Customer customer);
	
}
