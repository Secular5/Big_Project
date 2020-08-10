package com.briup.mapper;

import java.util.List;

import com.briup.bean.OrderForm;

/**
 * @author LuHua
 * 订单的映射接口
 */
public interface OrderFormMapper {
	
	void insertOrderForm(OrderForm form);
	
	List<OrderForm> findOrderFormWithShopAddress();
}
