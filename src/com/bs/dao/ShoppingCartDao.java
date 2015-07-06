package com.bs.dao;

import java.util.List;

import com.bs.bean.ShoppingCart;

/**
 * 处理与购物车模块的数据库操作
 * 
 * @author 若水
 *
 */
public interface ShoppingCartDao {
	/**
	 * 向购物车信息表中添加一条记录
	 * 
	 * @param shoppingCart
	 *            购物车
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insert(ShoppingCart shoppingCart);

	/**
	 * 从购物车信息表中删除用户编号为userId图书编号为bookId的一条记录
	 * 
	 * @param userId
	 *            用户编号
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int userId, int bookId);

	/**
	 * 从购物车信息表中删除用户编号为userId的所有记录
	 * 
	 * @param userId
	 *            用户编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int userId);

	/**
	 * 修改购物车信息表中的该条记录的number字段加1
	 * 
	 * @param shoppingCart
	 *            购物车
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(ShoppingCart shoppingCart);

	/**
	 * 从购物车信息表中查询出用户编号为userId的所有记录
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放ShoppingCart对象的集合
	 */
	public List<ShoppingCart> select(int userId);

	/**
	 * 从购物车信息表中查询出用户名为username的所有记录
	 * 
	 * @param username
	 *            用户名
	 * @return 存放ShoppingCart对象的集合
	 */
	public List<ShoppingCart> select(String username);

	/**
	 * 从购物车信息表中查询出用户编号为userId，图书编号为bookId的购物车记录总数
	 * 
	 * @param userId
	 * @param bookId
	 * @return 符合条件的购物车记录总数
	 */
	public int select(int userId, int bookId);
}
