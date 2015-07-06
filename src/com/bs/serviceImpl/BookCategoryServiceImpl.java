package com.bs.serviceImpl;

import java.util.List;
import com.bs.bean.BookCategory;
import com.bs.dao.BookCategoryDao;
import com.bs.service.BookCategoryService;

/**
 * 图书类别模块（BookCategoryService）接口实现
 * 
 * @author 若水
 *
 */
public class BookCategoryServiceImpl implements BookCategoryService {

	private BookCategoryDao bookCategoryDao;

	public BookCategoryDao getBookCategoryDao() {
		return bookCategoryDao;
	}

	public void setBookCategoryDao(BookCategoryDao bookCategoryDao) {
		this.bookCategoryDao = bookCategoryDao;
	}

	@Override
	public boolean add(BookCategory category) {
		// TODO Auto-generated method stub
		if (category != null)
			return bookCategoryDao.insert(category);
		return false;
	}

	@Override
	public boolean alter(BookCategory category) {
		// TODO Auto-generated method stub
		if (category != null)
			return bookCategoryDao.update(category);
		return false;
	}

	@Override
	public List<BookCategory> get() {
		// TODO Auto-generated method stub
		return bookCategoryDao.select();
	}

	@Override
	public boolean delete(int categoryId) {
		// TODO Auto-generated method stub
		return bookCategoryDao.delete(categoryId);
	}

	@Override
	public int getCount(int categoryId) {
		// TODO Auto-generated method stub
		return bookCategoryDao.selectCount(categoryId);
	}

}
