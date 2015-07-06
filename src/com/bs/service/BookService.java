package com.bs.service;

import java.util.List;
import com.bs.bean.Book;

/**
 * 处理与图书模块相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface BookService {
	/**
	 * 添加图书，添加图书需要设置图书上架时间以及库存量
	 * 
	 * @param book
	 *            图书
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean add(Book book);

	/**
	 * 修改图书信息
	 * 
	 * @param book
	 *            图书
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean alter(Book book);

	/**
	 * 删除图书
	 * 
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int bookId);

	/**
	 * 对图书列表按指定的keywords进行排序，并分页显示图书信息
	 * 
	 * @param orderKeywords
	 *            排序关键字。包括“销量”，“价格”，“评价”，取值为：(sales,price,appraise)
	 * @param order
	 *            排序方式。包括“升序”，“降序”，取值为(asc,desc)
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 排序后的图书列表，否则返回null
	 */
	public List<Book> order(String orderKeywords, String order, int pageNow,
			int pageSize);

	/**
	 * 对指定图书分类（categoryid）下的图书列表按指定的orderKeywords，order进行排序，并分页显示图书信息
	 * 
	 * @param orderKeywords
	 *            排序关键字。包括“销量”，“价格”，“评价”，取值为：(sales,price,appraise)
	 * @param order
	 *            排序方式。包括“升序”，“降序”，取值为(asc,desc)
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @param categoryId
	 *            图书类别编号
	 * @return 排序后的图书列表，否则返回null
	 */
	public List<Book> order(String orderKeywords, String order, int pageNow,
			int pageSize, int categoryId);

	/**
	 * 获得指定图书分类（categoryId）下的图书列表（若categoryId为-1则获得所有图书列表）并分页显示图书信息
	 * 
	 * @param categoryId
	 *            图书类别编号
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 图书列表，否则返回null
	 */
	public List<Book> getBooks(int categoryId, int pageNow, int pageSize);

	/**
	 * 获得所有符合该关键字（bookKeywords）的图书
	 * 
	 * @param bookKeywords
	 *            图书关键字
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 符合该关键字的图书列表，否则返回null
	 */
	public List<Book> getBooks(String bookKeywords, int pageNow, int pageSize);

	/**
	 * 获得所有符合该关键字（bookKeywords）的图书并按指定的orderKeywords、order进行排序，分页显示出图书信息
	 * 
	 * @param bookKeywords
	 *            图书关键字
	 * @param orderKeywords
	 *            排序关键字。包括“销量”，“价格”，“评价”，取值为：(sales,price,appraise)
	 * @param order
	 *            排序方式。包括“升序”，“降序”，取值为(asc,desc)
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 符合该关键字的图书列表，否则返回null
	 */
	public List<Book> getBooks(String bookKeywords, String orderKeywords,
			String order, int pageNow, int pageSize);

	/**
	 * 获得最近上架的一部分图书
	 * 
	 * @param number
	 *            需要显示的新书数量
	 * @return 图书列表，否则返回null
	 */
	public List<Book> getNewBooks(int number);

	/**
	 * 获得图书记录总数
	 * 
	 * @return 图书记录总数
	 */
	public int getTotal();

	/**
	 * 修改图书图片
	 * 
	 * @param bookId
	 *            图片编号
	 * @param image
	 *            图片
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alter(int bookId, String image);

	/**
	 * 获得符合该关键字的图书记录总数
	 * 
	 * @param keyword
	 *            关键字
	 * @return 图书记录总数
	 */
	public int getKeyTotal(String keyword);

	/**
	 * 获得一本图书信息
	 * 
	 * @param bookId
	 *            图书编号
	 * @return 图书实体，否则返回null
	 */
	public Book get(int bookId);
}
