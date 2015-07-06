package com.bs.bean;

/**
 * 图书收藏模型，对应图书收藏表的实体类
 * 
 * @author 若水
 *
 */
public class BookCollection {
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 图书编号
	 */
	private int bookId;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 图书
	 */
	private Book book;

	public BookCollection() {

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
		return "BookCollection [bookId=" + this.bookId + ", userId="
				+ this.userId + ", book=" + this.book + ", user=" + this.user
				+ "]";
	}

}
