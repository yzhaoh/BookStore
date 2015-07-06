package com.bs.serviceImpl;

import java.util.List;
import com.bs.bean.BookCollection;
import com.bs.dao.BookCollectionDao;
import com.bs.service.BookCollectionService;

/**
 * 图书收藏模块（BookCollectionService）接口实现
 * 
 * @author 若水
 *
 */
public class BookCollectionServiceImpl implements BookCollectionService {

	private BookCollectionDao bookCollectionDao;

	public BookCollectionDao getBookCollectionDao() {
		return bookCollectionDao;
	}

	public void setBookCollectionDao(BookCollectionDao bookCollectionDao) {
		this.bookCollectionDao = bookCollectionDao;
	}

	@Override
	public boolean collection(BookCollection bookCollection) {
		// TODO Auto-generated method stub
		if (bookCollection != null)
			return bookCollectionDao.add(bookCollection);
		return false;
	}

	@Override
	public boolean delete(int userId, int bookId) {
		// TODO Auto-generated method stub
		return bookCollectionDao.delete(userId, bookId);
	}

	@Override
	public List<BookCollection> getCollections(int userId) {
		// TODO Auto-generated method stub
		return bookCollectionDao.select(userId);
	}

}
