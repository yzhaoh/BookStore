package com.bs.bean;

import java.util.List;

/**
 * 用户模型，对应用户表的实体类
 * 
 * @author 若水
 *
 */
public class User {
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 用户登录名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 邮箱是否验证
	 */
	private String checkEmail;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 用户头像
	 */
	private String icon;
	/**
	 * 用户居住地
	 */
	private String address;
	/**
	 * 禁止登录
	 */
	private String noLogin;
	/**
	 * 用户收货地址集合
	 */
	private List<DeliveryAddress> deliveryAddress;
	/**
	 * 用户购物车清单
	 */
	private List<ShoppingCart> shoppingCart;
	/**
	 * 用户图书收藏清单
	 */
	private List<BookCollection> bookCollection;
	/**
	 * 用户的订单基本信息集合
	 */
	private List<Order> order;
	/**
	 * 用户的所有评价信息
	 */
	private List<Appraise> appraise;

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(String checkEmail) {
		this.checkEmail = checkEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNoLogin() {
		return noLogin;
	}

	public void setNoLogin(String noLogin) {
		this.noLogin = noLogin;
	}

	public List<DeliveryAddress> getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(List<DeliveryAddress> deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<ShoppingCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<ShoppingCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<BookCollection> getBookCollection() {
		return bookCollection;
	}

	public void setBookCollection(List<BookCollection> bookCollection) {
		this.bookCollection = bookCollection;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<Appraise> getAppraise() {
		return appraise;
	}

	public void setAppraise(List<Appraise> appraise) {
		this.appraise = appraise;
	}

	@Override
	public String toString() {
		return "User [userId=" + this.userId + ", username=" + this.username
				+ ", password=" + this.password + ", name=" + this.name
				+ ", sex=" + this.sex + ", email=" + this.email
				+ ", checkEmail=" + this.checkEmail + ", phone=" + this.phone
				+ ", icon=" + this.icon + ", address=" + this.address
				+ ", appraise=" + this.appraise + ", bookCollection="
				+ this.bookCollection + ", deliveryAddress="
				+ this.deliveryAddress + ", order=" + this.order
				+ ", shoppingCart=" + this.shoppingCart + "]";
	}

}