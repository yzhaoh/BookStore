package com.bs.service;

import java.util.List;
import com.bs.bean.User;
import com.bs.common.ValidateCode;

/**
 * 处理与用户模块相关的业务逻辑操作
 * 
 * @author 若水
 *
 */
public interface UserService {
	/**
	 * 用户登录 1、验证用户名密码是否正确；2验证用户是否有权登录系统。
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录成功返回1，密码错误返回0，禁止登录返回-1，系统错误返回-8
	 */
	public int login(String username, String password);

	/**
	 * 用户登录 1、验证用户名密码是否正确；2验证用户是否有权登录系统；3、检查session中的购物车是否有商品，有则同步到数据库。
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param list
	 *            从session中获得的对象
	 * @return 登录成功返回1，密码错误返回0，禁止登录返回-1，系统错误返回-8
	 */
	public int login(String username, String password, List<Object> list);

	/**
	 * 顾客注册成为商城用户
	 * 
	 * @param user
	 *            用户
	 * @return 注册成功返回1，用户名已存在返回0，注册失败返回-1
	 */
	public int register(User user);

	/**
	 * 修改用户信息，姓名（name）,性别（sex）,电话（phone）,用户居住地（address）属性
	 * 
	 * @param user
	 *            用户
	 * @return 成功返回true，失败返回false
	 */
	public boolean alter(User user);

	/**
	 * 修改用户信息，性别（sex）,电话（phone）,用户居住地（address）,邮箱（email）,验证邮箱（
	 * checkEmail）属性
	 * 
	 * @param user
	 *            用户
	 * @return 成功返回true，失败返回false
	 */
	public boolean alter2(User user);

	/**
	 * 该接口方法不符合需求，已被废弃，无需实现
	 * 
	 * 删除用户信息，若usernames数组为0则删除全部用户，否则删除数组中的所有用户。
	 * 
	 * @param usernames
	 *            用户名
	 * @return 成功返回true，失败返回false
	 */
	@Deprecated
	public boolean delete(String... usernames);

	/**
	 * 验证邮箱
	 * 
	 * @param user
	 *            接收邮件的用户
	 * @param checkUrl
	 *            邮箱验证链接
	 * @param url
	 *            图书商城系统主页
	 * @param status
	 *            状态（“修改密码”为1，“验证邮箱”为2）
	 * @return 邮箱验证成功返回true，否则返回false
	 */
	public boolean checkEmail(User user, String checkUrl, String url, int status);

	/**
	 * 重置密码
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            新密码
	 * @return 邮箱验证成功返回true，否则返回false
	 */
	public boolean resetPassword(String username, String password);

	/**
	 * 检验验证码是否正确
	 * 
	 * @param code
	 *            用户输入的验证码
	 * @param sessionCode
	 *            session中存放的验证码
	 * @return 验证成功返回true，否则false
	 */
	public boolean checkCode(String code, String sessionCode);

	/**
	 * 获取验证码对象
	 * 
	 * @return 验证码对象
	 */
	public ValidateCode getValidateCode();

	/**
	 * 修改用户头像
	 * 
	 * @param userId
	 *            用户编号
	 * @param icon
	 *            用户新头像
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alterIcon(int userId, String icon);

	/**
	 * 设置该用户是否禁止登录系统
	 * 
	 * @param userId
	 *            用户编号
	 * @param noLogin
	 *            是否禁止登录
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean noLogin(int userId, char noLogin);

	/**
	 * 获得所有用户
	 * 
	 * @return 存放用户的集合，否则返回null
	 */
	public List<User> getUsers();

	/**
	 * 修改用户的验证邮箱字段
	 * 
	 * @param username
	 *            用户名
	 * @param checkEmail
	 *            是否验证邮箱
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean alter(String username, int checkEmail);

	/**
	 * 获得该用户的用户信息
	 * 
	 * @param username
	 *            用户名
	 * @return 用户实体，否则返回null
	 */
	public User get(String username);
}
