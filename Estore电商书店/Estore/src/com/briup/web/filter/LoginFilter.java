package com.briup.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;

/**
 * 登陆校验
 */
@WebFilter("/addCar")
public class LoginFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断当前用户是否登陆
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Customer customer = (Customer)session.getAttribute("isLogin");
		if(customer==null) {
			//如果用户没有登陆，那就提示用户，请先登陆，跳转回登陆界面
			session.setAttribute("msg", "请先登陆!");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else {
			//用户登陆了
			//放行 
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
