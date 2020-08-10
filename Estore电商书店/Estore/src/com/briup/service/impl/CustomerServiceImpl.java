package com.briup.service.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.mapper.CustomerMapper;
import com.briup.service.ICustomerService;
import com.briup.util.GetSqlSession;

/**
 * @author LuHua 客户逻辑层
 */
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void register(Customer customer) throws Exception {
		// 判断用户名重复还是不重复
		// 调用dao完成用户名的查找
		try {
			// 获取sqlSession
			SqlSession session = GetSqlSession.openSession();
			CustomerMapper mapper = session.getMapper(CustomerMapper.class);
			Customer c = mapper.findCustomerByName(customer.getName());
			if (c != null) {
				throw new Exception("用户名重复，请重新注册!");
			}
			// 将用户信息保存
			mapper.insertCustomer(customer);
			// 提交
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Customer login(String name, String password) throws Exception {
		if (name == null && "".equals(name)) {
			throw new RuntimeException("用户名或者密码为空");
		}

		Customer customer = findByName(name);
		if (customer == null) {
			throw new Exception("用户名错误");
		}
		if (password.equals(customer.getPassword())) {
			return customer;
		}
		throw new Exception("密码错误");
	}

	public Customer findByName(String name) throws Exception {

		// 获取sqlSession
		SqlSession session = GetSqlSession.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		Customer customer = mapper.findCustomerByName(name);
		return customer;

	}

}
