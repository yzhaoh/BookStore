package com.bs.dao;

import java.util.List;

import com.bs.bean.Appraise;

/**
 * 处理与图书评价模块相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface AppraiseDao {
	/**
	 * 向图书评价信息表中添加一条记录，商城回复（mallanswer）字段无需添加
	 * 
	 * @param appraise
	 *            评价
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insert(Appraise appraise);

	/**
	 * 将图书评价信息表中的订单编号为orderId，图书编号为bookId的一条记录的商城回复（mallanswer）字段修改为mallanswer
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @param mallanswer
	 *            商城回复内容
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int orderId, int bookId, String mallanswer);

	/**
	 * 从图书评价信息表中删除订单编号为orderId,图书编号为bookId的一条记录
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean delete(int orderId, int bookId);

	/**
	 * 从图书评价信息表中查询出订单编号为orderId，图书编号为bookId的一条记录
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @return 评价实体，否则返回null
	 */
	public Appraise select(int orderId, int bookId);

	/**
	 * 从评价信息表中查询出图书编号为bookId的第start条记录开始的number条图书记录,并按评价时间降序排列
	 * 
	 * @param bookId
	 *            图书编号
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Appraise类对象的集合，否则返回null
	 */
	public List<Appraise> select(int bookId, int start, int number);

	/**
	 * 从评价信息表中查询出第start条记录开始的number条图书记录,并按评价时间降序排列
	 * 
	 * @param start
	 *            查询起始值，从第start条记录开始查询
	 * @param number
	 *            查询出的记录总数
	 * @return 存放Appraise类对象的集合，否则返回null
	 */
	public List<Appraise> selectAll(int start, int number);

	/**
	 * 从评价信息表中查询出总记录数
	 * 
	 * @return 记录总数
	 */
	public int selectCount();
}
