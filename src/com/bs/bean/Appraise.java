package com.bs.bean;

import java.util.Date;

/**
 * 评价模型，对应图书评价表的实体类
 * 
 * @author 若水
 *
 */
public class Appraise {
	/**
	 * 订单编号
	 */
	private int orderId;
	/**
	 * 图书编号
	 */
	private int bookId;
	/**
	 * 星级(1,2,3,4,5)
	 */
	private String starLevel;
	/**
	 * 评价等级(好评，中评，差评)
	 */
	private String appraiseGrade;
	/**
	 * 评价内容
	 */
	private String appraiseContent;
	/**
	 * 商城回复内容
	 */
	private String mallAnswer;
	/**
	 * 评价日期
	 */
	private Date appraiseTime;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 图书
	 */
	private Book book;
	/**
	 * 订单
	 */
	private Order order;

	public Appraise() {

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}

	public String getAppraiseGrade() {
		return appraiseGrade;
	}

	public void setAppraiseGrade(String appraiseGrade) {
		this.appraiseGrade = appraiseGrade;
	}

	public String getAppraiseContent() {
		return appraiseContent;
	}

	public void setAppraiseContent(String appraiseContent) {
		this.appraiseContent = appraiseContent;
	}

	public String getMallAnswer() {
		return mallAnswer;
	}

	public void setMallAnswer(String mallAnswer) {
		this.mallAnswer = mallAnswer;
	}

	public Date getAppraiseTime() {
		return appraiseTime;
	}

	public void setAppraiseTime(Date appraiseTime) {
		this.appraiseTime = appraiseTime;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Appraise [orderId=" + this.orderId + ", bookId=" + this.bookId
				+ ", appraiseContent=" + this.appraiseContent
				+ ", appraiseGrade=" + this.appraiseGrade + ", mallAnswer="
				+ this.mallAnswer + ", starLevel=" + this.starLevel
				+ ", appraiseTime=" + this.appraiseTime + ", book=" + this.book
				+ ", order=" + this.order + ", user=" + this.user + "]";
	}
}
