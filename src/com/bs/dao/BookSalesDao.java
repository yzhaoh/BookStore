package com.bs.dao;

import java.util.List;

import com.bs.bean.Book;
import com.bs.bean.BookSales;

/**
 * 处理与图书销售、库存相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface BookSalesDao {
	/**
	 * 从数据库中查询出图书销售数量最大的number条记录
	 * 
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectSalesTop(int number);

	/**
	 * 从数据库中查询出图书上架时间最短的number条记录
	 * 
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectSalesTimeTop(int number);

	/**
	 * 修改图书销售表中图书编号为bookId的库存数量
	 * 
	 * @param bookId
	 *            图书编号
	 * @param nowNumber
	 *            库存数量
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int bookId, int nowNumber);

	/**
	 * 修改图书销售表中图书编号为bookId的上架时间
	 * 
	 * @param bookId
	 *            图书编号
	 * @param date
	 *            上架时间
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int bookId, String date);

	/**
	 * 查询出图书销售表中图书编号为bookId的库存数量
	 * 
	 * @param bookId
	 *            图书编号
	 * @return 库存数量
	 */
	public int select(int bookId);

	/**
	 * 向图书销售表中添加一条记录
	 * 
	 * @param bookSales
	 *            销售实体
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insert(BookSales bookSales);

	/**
	 * 从数据库中查询出图书销售表中第start条记录开始的number条图书记录
	 * 
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放BookSales类对象的集合，否则返回null
	 */
	public List<BookSales> select(int start, int number);

	/**
	 * 从数据库中查询出图书销售表记录总数
	 * 
	 * @return 记录总数
	 */
	public int selectCount();

	/**
	 * 从图书销售表中查询出符合该关键字的图书销售记录总数
	 * 
	 * @param keyword
	 *            关键字
	 * @return 图书销售记录总数
	 */
	public int selectKeyCount(String keyword);

	/**
	 * 从图书销售信息表中查询出图书编号或书名字段匹配salesKeywords字符串（该字段只要包含salesKeywords字符串即为匹配，如：“av
	 * ”匹配“java”） 的第start条记录开始的number条图书记录
	 * 
	 * @param salesKeywords
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放BookSales类对象的集合，否则返回null
	 */
	public List<BookSales> select(String salesKeywords, int start, int number);
}
