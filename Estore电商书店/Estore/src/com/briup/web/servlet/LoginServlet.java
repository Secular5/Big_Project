package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.ShopCar;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {// 将数据传送给service
		ICustomerService service = new CustomerServiceImpl();
		Customer customer = service.login(name, password);
		//创建购物车对象
		ShopCar car = new ShopCar();
		session.setAttribute("car", car);
		// 登陆成功 将登陆的数据存入session中
		session.setAttribute("isLogin", customer);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}catch (Exception e) {
			session.setAttribute("msg", "登陆失败:" + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
