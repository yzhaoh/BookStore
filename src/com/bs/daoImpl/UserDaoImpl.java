package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.User;
import com.bs.dao.UserDao;

/**
 * UserDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

	@Override
	public String selectPasswordByUsername(String username) {
		String password = (String) this.getSqlMapClientTemplate()
				.queryForObject("user.selectPasswordByUsername", username);
		return password;
	}

	@Override
	public boolean insert(User user) {
		this.getSqlMapClientTemplate().insert("user.insert", user);
		return true;
	}

	@Override
	public boolean deleteUserByUsername(String username) {
		this.getSqlMapClientTemplate().delete("user.deleteUserByUsername",
				username);
		return true;
	}

	@Override
	public List<User> select() {
		List<User> list = this.getSqlMapClientTemplate().queryForList(
				"user.select");
		return list;
	}

	@Override
	public User selectUserByUsername(String username) {
		User user = (User) this.getSqlMapClientTemplate().queryForObject(
				"user.selectUserByUsername", username);
		return user;
	}

	@Override
	public boolean delete() {
		this.getSqlMapClientTemplate().delete("user.delete");
		return true;
	}

	@Override
	public boolean update(User user) {
		int i = 0;
		i = this.getSqlMapClientTemplate().update("user.update", user);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePassword(User user) {
		int i = 0;
		i = this.getSqlMapClientTemplate().update("user.updatePassword", user);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(int userId, String icon) {
		int i = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", String.valueOf(userId));
		map.put("icon", String.valueOf(icon));
		i = this.getSqlMapClientTemplate().update("user.updateIcon", map);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(int userId, char noLogin) {
		int i = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", String.valueOf(userId));
		map.put("noLogin", String.valueOf(noLogin));
		i = this.getSqlMapClientTemplate().update("user.updateNoLogin", map);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update2(User user) {
		// TODO Auto-generated method stub
		int i = 0;
		i = this.getSqlMapClientTemplate().update("user.update2", user);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(String username, int checkEmail) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("checkEmail", Integer.valueOf(checkEmail));
		int i = this.getSqlMapClientTemplate().update("user.updateCheckEmail",
				map);
		if (i == 1)
			return true;
		return false;
	}

}
