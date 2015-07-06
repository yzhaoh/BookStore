package com.bs.service;

import java.util.List;
import com.bs.bean.ShoppingCart;

/**
 * 处理与购物车相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface ShoppingCartService {
	/**
	 * 把商品添加到购物车中 （若用户已登录则把商品保存到数据库。）
	 * 
	 * @param shoppingCart
	 *            购物车
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addBook(ShoppingCart shoppingCart);

	/**
	 * 删除购物车中的一个商品（若用户已登录则从数据库中删除该商品。）
	 * 
	 * @param shoppingCart
	 *            购物车
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteBook(ShoppingCart shoppingCart);

	/**
	 * 清空购物车（若用户已登录则从数据库中删除所有商品。）
	 * 
	 * @param shoppingCart
	 *            购物车
	 * @return 清空购物车成功返回true，否则返回false
	 */
	public boolean deleteBooks(ShoppingCart shoppingCart);

	/**
	 * 修改购物车中指定商品的数量加1（若用户已登录则从数据库中修改该商品的数量。）
	 * 
	 * @param shoppingCart
	 *            购物车
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alterNumber(ShoppingCart shoppingCart);

	/**
	 * 从购物车中获得指定用户的所有商品（若用户已登录则从数据库中查找。）
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放ShoppingCart对象的集合
	 */
	public List<ShoppingCart> getBooks(int userId);

	/**
	 * 从购物车中获得指定用户的所有商品（若用户已登录则从数据库中查找。）
	 * 
	 * @param username
	 *            用户名
	 * @return 存放ShoppingCart对象的集合
	 */
	public List<ShoppingCart> getBooks(String username);

	/**
	 * 从购物车中查询出某用户是否购买了某本书
	 * 
	 * @param userId
	 *            用户编号
	 * @param bookId
	 *            图书编号
	 * @return 若用户购买了该图书则返回true，否则返回false
	 */
	public boolean getBook(int userId, int bookId);
}
