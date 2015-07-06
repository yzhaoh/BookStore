package com.bs.service;

import java.util.List;
import com.bs.bean.Appraise;

/**
 * 处理与图书评价模块的数据库操作
 * 
 * @author 若水
 *
 */
public interface AppraiseService {
	/**
	 * 用户评价图书
	 * 
	 * @param appraise
	 *            评价
	 * @return 评价成功返回true，否则返回false
	 */
	public boolean appraise(Appraise appraise);

	/**
	 * 商城回复用户评价
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @param mallanswer
	 *            商城回复内容
	 * @return 商城回复成功返回true，否则返回false
	 */
	public boolean mallAnswerAppraise(int orderId, int bookId, String mallanswer);

	/**
	 * 删除商城对用户评价的回复内容
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteMallAnswerAppraise(int orderId, int bookId);

	/**
	 * 删除用户对指定图书的评价
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @return 删除成功返回true，否则返回false
	 */
	public boolean deleteAppraise(int orderId, int bookId);

	/**
	 * 获得指定用户对指定图书的评价信息
	 * 
	 * @param orderId
	 *            订单编号
	 * @param bookId
	 *            图书编号
	 * @return 评价实体，否则返回null
	 */
	public Appraise get(int orderId, int bookId);

	/**
	 * 获得指定图书的部分评价列表，并分页显示评价信息
	 * 
	 * @param bookId
	 *            图书编号
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 存放Appraise类对象的集合，否则返回null
	 */
	public List<Appraise> getAppraises(int bookId, int pageNow, int pageSize);

	/**
	 * 获得所有图书的部分评价列表，并分页显示评价信息
	 * 
	 * @param pageNow
	 *            当前页。当前需要显示的页码数
	 * @param pageSize
	 *            分页大小。每页需要显示的图书数目
	 * @return 存放Appraise类对象的集合，否则返回null
	 */
	public List<Appraise> getAppraises(int pageNow, int pageSize);

	/**
	 * 获得评价记录总数
	 * 
	 * @return 评价记录总数
	 */
	public int getCount();
}
