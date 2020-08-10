package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

public interface IBookService {
	//查找前三本书
	List<Book> findFirstThreeBooks();
	//查找后六本书
	List<Book> findLastSixBooks();
	
	Book findBookById(int id);
}

