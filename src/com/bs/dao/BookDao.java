package com.bs.dao;

import java.util.List;

import com.bs.bean.Book;

/**
 * 处理与图书模块相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface BookDao {
	/**
	 * 向数据库中插入一条图书记录
	 * 
	 * @param book
	 *            图书
	 * @return 插入记录的图书编号
	 */
	public int insert(Book book);

	/**
	 * 通过图书编号从数据库中删除该条图书记录
	 * 
	 * @param bookId
	 *            图书编号
	 * @return 删除是否成功，成功返回true，失败返回false
	 */
	public boolean delete(int bookId);

	/**
	 * 从数据库中删除所有图书信息
	 * 
	 * @return 删除是否成功，成功返回true，失败返回false
	 */
	public boolean delete();

	/**
	 * 从数据库中查询出所有图书信息
	 * 
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> select();

	/**
	 * 从图书信息表中查询出第start条记录开始的number条图书记录
	 * 
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> select(int start, int number);

	/**
	 * 通过图书编号从数据库中查询出一条图书信息
	 * 
	 * @param bookId
	 *            图书编号
	 * @return 返回一条图书信息，否则返回null
	 */
	public Book select(String bookId);

	/**
	 * 该接口方法不符合需求，已被废弃，无需实现
	 * 
	 * 从数据库中查询出书名为bookName的第start条记录开始的number条图书记录
	 * 
	 * @param bookName
	 *            书名
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	@Deprecated
	public List<Book> selectBookByBookName(String bookName, int start,
			int number);

	/**
	 * 该接口方法不符合需求，已被废弃，无需实现
	 * 
	 * 从数据库中查询出作者为author的第start条记录开始的number条图书记录
	 * 
	 * @param author
	 *            作者
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	@Deprecated
	public List<Book> selectBookByAuthor(String author, int start, int number);

	/**
	 * 该接口方法不符合需求，已被废弃，无需实现
	 * 
	 * 从数据库中查询出出版社为publisher的第start条记录开始的number条图书记录
	 * 
	 * @param publisher
	 *            出版社
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	@Deprecated
	public List<Book> selectBookByPublisherr(String publisher, int start,
			int number);

	/**
	 * 该接口方法不符合需求，已被废弃，无需实现
	 * 
	 * 从数据库中查询出ISBN号为ISBN的第start条记录开始的number条图书记录
	 * 
	 * @param ISBN
	 *            ISBN号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	@Deprecated
	public List<Book> selectBookByISBN(String ISBN, int start, int number);

	/**
	 * 通过bookid字段修改数据库中的该图书信息，图片（image）字段不修改
	 * 
	 * @param book
	 *            图书
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(Book book);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录,并按销售数量升序排列
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookBySalesASC(String str, int start, int number);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录,并按销售数量降序排列
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookBySalesDESC(String str, int start, int number);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录,并按现价升序排列
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByPriceASC(String str, int start, int number);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录,并按现价降序排列
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByPriceDESC(String str, int start, int number);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录,并按评价（该图书的好评总数）升序排列
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByAppraiseASC(String str, int start, int number);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录,并按评价（该图书的好评总数）降序排列
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByAppraiseDESC(String str, int start, int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录,并按销售数量升序排列
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookBySalesASC(int categoryid, int start, int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录,并按销售数量降序排列
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookBySalesDESC(int categoryid, int start,
			int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录,并按现价升序排列
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByPriceASC(int categoryid, int start, int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录,并按现价降序排列
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByPriceDESC(int categoryid, int start,
			int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录,并按评价（该图书的好评总数）升序排列
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByAppraiseASC(int categoryid, int start,
			int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录,并按评价（该图书的好评总数）降序排列
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> selectBookByAppraiseDESC(int categoryid, int start,
			int number);

	/**
	 * 从数据库中查询出图书类别编号为categoryid的第start条记录开始的number条图书记录
	 * 
	 * @param categoryid
	 *            图书类别编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> select(int categoryid, int start, int number);

	/**
	 * 从图书信息表中查询出书名、作者、ISBN或出版社字段匹配str字符串（该字段只要包含str字符串即为匹配，如：“av”匹配“java”）
	 * 的第start条记录开始的number条图书记录
	 * 
	 * @param str
	 *            字符串
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Book类对象的集合，否则返回null
	 */
	public List<Book> select(String str, int start, int number);

	/**
	 * 获得图书信息表的记录总数
	 * 
	 * @return 图书信息表记录总数
	 */
	public int selectCount();

	/**
	 * 修改图片信息表中的图片（image）字段
	 * 
	 * @param bookId
	 *            图片编号
	 * @param image
	 *            图片
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int bookId, String image);

	/**
	 * 从图书信息表中查询出符合该关键字（书名、作者、ISBN或出版社字段匹配str字符串）的图书记录总数
	 * 
	 * @param keyword
	 *            关键字
	 * @return 图书记录总数
	 */
	public int selectKeyCount(String keyword);
}
