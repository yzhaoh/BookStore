package com.bs.service;

import java.util.List;
import com.bs.bean.Book;
import com.bs.bean.DeliveryAddress;
import com.bs.bean.Order;

/**
 * 处理与订单模块相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface OrderService {
	/**
	 * 用户提交订单（需要向两个数据库表（订单基本信息表，订单详细信息表）中添加记录）
	 * 
	 * @param order
	 *            订单
	 * @return 提交订单成功返回true，否则返回false
	 */
	public boolean submitOrder(Order order);

	/**
	 * 修改订单收货地址信息（先给该用户添加一个新的收货地址信息，再把订单信息中的收货地址编号修改为新增加的收货地址编号）
	 * 
	 * @param deliveryAddress
	 *            收货地址
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean updateDeliveryAddress(int orderId,
			DeliveryAddress deliveryAddress);

	/**
	 * 删除订单（分别从订单基本信息表和订单详细信息表中删除该订单）
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteOrder(int orderId);

	/**
	 * 获得指定用户的部分订单列表，并分页显示订单信息
	 * 
	 * @param userId
	 *            用户编号
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> getAll(int userId, int pageNow, int pageSize);

	/**
	 * 获得指定用户的所有订单信息
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> getAll(int userId);

	/**
	 * 获得指定用户未付款的部分订单列表，并分页显示订单信息
	 * 
	 * @param userId
	 *            用户编号
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> getOrderByIsPayed(int userId, int pageNow, int pageSize);

	/**
	 * 获得一个订单信息
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 订单实体
	 */
	public Order get(int orderId);

	/**
	 * 获得订单表的记录总数
	 * 
	 * @return 记录总数
	 */
	public int getTotal();

	/**
	 * 获得指定部分订单信息，并分页显示
	 * 
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 存放订单实体的集合，否则返回null
	 */
	public List<Order> getOrders(int pageNow, int pageSize);

	/**
	 * 获得符合该关键字的订单记录总数
	 * 
	 * @param keyword
	 *            关键字
	 * @return 记录总数
	 */
	public int getKeyTotal(String keyword);

	/**
	 * 获得所有符合该关键字（keyword）的订单
	 * 
	 * @param keyword
	 *            订单关键字
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的订单数目
	 * @return 符合该关键字的订单列表，否则返回null
	 */
	public List<Order> getOrders(String keyword, int pageNow, int pageSize);

	/**
	 * 获得该订单号的所有图书信息
	 * 
	 * @param orderId
	 *            订单编号
	 * @return 存放图书实体的集合，否则返回null
	 */
	public List<Book> getBooks(int orderId);

	/**
	 * 支付订单
	 * 
	 * @param orderId
	 *            订单号
	 * @return 支付成功返回true，否则返回false
	 */
	public boolean pay(int orderId);
}
