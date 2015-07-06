package com.bs.bean;

import java.util.List;

/**
 * 图书分类模型，对应图书分类表的实体类
 * 
 * @author 若水
 *
 */
public class BookCategory {
	/**
	 * 分类编号
	 */
	private int categoryId;
	/**
	 * 一级标题
	 */
	private String oneCategory;
	/**
	 * 该分类下的图书集合
	 */
	private List<Book> books;

	public BookCategory() {

	}

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public int getBookNumber(){
		return this.getBooks().size();
	}

	@Override
	public String toString() {
		return "BookCategory [categoryId=" + this.categoryId + ", oneCategory="
				+ this.oneCategory + ", books=" + this.books + "]";
	}
}
