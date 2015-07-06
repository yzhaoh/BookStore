package com.bs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bs.bean.DeliveryAddress;
import com.bs.service.DeliveryAddressService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 处理与收货地址模块相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class DeliveryAddressAction extends ActionSupport implements
		ModelDriven<DeliveryAddress>, SessionAware {

	private static final long serialVersionUID = 1L;
	private DeliveryAddressService deliveryAddressService;
	private DeliveryAddress deliveryAddress;
	private List<DeliveryAddress> deliveryAddresses;
	private Map<String, Object> session;

	public void setDeliveryAddressService(
			DeliveryAddressService deliveryAddressService) {
		this.deliveryAddressService = deliveryAddressService;
	}

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<DeliveryAddress> getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(List<DeliveryAddress> deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public DeliveryAddressService getDeliveryAddressService() {
		return deliveryAddressService;
	}

	@Override
	public DeliveryAddress getModel() {
		this.deliveryAddress = new DeliveryAddress();
		return this.deliveryAddress;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String add() {
		deliveryAddress.setDefaultaddress("1");
		deliveryAddress.setDeleteOrUpdate("1");
		boolean b = deliveryAddressService.addAddress(deliveryAddress);
		if (b)
			return SUCCESS;
		return INPUT;
	}

	public String delete() {
		deliveryAddressService.delete(deliveryAddress.getAddressId());
		return SUCCESS;
	}

	public String alter() {
		deliveryAddress.setDefaultaddress("1");
		deliveryAddress.setDeleteOrUpdate("1");
		deliveryAddressService.alterAddress(deliveryAddress);
		return SUCCESS;
	}

	public String allAddress() {
		Object userId = this.session.get("userId");
		if (userId != null) {
			this.deliveryAddresses = deliveryAddressService
					.getAllAddress((int) userId);
		}
		return SUCCESS;
	}

}
