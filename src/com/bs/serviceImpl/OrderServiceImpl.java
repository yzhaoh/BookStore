package com.bs.serviceImpl;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import com.bs.bean.Book;
import com.bs.bean.DeliveryAddress;
import com.bs.bean.Order;
import com.bs.dao.DeliveryAddressDao;
import com.bs.dao.OrderDao;
import com.bs.service.OrderService;

/**
 * 订单（OrderService）模块接口实现
 * 
 * @author 若水
 *
 */
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	private DeliveryAddressDao deliveryAddressDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public DeliveryAddressDao getDeliveryAddressDao() {
		return deliveryAddressDao;
	}

	public void setDeliveryAddressDao(DeliveryAddressDao deliveryAddressDao) {
		this.deliveryAddressDao = deliveryAddressDao;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean submitOrder(Order order) {
		// TODO Auto-generated method stub
		if (order != null) {
			int orderId=orderDao.insert(order);
			for (Map<String, Integer> map : order.getBook()) {
				orderDao.insert(orderId, map.get("bookId"),
						map.get("number"));
			}
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updateDeliveryAddress(int orderId,
			DeliveryAddress deliveryAddress) {
		// TODO Auto-generated method stub
		if (deliveryAddress != null) {
			int addressId = deliveryAddressDao.insert(deliveryAddress);
			orderDao.update(orderId, addressId);
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		orderDao.deleteOrderDetail(orderId);
		orderDao.deleteOrderBasic(orderId);
		return true;
	}

	@Override
	public List<Order> getAll(int userId, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return orderDao.selectAll(userId, (pageNow - 1) * pageSize, pageSize);
	}

	@Override
	public List<Order> getOrderByIsPayed(int userId, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return orderDao.selectOrderByIsPayed(userId, (pageNow - 1) * pageSize,
				pageSize);
	}

	@Override
	public Order get(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.select(orderId);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return orderDao.selectCount();
	}

	@Override
	public List<Order> getOrders(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return orderDao.select((pageNow - 1) * pageSize, pageSize);
	}

	@Override
	public int getKeyTotal(String keyword) {
		// TODO Auto-generated method stub
		if (keyword != null) {
			return orderDao.selectKeyCount(keyword);
		}
		return 0;
	}

	@Override
	public List<Order> getOrders(String keyword, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		if (keyword != null) {
			return orderDao.select(keyword, (pageNow - 1) * pageSize, pageSize);
		}
		return null;
	}

	@Override
	public List<Book> getBooks(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.selectBooks(orderId);
	}

	@Override
	public List<Order> getAll(int userId) {
		return orderDao.selectAll(userId);
	}

	@Override
	public boolean pay(int orderId) {
		return orderDao.update(orderId);
	}

}
