package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShopCar;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

/**
 * @author LuHua
 * 加入购物车功能
 */
@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收前台传递的参数 id num
		String bookId = request.getParameter("id");
		String num = request.getParameter("num");
		//2.根据书籍id去查找书籍信息
		IBookService service  =  new BookServiceImpl();
		Book book = service.findBookById(Integer.parseInt(bookId));
		//3.封装orderline对象 num book cost
		OrderLine line = new OrderLine();
		line.setBook(book);
		line.setNum(Integer.parseInt(num));
		line.setCost(book.getPrice()*Integer.parseInt(num));
		//4.获取登陆时创建的购物车 
		ShopCar car = (ShopCar)request.getSession().getAttribute("car");
		if(car==null) {
			car = new ShopCar();
		}
		//5.往购物车添加orderline
		car.addCar(line);
		//6.页面跳转 shopCart.jsp
		request.getRequestDispatcher("/WEB-INF/shopCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
