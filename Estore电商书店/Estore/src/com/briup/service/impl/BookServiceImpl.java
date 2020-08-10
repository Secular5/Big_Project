package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.mapper.BookMapper;
import com.briup.service.IBookService;
import com.briup.util.GetSqlSession;

public class BookServiceImpl implements IBookService{

	@Override
	public List<Book> findFirstThreeBooks() {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		return mapper.findFirstThreeBooks();
	}

	@Override
	public List<Book> findLastSixBooks() {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		int count = mapper.count();
		return mapper.findLastSixBooks(count);
	}

	@Override
	public Book findBookById(int id) {
		SqlSession session = GetSqlSession.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.findBookById(id);
	}

}
