package com.bs.dao;

import java.util.List;

import com.bs.bean.DeliveryAddress;

/**
 * 处理与地址管理模块相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface DeliveryAddressDao {
	/**
	 * 向收货地址信息表中添加一条记录
	 * 
	 * @param deliveryAddress
	 *            收货地址
	 * @return 地址编号，否则返回0
	 */
	public int insert(DeliveryAddress deliveryAddress);

	/**
	 * 修改收货地址信息表中的一条记录
	 * 
	 * @param deliveryAddress
	 *            收货地址
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(DeliveryAddress deliveryAddress);

	/**
	 *删除地址编号为addressId的一条记录
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int addressId);

	/**
	 * 从地址信息表中查询出地址编号为addressId的一条记录
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 一个DeliveryAddress对象，否则返回null
	 */
	public DeliveryAddress select(int addressId);

	/**
	 * 从地址信息表中查询出用户编号为userId，deleteorupdate（删除或修改）字段值为1的所有记录
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放DeliveryAddress类对象的集合
	 */
	public List<DeliveryAddress> selectAll(int userId);

	/**
	 * 修改地址信息表中地址编号为addressId的默认地址字段为defaultAddress
	 * 
	 * @param addressId
	 *            地址编号
	 * @param defaultAddress
	 *            默认地址
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int addressId, int defaultAddress);

	/**
	 * 修改收货地址信息表中地址编号为addressId的deleteorupdate字段值为0
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int addressId);

	/**
	 * 从地址信息表中查询出用户编号为userId的默认地址的地址编号
	 * 
	 * @param userId
	 *            用户编号
	 * @return 地址编号，否则返回0
	 */
	public int selectDefault(int userId);
}
