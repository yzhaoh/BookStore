package com.bs.serviceImpl;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.bs.bean.Book;
import com.bs.bean.BookSales;
import com.bs.dao.BookDao;
import com.bs.dao.BookSalesDao;
import com.bs.dao.UserDao;
import com.bs.service.BookService;

/**
 * 图书管理模块（BookService）接口实现
 * 
 * @author 若水
 *
 */
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	private BookSalesDao bookSalesDao;
	private UserDao userDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public BookSalesDao getBookSalesDao() {
		return bookSalesDao;
	}

	public void setBookSalesDao(BookSalesDao bookSalesDao) {
		this.bookSalesDao = bookSalesDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		if (book != null) {
			int bookId = bookDao.insert(book);
			BookSales bookSales = book.getBookSales();
			bookSales.setBookId(bookId);
			bookSales.setSalesTime(new Date());
			bookSales.setSoldNumber(0);
			bookSalesDao.insert(bookSales);
			return true;
		}
		return false;
	}

	@Override
	public boolean alter(Book book) {
		// TODO Auto-generated method stub
		if (book != null)
			return bookDao.update(book);
		return false;
	}

	@Override
	public boolean delete(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.delete(bookId);
	}

	@Override
	public List<Book> order(String orderKeywords, String order, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> order(String orderKeywords, String order, int pageNow,
			int pageSize, int categoryId) {
		// TODO Auto-generated method stub
		if (orderKeywords != null && order != null && order.equals("asc")) {
			switch (orderKeywords) {
			case "sales":
				return bookDao.selectBookBySalesASC(categoryId, (pageNow - 1)
						* pageSize + 1, pageSize);
			case "price":
				return bookDao.selectBookByPriceASC(categoryId, (pageNow - 1)
						* pageSize + 1, pageSize);
			case "appraise":
				return bookDao.selectBookByAppraiseASC(categoryId,
						(pageNow - 1) * pageSize + 1, pageSize);
			default:
				break;
			}
		} else if (order.equals("desc")) {
			switch (orderKeywords) {
			case "sales":
				return bookDao.selectBookBySalesDESC(categoryId, (pageNow - 1)
						* pageSize + 1, pageSize);
			case "price":
				return bookDao.selectBookByPriceDESC(categoryId, (pageNow - 1)
						* pageSize + 1, pageSize);
			case "appraise":
				return bookDao.selectBookByAppraiseDESC(categoryId,
						(pageNow - 1) * pageSize + 1, pageSize);
			default:
				break;
			}
		}
		return null;
	}

	@Override
	public List<Book> getBooks(int categoryId, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		if (categoryId == -1) {
			return bookDao.select((pageNow - 1) * pageSize + 1, pageSize);
		}
		return bookDao.select(categoryId, (pageNow - 1) * pageSize + 1,
				pageSize);
	}

	@Override
	public List<Book> getBooks(String bookKeywords, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return bookDao.select(bookKeywords, (pageNow - 1) * pageSize + 1,
				pageSize);
	}

	@Override
	public List<Book> getBooks(String bookKeywords, String orderKeywords,
			String order, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		if (bookKeywords != null && orderKeywords != null && order != null
				&& order.equals("asc")) {
			switch (orderKeywords) {
			case "sales":
				return bookDao.selectBookBySalesASC(bookKeywords, (pageNow - 1)
						* pageSize + 1, pageSize);
			case "price":
				return bookDao.selectBookByPriceASC(bookKeywords, (pageNow - 1)
						* pageSize + 1, pageSize);
			case "appraise":
				return bookDao.selectBookByAppraiseASC(bookKeywords,
						(pageNow - 1) * pageSize + 1, pageSize);
			default:
				break;
			}
		} else if (order.equals("desc")) {
			switch (orderKeywords) {
			case "sales":
				return bookDao.selectBookBySalesDESC(bookKeywords,
						(pageNow - 1) * pageSize + 1, pageSize);
			case "price":
				return bookDao.selectBookByPriceDESC(bookKeywords,
						(pageNow - 1) * pageSize + 1, pageSize);
			case "appraise":
				return bookDao.selectBookByAppraiseDESC(bookKeywords,
						(pageNow - 1) * pageSize + 1, pageSize);
			default:
				break;
			}
		}
		return null;
	}

	@Override
	public List<Book> getNewBooks(int number) {
		// TODO Auto-generated method stub
		return bookSalesDao.selectSalesTimeTop(number);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return bookDao.selectCount();
	}

	@Override
	public boolean alter(int bookId, String image) {
		// TODO Auto-generated method stub
		return bookDao.update(bookId, image);
	}

	@Override
	public int getKeyTotal(String keyword) {
		// TODO Auto-generated method stub
		if (keyword != null) {
			return bookDao.selectKeyCount(keyword);
		}
		return 0;
	}

	@Override
	public Book get(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.select(String.valueOf(bookId));
	}

}
