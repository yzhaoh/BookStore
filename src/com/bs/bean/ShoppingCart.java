package com.bs.bean;

import java.io.Serializable;

/**
 * 购物车模型，对应购物车表的实体类
 * 
 * @author 若水
 *
 */
public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 图书编号
	 */
	private int bookId;
	/**
	 * 购买数量
	 */
	private int number;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 图书
	 */
	private Book book;

	public ShoppingCart() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "ShoppingCart [userId=" + this.userId + ", bookId=" + this.bookId
				+ ", number=" + this.number + ", user=" + this.user + ", book="
				+ this.book + "]";
	}
}
