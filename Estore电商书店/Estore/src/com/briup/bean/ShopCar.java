package com.briup.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author LuHua
 * 购物车对象
 */
public class ShopCar {
	
	//key值代表的是书籍的id
	//value值代表的是orderline
	private Map<Integer, OrderLine> map = new HashMap<>();
	
	//添加购物车项
	public void addCar(OrderLine line) {
		/**
		 * 判断到底该购物车项是第一次添加还是不是第一次添加
		 */
		Integer bookId = line.getBook().getId();
		//包含 不是第一次添加该购物车项
		if(map.containsKey(bookId)) {
			//map集合中的旧值
			OrderLine orderLine = map.get(bookId);
			//修改数量
			Integer oldnum = orderLine.getNum();
			oldnum+=line.getNum();
			//修改小计
			Double cost = orderLine.getCost();
			cost+=line.getCost();
		}else{
			map.put(bookId, line);
		}
	}
	
	//返回购物车中的所有数据
	public Map<Integer, OrderLine> getOrderLines(){
		return map;
	}
	
	//获取购物城中的商品件数
	public int getSize() {
		return map.size();
	}
	
	//获取购物车中的总价格
	public Double getCost() {
		Set<Integer> key = map.keySet();
		double sum = 0.0;
		for(Integer i:key) {
			OrderLine orderLine = map.get(i);
			sum+=orderLine.getCost();
		}
		return sum;
	}
}
