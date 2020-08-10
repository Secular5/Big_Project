package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.bean.ShopAddress;
import com.briup.service.IShopAddressService;
import com.briup.service.impl.ShopAddressServiceImpl;
/**
 * @author LuHua
 * 收货地址的保存
 */
@WebServlet("/addAddress")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收前台的新增收货地址
		String receiveName = request.getParameter("receiveName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2.获取当前登陆系统的用户
		Customer c = (Customer)request.getSession().getAttribute("isLogin");
		
		//3.封装收货地址对象
		ShopAddress shopAddress = new ShopAddress(receiveName, address, phone, c);
		
		//4.保存收货地址
		IShopAddressService service = new ShopAddressServiceImpl();
		service.saveShopAddress(shopAddress);
		
		//5.跳转回confirm.jsp页面-- 查找出所有的收货地址信息---这个操作confirmServlet写过了
		request.getRequestDispatcher("/confirm").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
