package com.bs.dao;

import java.util.List;

import com.bs.bean.BookCategory;

/**
 * 处理与图书类别相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface BookCategoryDao {
	/**
	 * 向数据库中插入一条图书类别
	 * 
	 * @param bookCategory
	 *            图书类别
	 * @return 插入是否成功，成功返回true，失败返回false
	 */
	public boolean insert(BookCategory bookCategory);

	/**
	 * 通过categoryid字段修改数据库中的该图书分类信息
	 * 
	 * @param bookCategory
	 *            图书分类
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(BookCategory bookCategory);

	/**
	 * 查询出图书类别表中的所有记录
	 * 
	 * @return 存放BookCategory的集合
	 */
	public List<BookCategory> select();

	/**
	 * 从图书类别表中删除类别编号为categoryId的记录
	 * 
	 * @param categoryId
	 *            类别编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int categoryId);

	/**
	 * 从数据库中查询出图书编号为coategoryId的图书总数
	 * 
	 * @param categoryId
	 *            图书编号
	 * @return 图书总数
	 */
	public int selectCount(int categoryId);

}
