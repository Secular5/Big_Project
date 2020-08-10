package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.service.IOrderFormService;
import com.briup.service.impl.OrderFormServiceImpl;

/**
 * 订单列表功能
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //1.获取保存订单时所需要的信息
	  //cost 当前日期  shopAddress_id  customer_id(登陆系统的用户)
		ShopCar car = (ShopCar)request.getSession().getAttribute("car");
		String shopAdId = request.getParameter("shipAddId");
		Customer c = (Customer)request.getSession().getAttribute("customer");
		
		ShopAddress address = new ShopAddress();
		address.setId(Integer.parseInt(shopAdId));
		
		OrderForm form =
					new OrderForm(car.getCost(), new Date(), c, address);
	 
	  //2.保存订单信息
		IOrderFormService service  = new OrderFormServiceImpl();
		service.saveOrderForm(form);
		
	  //3.查询出所有的订单信息
		List<OrderForm> orderForm = service.getOrderForm();
		request.getSession().setAttribute("orderForm", orderForm);
	
	  //4.跳转到orderlist.jsp页面 显示订单数据
		request.getRequestDispatcher("/WEB-INF/orderlist.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
