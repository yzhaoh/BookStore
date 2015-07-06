package com.bs.service;

import java.util.List;
import com.bs.bean.BookCollection;

/**
 * 处理与图书收藏相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface BookCollectionService {
	/**
	 * 将一本图书加入收藏
	 * 
	 * @param bookCollection
	 *            图书收藏
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean collection(BookCollection bookCollection);

	/**
	 * 删除指定用户的一条收藏记录
	 * 
	 * @param userId
	 *            用户编号
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int userId, int bookId);

	/**
	 * 获得指定用户的所有收藏记录
	 * 
	 * @param userId
	 *            用户编号
	 * @return 存放BookCollection类对象的集合
	 */
	public List<BookCollection> getCollections(int userId);
}
