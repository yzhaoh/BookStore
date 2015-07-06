package com.bs.service;

import java.util.List;
import com.bs.bean.Book;
import com.bs.bean.BookSales;

/**
 * 处理与图书销售、库存相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface BookSalesService {
	/**
	 * 修改图书库存量
	 * 
	 * @param bookId
	 *            图书编号
	 * @param nowNumber
	 *            库存数量
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alterInventory(int bookId, int nowNumber);

	/**
	 * 获得图书销售记录总数
	 * 
	 * @return 图书销售记录总数
	 */
	public int getTotal();

	/**
	 * 获得图书销售列表，并分页显示图书信息
	 * 
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书销售数目
	 * @return 图书销售列表，否则返回null
	 */
	public List<BookSales> getBookSales(int pageNow, int pageSize);

	/**
	 * 获得符合该关键字的图书销售记录总数
	 * 
	 * @param keyword
	 *            关键字
	 * @return 图书销售记录总数
	 */
	public int getKeyTotal(String keyword);

	/**
	 * 获得所有符合该关键字（bookKeywords）的图书
	 * 
	 * @param salesKeywords
	 *            销售信息关键字
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 符合该关键字的销售信息列表，否则返回null
	 */
	public List<BookSales> getBookSales(String salesKeywords, int pageNow,
			int pageSize);

	/**
	 * 获得销售量最高的一部分图书
	 * 
	 * @param number
	 *            需要显示的销售量最高的图书数量
	 * @return 图书列表，否则返回null
	 */
	public List<Book> getSalesTop(int number);
}
