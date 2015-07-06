package com.bs.dao;

import java.util.List;

import com.bs.bean.Book;
import com.bs.bean.Order;

/**
 * 处理与订单模块的数据库操作
 * 
 * @author 若水
 *
 */
public interface OrderDao {
	/**
	 * 向订单基本信息表（orderbasic）添加一条记录
	 * 
	 * @param order
	 *            订单
	 * @return 插入后的订单编号
	 */
	public int insert(Order order);

	/**
	 * 向订单详细信息表（orderdetail）添加一条记录
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @param number
	 *            图书数量
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insert(int orderId, int bookId, int number);

	/**
	 * 将订单基本信息表（orderbasic）中订单编号为orderId的记录地址编号修改为addressId
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int orderId, int addressId);

	/**
	 * 删除订单基本信息表（orderbasic）中订单编号为orderId的记录
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteOrderBasic(int orderId);

	/**
	 * 删除订单详细信息表（orderdetail）中订单编号为orderId的记录
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteOrderDetail(int orderId);

	/**
	 * 从订单基本信息表（orderbasic）中查询出用户编号为userId的第start条记录开始的number条订单记录
	 * 
	 * @param userId
	 *            用户编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> selectAll(int userId, int start, int number);

	/**
	 * 从订单基本信息表（orderbasic）中查询出未付款的用户编号为userId的第start条记录开始的number条订单记录
	 * 
	 * @param userId
	 *            用户编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> selectOrderByIsPayed(int userId, int start, int number);

	/**
	 * 从订单基本信息表（orderbasic）中查询出订单编号为orderId的记录
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 订单实体
	 */
	public Order select(int orderId);

	/**
	 * 获得订单信息表的记录总数
	 * 
	 * @return 订单信息表记录总数
	 */
	public int selectCount();

	/**
	 * 从订单信息表中查询出第start条记录开始的number条订单记录
	 * 
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Order类对象的集合，否则返回null
	 */
	public List<Order> select(int start, int number);

	/**
	 * 从订单信息表中查询出符合该关键字的订单记录总数
	 * 
	 * @param keyword
	 *            关键字
	 * @return 订单记录总数
	 */
	public int selectKeyCount(String keyword);

	/**
	 * 从订单信息表中查询出订单编号、用户编号、用户名、联系电话或订单日期字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“
	 * java”） 的第start条记录开始的number条订单记录
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Order类对象的集合，否则返回null
	 */
	public List<Order> select(String str, int start, int number);

	/**
	 * 从数据库中查询出订单号为orderId的图书信息（图书编号、ISBN号、书名、作者、出版社、现价、图书数量）
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBooks(int orderId);

	/**
	 * 从订单基本信息表中查询出地址编号为addressId的订单记录总数
	 * 
	 * @param addressId
	 *            地址编号
	 * @return 若订单记录总数为0则返回false，否则返回true
	 */
	public boolean selectAddress(int addressId);

	/**
	 * 从订单基本信息表（orderbasic）中查询出用户编号为userId的订单记录
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> selectAll(int userId);

	/**
	 * 修改订单基本信息表（orderbasic）中订单编号为orderId的记录“是否付款”字段值为0
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int orderId);

}
