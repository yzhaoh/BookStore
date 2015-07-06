package com.bs.dao;

import java.util.List;

import com.bs.bean.User;

/**
 * 处理与用户模块相关的数据库操作
 * 
 * @author 若水
 *
 */
public interface UserDao {
	/**
	 * 根据用户名从数据库中查询出用户密码
	 * 
	 * @param username
	 *            用户名
	 * @return 密码文本
	 */
	public String selectPasswordByUsername(String username);

	/**
	 * 向数据库中插入一条用户记录
	 * 
	 * @param user
	 *            用户
	 * @return 插入是否成功，成功返回true，失败返回false
	 */
	public boolean insert(User user);

	/**
	 * 通过用户名从数据库中删除该用户记录
	 * 
	 * @param username
	 *            用户名
	 * @return 删除是否成功，成功返回true，失败返回false
	 */
	@Deprecated
	public boolean deleteUserByUsername(String username);

	/**
	 * 从数据库中查询出所有用户信息
	 * 
	 * @return 存放User类型的集合，否则返回null
	 */
	public List<User> select();

	/**
	 * 通过用户名从数据库中查询出一条用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 返回一条用户信息，否则返回null
	 */
	public User selectUserByUsername(String username);

	/**
	 * 从数据库中删除所有用户信息
	 * 
	 * @return 删除是否成功，成功返回true，失败返回false
	 */
	@Deprecated
	public boolean delete();

	/**
	 * 通过userid字段更新数据库中的该用户信息的 姓名（name）,性别（sex）,电话（phone）,用户居住地（address）属性
	 * 
	 * @param user
	 *            用户
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean update(User user);

	/**
	 * 通过userid字段更新数据库中的该用户信息的
	 * 姓名（name）,性别（sex）,电话（phone）,用户居住地（address）,邮箱（email）,验证邮箱（checkEmail）属性
	 * 
	 * @param user
	 *            用户
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean update2(User user);

	/**
	 * 更新数据库中用户名为username的用户的密码为password
	 * 
	 * @param user
	 *            新密码封装在user中
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updatePassword(User user);

	/**
	 * 修改用户头像
	 * 
	 * @param userId
	 *            用户编号
	 * @param icon
	 *            新头像
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(int userId, String icon);

	/**
	 * 修改用户表（user）禁止登录（nologin）字段
	 * 
	 * @param userId
	 *            用户编号
	 * @param noLogin
	 *            禁止登录
	 * @return 修改成功返回true，否则false
	 */
	public boolean update(int userId, char noLogin);

	/**
	 * 修改用户表（user）验证邮箱（checkEmail）字段
	 * 
	 * @param username
	 *            用户名
	 * @param checkEmail
	 *            是否验证邮箱
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean update(String username, int checkEmail);
}
