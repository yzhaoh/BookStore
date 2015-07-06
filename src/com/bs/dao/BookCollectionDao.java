package com.bs.dao;

import java.util.List;

import com.bs.bean.BookCollection;

/**
 * 处理与图书收藏模块相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface BookCollectionDao {
	/**
	 * 向图书收藏表中添加一条记录
	 * 
	 * @param bookCollection
	 *            图书收藏
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean add(BookCollection bookCollection);

	/**
	 * 从图书收藏表中删除用户编号为userId，图书编号为bookId的一条记录
	 * 
	 * @param userId
	 *            用户编号
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int userId, int bookId);

	/**
	 * 从图书收藏表中查询出用户编号为userId的所有记录
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放BookCollection类对象的集合
	 */
	public List<BookCollection> select(int userId);
}
