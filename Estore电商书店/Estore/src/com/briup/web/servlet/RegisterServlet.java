package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

/**
 * @author LuHua
 * 注册功能
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收前台的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zipCode = request.getParameter("zipCode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		//2.封装成customer对象
		Customer c = new Customer();
		c.setName(name);
		c.setPassword(password);
		c.setZipCode(zipCode);
		c.setTelephone(telephone);
		c.setEmail(email);
		
		//3.调用service完成逻辑处理 给前台返回不同的响应
		ICustomerService service = new CustomerServiceImpl();
		String path = "";
		HttpSession session = request.getSession();
		try {
			service.register(c );
			session.setAttribute("msg", "注册成功,请登陆！");
			//注册成功 返回登陆页面
			path="/WEB-INF/login.jsp";
		} catch (Exception e) {
			session.setAttribute("msg",e.getMessage());
			//注册失败 返回注册页面 将注册失败的提示信息返回
			path="/WEB-INF/register.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
