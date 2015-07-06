package com.bs.serviceImpl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.bs.bean.DeliveryAddress;
import com.bs.dao.DeliveryAddressDao;
import com.bs.dao.OrderDao;
import com.bs.service.DeliveryAddressService;

/**
 * 收货地址模块（DeliveryAddressService）接口实现
 * 
 * @author 若水
 *
 */
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

	private DeliveryAddressDao deliveryAddressDao;
	private OrderDao orderDao;

	public DeliveryAddressDao getDeliveryAddressDao() {
		return deliveryAddressDao;
	}

	public void setDeliveryAddressDao(DeliveryAddressDao deliveryAddressDao) {
		this.deliveryAddressDao = deliveryAddressDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public boolean addAddress(DeliveryAddress deliveryAddress) {
		// TODO Auto-generated method stub
		if (deliveryAddress != null) {
			deliveryAddressDao.insert(deliveryAddress);
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean alterAddress(DeliveryAddress deliveryAddress) {
		// TODO Auto-generated method stub
		if (deliveryAddress != null) {
			if(orderDao.selectAddress(deliveryAddress.getAddressId())){
				deliveryAddressDao.update(deliveryAddress.getAddressId());
				deliveryAddressDao.insert(deliveryAddress);
			}else{
				deliveryAddressDao.update(deliveryAddress);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int addressId) {
		// TODO Auto-generated method stub
		if(orderDao.selectAddress(addressId)){
			return deliveryAddressDao.update(addressId);
		}
		return deliveryAddressDao.delete(addressId);
	}

	@Override
	public DeliveryAddress getAddress(int addressId) {
		// TODO Auto-generated method stub
		return deliveryAddressDao.select(addressId);
	}

	@Override
	public List<DeliveryAddress> getAllAddress(int userId) {
		// TODO Auto-generated method stub
		return deliveryAddressDao.selectAll(userId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean setDefaultAddress(int userId, int addressId) {
		// TODO Auto-generated method stub
		int defaultAdd = deliveryAddressDao.selectDefault(userId);
		deliveryAddressDao.update(defaultAdd, 1);
		deliveryAddressDao.update(addressId, 0);
		return true;
	}

}
