package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.ShoppingCart;
import com.bs.dao.ShoppingCartDao;

/**
 * ShoppingCartDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class ShoppingCartDaoImpl extends SqlMapClientDaoSupport implements
		ShoppingCartDao {

	@Override
	public boolean insert(ShoppingCart shoppingCart) {
		this.getSqlMapClientTemplate().insert("shoppingCart.insert",
				shoppingCart);
		return true;
	}

	@Override
	public boolean delete(int userId, int bookId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("bookId", bookId);
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("shoppingCart.delete", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean delete(int userId) {
		int i = 0;
		i = this.getSqlMapClientTemplate().delete(
				"shoppingCart.deleteByUserId", userId);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean update(ShoppingCart shoppingCart) {
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("shoppingCart.update",
				shoppingCart);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<ShoppingCart> select(int userId) {
		List<ShoppingCart> list = this.getSqlMapClientTemplate().queryForList(
				"shoppingCart.select", userId);
		return list;
	}

	@Override
	public List<ShoppingCart> select(String username) {
		List<ShoppingCart> list = this.getSqlMapClientTemplate().queryForList(
				"shoppingCart.selectByUsername", username);
		return list;
	}

	@Override
	public int select(int userId, int bookId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("bookId", bookId);
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"shoppingCart.selectCount", map);
	}

}
