package com.bs.bean;

/**
 * 收货地址模型，对应收货地址表的实体类
 * 
 * @author 若水
 *
 */
public class DeliveryAddress {
	/**
	 * 地址id
	 */
	private int addressId;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 收货人
	 */
	private String deliveryPerson;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String postcode;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 是否为默认地址
	 */
	private String defaultAddress;
	/**
	 * 是否删除或修改
	 */
	private String deleteOrUpdate;
	/**
	 * 用户
	 */
	private User user;

	public DeliveryAddress() {

	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDefaultaddress() {
		return defaultAddress;
	}

	public void setDefaultaddress(String defaultaddress) {
		this.defaultAddress = defaultaddress;
	}

	public String getDeleteOrUpdate() {
		return deleteOrUpdate;
	}

	public void setDeleteOrUpdate(String deleteOrUpdate) {
		this.deleteOrUpdate = deleteOrUpdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DeliveryAddress [userId=" + this.userId + "addressId="
				+ this.addressId + ", address=" + this.address
				+ ", defaultAddress=" + this.defaultAddress
				+ ",deleteOrUpdate=" + this.deleteOrUpdate
				+ ", deliveryPerson=" + this.deliveryPerson + ", phone="
				+ this.phone + ", postcode=" + this.postcode + "user="
				+ this.user + "]";
	}
}
