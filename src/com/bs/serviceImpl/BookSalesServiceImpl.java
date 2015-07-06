package com.bs.serviceImpl;

import java.util.List;
import com.bs.bean.Book;
import com.bs.bean.BookSales;
import com.bs.dao.BookSalesDao;
import com.bs.service.BookSalesService;

/**
 * 图书库存、销售模块（BookSalesService）接口实现
 * 
 * @author 若水
 *
 */
public class BookSalesServiceImpl implements BookSalesService {

	private BookSalesDao bookSalesDao;

	public BookSalesDao getBookSalesDao() {
		return bookSalesDao;
	}

	public void setBookSalesDao(BookSalesDao bookSalesDao) {
		this.bookSalesDao = bookSalesDao;
	}

	@Override
	public boolean alterInventory(int bookId, int nowNumber) {
		// TODO Auto-generated method stub
		return bookSalesDao.update(bookId, nowNumber);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return bookSalesDao.selectCount();
	}

	@Override
	public List<BookSales> getBookSales(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return bookSalesDao.select((pageNow - 1) * pageSize, pageSize);
	}

	@Override
	public int getKeyTotal(String keyword) {
		// TODO Auto-generated method stub
		if (keyword != null) {
			return bookSalesDao.selectKeyCount(keyword);
		}
		return 0;
	}

	@Override
	public List<BookSales> getBookSales(String salesKeywords, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		if (salesKeywords != null) {
			return bookSalesDao.select(salesKeywords, (pageNow - 1) * pageSize,
					pageSize);
		}
		return null;
	}

	@Override
	public List<Book> getSalesTop(int number) {
		// TODO Auto-generated method stub
		return bookSalesDao.selectSalesTop(number);
	}

}
