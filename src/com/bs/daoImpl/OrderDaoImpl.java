package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.Book;
import com.bs.bean.Order;
import com.bs.dao.OrderDao;

/**
 * OrderDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class OrderDaoImpl extends SqlMapClientDaoSupport implements OrderDao {

	@Override
	public int insert(Order order) {
		return (int) this.getSqlMapClientTemplate().insert("order.insert",
				order);
	}

	@Override
	public boolean insert(int orderId, int bookId, int number) {
		Map map = new HashMap();
		map.put("orderId", orderId);
		map.put("bookId", bookId);
		map.put("number", number);
		this.getSqlMapClientTemplate().insert("order.insertOrderDetail", map);
		return true;
	}

	@Override
	public boolean update(int orderId, int addressId) {
		Map map = new HashMap();
		map.put("orderId", orderId);
		map.put("addressId", addressId);
		int i = 0;
		i = (int) this.getSqlMapClientTemplate().update("order.update", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteOrderBasic(int orderId) {
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("order.deleteOrderBasic",
				orderId);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteOrderDetail(int orderId) {
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("order.deleteOrderDetail",
				orderId);
		System.out.println(i);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Order> selectAll(int userId, int start, int number) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("start", start);
		map.put("number", number);
		List<Order> list = this.getSqlMapClientTemplate().queryForList(
				"order.selectAll", map);
		return list;
	}

	@Override
	public List<Order> selectOrderByIsPayed(int userId, int start, int number) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("start", start);
		map.put("number", number);
		List<Order> list = this.getSqlMapClientTemplate().queryForList(
				"order.selectOrderByIsPayed", map);
		return list;
	}

	@Override
	public Order select(int orderId) {
		Order order = (Order) this.getSqlMapClientTemplate().queryForObject(
				"order.select", orderId);
		return order;
	}

	@Override
	public int selectCount() {
		String count = this.getSqlMapClientTemplate()
				.queryForObject("order.selectCount").toString();
		return Integer.parseInt(count);
	}

	@Override
	public List<Order> select(int start, int number) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("number", number);
		List<Order> list = this.getSqlMapClientTemplate().queryForList(
				"order.selectStart", map);
		return list;
	}

	@Override
	public int selectKeyCount(String keyword) {
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"order.selectKeyCount", keyword);
	}

	@Override
	public List<Order> select(String str, int start, int number) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("str", String.valueOf(str));
		map.put("start", Integer.valueOf(start));
		map.put("number", Integer.valueOf(number));
		List<Order> list = this.getSqlMapClientTemplate().queryForList(
				"order.selectByStr", map);
		return list;
	}

	@Override
	public List<Book> selectBooks(int orderId) {
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"order.selectBooksByOrderId", orderId);
		return list;
	}

	@Override
	public boolean selectAddress(int addressId) {
		int i = (int) this.getSqlMapClientTemplate().queryForObject(
				"order.selectAddress", addressId);
		if (i == 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<Order> selectAll(int userId) {
		List<Order> list = this.getSqlMapClientTemplate().queryForList(
				"order.selectAllByUserId", userId);
		return list;
	}

	@Override
	public boolean update(int orderId) {
		int i = this.getSqlMapClientTemplate().update("order.updateIsPayed",
				orderId);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

}
