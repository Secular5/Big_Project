package com.briup.mapper;

import java.util.List;

import com.briup.bean.Book;

public interface BookMapper {
	// 查找前三本书
	List<Book> findFirstThreeBooks();
	// 查找后六本书
	List<Book> findLastSixBooks(int count);
	
	int count();
	
	Book findBookById(int id);
}
