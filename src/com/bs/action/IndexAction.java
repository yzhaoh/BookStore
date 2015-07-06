package com.bs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bs.bean.Book;
import com.bs.bean.BookCategory;
import com.bs.service.BookCategoryService;
import com.bs.service.BookSalesService;
import com.bs.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理来自主页面的请求
 * 
 * @author 若水
 *
 */
public class IndexAction extends ActionSupport implements ApplicationAware,
		SessionAware {

	private static final long serialVersionUID = 1L;

	private BookCategoryService bookCategoryService;
	private BookSalesService bookSalesService;
	private BookService bookService;
	private List<BookCategory> bookCategory;
	private List<Book> salesTop;
	private List<Book> newBooks;
	private Map<String, Object> application;
	private Map<String, Object> session;

	public BookCategoryService getBookCategoryService() {
		return bookCategoryService;
	}

	public void setBookCategoryService(BookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}

	public BookSalesService getBookSalesService() {
		return bookSalesService;
	}

	public void setBookSalesService(BookSalesService bookSalesService) {
		this.bookSalesService = bookSalesService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public List<BookCategory> getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(List<BookCategory> bookCategory) {
		this.bookCategory = bookCategory;
	}

	public List<Book> getSalesTop() {
		return salesTop;
	}

	public void setSalesTop(List<Book> salesTop) {
		this.salesTop = salesTop;
	}

	public List<Book> getNewBooks() {
		return newBooks;
	}

	public void setNewBooks(List<Book> newBooks) {
		this.newBooks = newBooks;
	}

	public Map<String, Object> getApplication() {
		return application;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getIndex() {
		this.newBooks = bookService.getNewBooks(9);
		this.application.put("bookCategory", bookCategoryService.get());
		this.application.put("salesTop", bookSalesService.getSalesTop(10));
		return SUCCESS;
	}

	public String backIndex() {
		Object admin = this.getSession().get("admin");
		if (admin != null && admin.toString().equals("若水")) {
			return SUCCESS;
		}
		return ERROR;
	}

}
