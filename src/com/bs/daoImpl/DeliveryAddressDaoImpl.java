package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.DeliveryAddress;
import com.bs.dao.DeliveryAddressDao;

/**
 * DeliveryAddressDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class DeliveryAddressDaoImpl extends SqlMapClientDaoSupport implements
		DeliveryAddressDao {

	@Override
	public int insert(DeliveryAddress deliveryAddress) {
		return (int) this.getSqlMapClientTemplate().insert(
				"deliveryAddress.insert", deliveryAddress);
	}

	@Override
	public boolean update(DeliveryAddress deliveryAddress) {
		System.out.println(deliveryAddress.toString());
		int i = this.getSqlMapClientTemplate().update("deliveryAddress.update",
				deliveryAddress);
		if (i == 1)
			return true;
		return false;
	}

	@Override
	public boolean delete(int addressId) {
		int i = this.getSqlMapClientTemplate().delete("deliveryAddress.delete",
				addressId);
		if (i == 1)
			return true;
		return false;
	}

	@Override
	public DeliveryAddress select(int addressId) {
		DeliveryAddress deliveryAddress = (DeliveryAddress) this
				.getSqlMapClientTemplate().queryForObject(
						"deliveryAddress.selectByAddressId", addressId);
		return deliveryAddress;
	}

	@Override
	public List<DeliveryAddress> selectAll(int userId) {
		List<DeliveryAddress> list = this.getSqlMapClientTemplate()
				.queryForList("deliveryAddress.selectAllByUserId", userId);
		return list;
	}

	@Override
	public boolean update(int addressId, int defaultAddress) {
		Map map = new HashMap();
		map.put("addressId", addressId);
		map.put("defaultAddress", defaultAddress);
		int i = 0;
		i = this.getSqlMapClientTemplate().update(
				"deliveryAddress.updateDefaultAddress", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean update(int addressId) {
		Map map = new HashMap();
		map.put("addressId", addressId);
		int i = 0;
		i = this.getSqlMapClientTemplate().update(
				"deliveryAddress.updateDeleteOrUpdate", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int selectDefault(int userId) {
		int i = (int) this.getSqlMapClientTemplate().queryForObject(
				"deliveryAddress.selectDefaultAddress", userId);
		return i;
	}

}
