package com.briup.service;

import com.briup.bean.Customer;

/**
 * @author LuHua
 * 客户逻辑层接口
 */
public interface ICustomerService {
	
	//注册功能
	void register(Customer customer) throws Exception;
	//登录功能
	Customer login(String name,String password) throws Exception;
}
