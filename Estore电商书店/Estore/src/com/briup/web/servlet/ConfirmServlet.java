package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

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
 * 购物车提交功能
 */
@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询当前用户所对应的所有收货地址
		//1.获取当前登陆系统的用户的id
		 Customer c = (Customer)request.getSession().getAttribute("isLogin");
		 System.out.println(c);
		 //2.根据用户id去查询该用户所对应的所有收货地址 
		 IShopAddressService service = new ShopAddressServiceImpl(); 
		 List<ShopAddress> shopaddresses = service.getShopAddressByCid(c.getId());
		 //3.保存收货地址 
		 request.getSession().setAttribute("shopaddresses", shopaddresses);
		 
		//4.跳转到confirm.jsp页面
		request.getRequestDispatcher("/WEB-INF/confirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
