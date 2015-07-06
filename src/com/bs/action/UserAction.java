package com.bs.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bs.bean.DeliveryAddress;
import com.bs.bean.User;
import com.bs.common.ValidateCode;
import com.bs.service.DeliveryAddressService;
import com.bs.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理与用户模块相关的接收页面数据，跳转。 此处注意：action层的职责是接收前台页面数据，处理跳转逻辑。
 * 不应出现任何业务逻辑，业务逻辑应由service层承担。
 * 
 * @author 若水
 *
 */
public class UserAction extends ActionSupport implements SessionAware,
		ServletResponseAware {

	private static final long serialVersionUID = 1L;

	private UserService userService;
	private DeliveryAddressService deliveryAddressService;
	private Map<String, Object> session;
	private HttpServletResponse response;
	private Map<String, Object> status;
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 用户登录名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 重复密码
	 */
	private String repassword;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 邮箱是否验证
	 */
	private String checkEmail;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 用户头像
	 */
	private String icon;
	/**
	 * 用户居住地
	 */
	private String address;
	/**
	 * 验证码
	 */
	private String code;
	/**
	 * 禁止登录
	 */
	private char noLogin;
	private List<User> user;
	private List<DeliveryAddress> deliveryAddresses;
	private User u;
	private ByteArrayInputStream byteArrayInputStream;
	/**
	 * 图书商城系统主页
	 */
	private String url;
	/**
	 * 邮箱验证链接
	 */
	private String checkUrl;
	/**
	 * 随机邮箱验证值
	 */
	private String id;

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DeliveryAddressService getDeliveryAddressService() {
		return deliveryAddressService;
	}

	public void setDeliveryAddressService(
			DeliveryAddressService deliveryAddressService) {
		this.deliveryAddressService = deliveryAddressService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(String checkEmail) {
		this.checkEmail = checkEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public char getNoLogin() {
		return noLogin;
	}

	public void setNoLogin(char noLogin) {
		this.noLogin = noLogin;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<DeliveryAddress> getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(List<DeliveryAddress> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public ByteArrayInputStream getByteArrayInputStream() {
		return byteArrayInputStream;
	}

	public void setByteArrayInputStream(
			ByteArrayInputStream byteArrayInputStream) {
		this.byteArrayInputStream = byteArrayInputStream;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCheckUrl() {
		return checkUrl;
	}

	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Object> status) {
		this.status = status;
	}

	public String login() {
		int code = userService.login(username, password);
		switch (code) {
		case 1:
			this.session.put("username", username);
			this.session.put("userId", userService.get(username).getUserId());
			// 用户登录时若购物车中有商品，需把商品同步到数据库中

			return SUCCESS;
		case 0:
			this.addActionError("用户名或密码错误！");
			return ERROR;
		case -1:
			this.addActionError("该用户已被禁止登录！");
			return ERROR;
		case -8:
			this.addActionError("系统错误，请稍后再试！");
			return ERROR;
		}
		return ERROR;
	}

	public String register() {
		boolean b = userService.checkCode(code, session.get("code").toString());
		if (b) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setCheckEmail("1");
			user.setNoLogin("1");
			int code = userService.register(user);
			switch (code) {
			case 1:
				return SUCCESS;
			case 0:
				this.addFieldError("username", "用户名已存在！");
				return INPUT;
			case -1:
				this.addFieldError("username", "注册失败！");
				return INPUT;
			}
		}
		this.addFieldError("code", "验证码错误！");
		return INPUT;
	}

	public String alterMessage() {
		User user = new User();
		user.setUserId(userId);
		user.setAddress(address);
		user.setName(name);
		user.setPhone(phone);
		user.setSex(sex);
		boolean b = userService.alter(user);
		if (b)
			return SUCCESS;
		return INPUT;
	}

	public String toRegister() {

		return ERROR;
	}

	public String changeCode() throws IOException {
		ValidateCode validateCode = userService.getValidateCode();
		String code = validateCode.getCode();
		this.session.put("code", code);
		BufferedImage bufferedImage = validateCode.getImage();
		this.setByteArrayInputStream(validateCode
				.convertImageToStream(bufferedImage));
		return SUCCESS;
	}

	public String getUsers() {
		this.user = userService.getUsers();
		return SUCCESS;
	}

	public String alterUser() {
		User user = new User();
		user.setUserId(userId);
		user.setUsername(username);
		user.setName(name);
		user.setSex(sex);
		user.setEmail(email);
		user.setCheckEmail(checkEmail);
		user.setAddress(address);
		user.setPhone(phone);
		response.setCharacterEncoding("utf-8");
		boolean b = userService.alter2(user);
		this.status = new HashMap<String, Object>();
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String noLogin() {
		boolean b = userService.noLogin(userId, noLogin);
		this.status = new HashMap<String, Object>();
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String sendEmail() {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		String id = String.valueOf(Math.random() * Math.random());
		session.put(username, id);
		String checkUrl = this.checkUrl + "?id=" + id + "&username=" + username;
		boolean b = userService.checkEmail(user, checkUrl, url, 2);
		if (b) {
			ActionContext.getContext().put("send", "success");
			return SUCCESS;
		}
		return ERROR;
	}

	public String checkUrl() {
		String id = (String) session.get(username);
		if (this.id.equals(id) && userService.alter(username, 0)) {
			ActionContext.getContext().put("checkUrl", "success");
			return SUCCESS;
		}
		ActionContext.getContext().put("checkUrl", "error");
		return ERROR;
	}

	public String userInfo() {
		u = userService.get((String) session.get("username"));
		if (u != null) {
			deliveryAddresses = deliveryAddressService.getAllAddress(u
					.getUserId());
			return SUCCESS;
		}
		return ERROR;
	}

	public String exit() {
		session.clear();
		return SUCCESS;
	}

	public String loginAdmin() {
		this.status = new HashMap<String, Object>();
		if (username.equals("若水") && password.equals("ruoshuike")) {
			this.session.put("admin", "若水");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
