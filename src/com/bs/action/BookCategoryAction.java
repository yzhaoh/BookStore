package com.bs.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bs.bean.BookCategory;
import com.bs.service.BookCategoryService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理与图书类别相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class BookCategoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分类编号
	 */
	private int categoryId;
	/**
	 * 一级标题
	 */
	private String oneCategory;
	private Map<String, Object> status;
	private List<BookCategory> bookCategory;
	private BookCategoryService bookCategoryService;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getOneCategory() {
		return oneCategory;
	}

	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}

	public Map<String, Object> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Object> status) {
		this.status = status;
	}

	public List<BookCategory> getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(List<BookCategory> bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BookCategoryService getBookCategoryService() {
		return bookCategoryService;
	}

	public void setBookCategoryService(BookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}

	public String getCategory() {
		this.bookCategory = bookCategoryService.get();
		return SUCCESS;
	}

	public String addCategory() {
		this.status = new HashMap<String, Object>();
		BookCategory bookCategory = new BookCategory();
		bookCategory.setOneCategory(oneCategory);
		boolean b = bookCategoryService.add(bookCategory);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String alterCategory() {
		this.status = new HashMap<String, Object>();
		BookCategory bookCategory = new BookCategory();
		bookCategory.setCategoryId(categoryId);
		bookCategory.setOneCategory(oneCategory);
		boolean b = bookCategoryService.alter(bookCategory);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String deleteCategory() {
		this.status = new HashMap<String, Object>();
		boolean b = bookCategoryService.delete(categoryId);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String test() {
		BookCategory category = new BookCategory();
		category.setCategoryId(6);
		category.setOneCategory("生物学");
		boolean b = bookCategoryService.alter(category);
		System.out.println(b);
		return SUCCESS;
	}
}
