package com.bs.bean;

import java.util.Date;

/**
 * 图书销售模型，对应图书销售表的实体类
 * 
 * @author 若水
 *
 */
public class BookSales {
	/**
	 * 图书编号
	 */
	private int bookId;
	/**
	 * 已售数量
	 */
	private int soldNumber;
	/**
	 * 现存数量
	 */
	private int nowNumber;
	/**
	 * 上架时间
	 */
	private Date salesTime;
	/**
	 * 图书
	 */
	private Book book;

	public BookSales() {

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSoldNumber() {
		return soldNumber;
	}

	public void setSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}

	public int getNowNumber() {
		return nowNumber;
	}

	public void setNowNumber(int nowNumber) {
		this.nowNumber = nowNumber;
	}

	public Date getSalesTime() {
		return salesTime;
	}

	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookSales [bookId=" + this.bookId + ", nowNumber="
				+ this.nowNumber + ", soldNumber=" + this.soldNumber
				+ ", salesTime=" + this.salesTime + " book=" + this.book + "]";
	}
}
