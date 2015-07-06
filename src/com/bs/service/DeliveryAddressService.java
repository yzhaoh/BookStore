package com.bs.service;

import java.util.List;
import com.bs.bean.DeliveryAddress;

/**
 * 处理与地址管理模块相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface DeliveryAddressService {
	/**
	 * 添加收货地址
	 * 
	 * @param deliveryAddress
	 *            收货地址
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addAddress(DeliveryAddress deliveryAddress);

	/**
	 * 修改收货地址，根据地址编号修改
	 * 
	 * @param deliveryAddress
	 *            收货地址
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alterAddress(DeliveryAddress deliveryAddress);

	/**
	 * 删除地址编号为addressId的收货地址信息
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int addressId);
	/**
	 * 获得地址编号为addressId的收货地址信息
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 一个DeliveryAddress对象，否则返回null
	 */
	public DeliveryAddress getAddress(int addressId);

	/**
	 *获得用户编号为userId的所有收货地址
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放DeliveryAddress类对象的集合
	 */
	public List<DeliveryAddress> getAllAddress(int userId);

	/**
	 * 设置用户的默认地址（先取消用户原来设置的默认地址，再设置新的默认地址）
	 * 
	 * @param userId
	 *            用户编号
	 * @param addressId
	 *            地址编号
	 * @return 设置成功返回true，否则返回false
	 */
	public boolean setDefaultAddress(int userId, int addressId);
}
