package com.bs.serviceImpl;

import java.util.List;
import com.bs.bean.ShoppingCart;
import com.bs.bean.User;
import com.bs.common.MD5;
import com.bs.common.Mail;
import com.bs.common.ValidateCode;
import com.bs.dao.ShoppingCartDao;
import com.bs.dao.UserDao;
import com.bs.service.UserService;

/**
 * 用户模块（UserService）接口实现
 * 
 * @author 若水
 *
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private ValidateCode validateCode;
	private ShoppingCartDao shoppingCartDao;

	@Override
	public ValidateCode getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(ValidateCode validateCode) {
		this.validateCode = validateCode;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		if (username != null && password != null) {
			User user = userDao.selectUserByUsername(username);
			String md5Str = MD5.getMd5(password);
			if (user != null && md5Str != null
					&& user.getPassword().equals(md5Str)) {
				if (user.getNoLogin().equals("0"))
					return -1;
				return 1;
			}
			return 0;
		}
		return -8;
	}

	@Override
	public int login(String username, String password, List<Object> list) {
		// TODO Auto-generated method stub
		int i = this.login(username, password);
		if (i == 1 && list != null) {
			for (Object obj : list) {
				if (obj instanceof ShoppingCart) {
					shoppingCartDao.insert((ShoppingCart) obj);
				}
			}
		}
		return i;
	}

	@Override
	public boolean checkCode(String code, String sessionCode) {
		if (code != null && sessionCode != null && code.equalsIgnoreCase(sessionCode))
			return true;
		return false;
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		if (user != null
				&& userDao.selectUserByUsername(user.getUsername()) == null) {
			user.setPassword(MD5.getMd5(user.getPassword()));
			if (userDao.insert(user))
				return 1;
			return -1;
		}
		return 0;
	}

	@Override
	public boolean alter(User user) {
		// TODO Auto-generated method stub
		if (user != null)
			return userDao.update(user);
		return false;
	}

	@Override
	public boolean delete(String... usernames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmail(User user, String checkUrl, String url, int status) {
		// TODO Auto-generated method stub
		if (user != null && checkUrl != null && url != null)
			return Mail.sendMail(user, checkUrl, url, status);
		return false;
	}

	@Override
	public boolean alterIcon(int userId, String icon) {
		// TODO Auto-generated method stub
		if (icon != null)
			return userDao.update(userId, icon);
		return false;
	}

	@Override
	public boolean resetPassword(String username, String password) {
		// TODO Auto-generated method stub
		if (username != null && password != null) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(MD5.getMd5(password));
			return userDao.updatePassword(user);
		}
		return false;
	}

	@Override
	public boolean noLogin(int userId, char noLogin) {
		// TODO Auto-generated method stub
		return userDao.update(userId, noLogin);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.select();
	}

	@Override
	public boolean alter2(User user) {
		// TODO Auto-generated method stub
		if (user != null)
			return userDao.update2(user);
		return false;
	}

	@Override
	public boolean alter(String username, int checkEmail) {
		// TODO Auto-generated method stub
		if(username!=null){
			return userDao.update(username, checkEmail);
		}
		return false;
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		if(username!=null){
			return userDao.selectUserByUsername(username);
		}
		return null;
	}

}
