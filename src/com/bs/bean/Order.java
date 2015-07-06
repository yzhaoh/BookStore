package com.bs.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单模型，对应订单基本信息表（orderbasic）的实体类 此处将orderbasic，orderdetail表映射为一个Order实体类，
 * 不再映射订单详细信息表（orderdetail）的实体类， 通过Order对象的book属性可以获得订单详细信息表（orderdetail）的所有字段
 * 
 * @author 若水
 *
 */
public class Order {
	/**
	 * 订单编号
	 */
	private int orderId;
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 收货地址编号
	 */
	private int addressId;
	/**
	 * 订单日期
	 */
	private Date orderDate;
	/**
	 * 是否付款
	 */
	private String ispayed;
	/**
	 * 付款方式
	 */
	private String paymode;
	/**
	 * 总价
	 */
	private float totalprice;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 收货地址
	 */
	private DeliveryAddress deliveryAddress;
	/**
	 * 图书购买清单,map中key为“bookId(图书编号)、number(数量)”、bookName(书名)、currentPrice（现价），value为对应的值
	 */
	private List<Map<String, Integer>> book;
	/**
	 * 该订单的所有评价信息
	 */
	private List<Appraise> appraise;

	public Order() {

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getIspayed() {
		return ispayed;
	}

	public void setIspayed(String ispayed) {
		this.ispayed = ispayed;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<Map<String, Integer>> getBook() {
		return book;
	}

	public void setBook(List<Map<String, Integer>> book) {
		this.book = book;
	}

	public List<Appraise> getAppraise() {
		return appraise;
	}

	public void setAppraise(List<Appraise> appraise) {
		this.appraise = appraise;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + this.orderId + ", userId=" + this.userId
				+ ", addressId=" + this.addressId + ", ispayed=" + this.ispayed
				+ ", paymode=" + this.paymode + ", totalprice="
				+ this.totalprice + ", orderDate=" + this.orderDate + ", book="
				+ this.book + ", deliveryAddress=" + this.deliveryAddress
				+ ", user=" + this.user + ",appraise=" + this.appraise + "]";
	}
}
