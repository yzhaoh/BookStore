package com.bs.service;

import java.util.List;
import com.bs.bean.BookCategory;

/**
 * 处理与图书类别相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface BookCategoryService {
	/**
	 * 增加图书类别
	 * 
	 * @param category
	 *            图书类别
	 * @return 增加成功返回true，否则返回false
	 */
	public boolean add(BookCategory category);

	/**
	 * 修改图书类别
	 * 
	 * @param category
	 *            图书类别
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alter(BookCategory category);

	/**
	 * 获得所有图书类别列表
	 * 
	 * @return 存放BookCategory的集合
	 */
	public List<BookCategory> get();

	/**
	 * 删除图书类别
	 * 
	 * @param categoryId
	 *            类别编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int categoryId);

	/**
	 * 获得指定分类的图书总数
	 * 
	 * @param categoryId
	 *            类别编号
	 * @return 该类别下的图书总数
	 */
	public int getCount(int categoryId);
}
