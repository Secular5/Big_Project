package com.briup.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.service.impl.BookServiceImpl;
import com.briup.service.impl.CategoryServiceImpl;

@WebListener
public class IndexListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
    //监听application对象的创建
    //服务器启动的时候就会调用
    public void contextInitialized(ServletContextEvent sce)  { 
    	//1.调用分类逻辑层获取分类数据
    	ICategoryService categoryService = new CategoryServiceImpl();
    	List<Category> categories = categoryService.findCategories();
    	//2.将查询出来的分类信息保存在application中
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("categories", categories);
    	
    	BookServiceImpl bookService = new BookServiceImpl();
    	List<Book> book1 = bookService.findFirstThreeBooks();
    	List<Book> book2 = bookService.findLastSixBooks();
    	
    	application.setAttribute("book1", book1);
    	application.setAttribute("book2", book2);
    }
	
}
