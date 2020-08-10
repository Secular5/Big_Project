package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.mapper.CategoryMapper;
import com.briup.service.ICategoryService;
import com.briup.util.GetSqlSession;
/**
 * 书籍逻辑实现层
 * @author LuHua
 *
 */
public class CategoryServiceImpl implements ICategoryService{

	@Override
	public List<Category> findCategories() {
		//调用dao层去查询分类信息
		SqlSession session = GetSqlSession.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		return mapper.findCategories();
	}

}
