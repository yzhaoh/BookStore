package com.bs.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bs.bean.ShoppingCart;
import com.bs.service.ShoppingCartService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 处理与购物车模块相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class ShoppingCartAction extends ActionSupport implements
		ModelDriven<ShoppingCart>, SessionAware {

	private static final long serialVersionUID = 1L;
	private ShoppingCartService shoppingCartService;
	private ShoppingCart shoppingCart;
	private List<ShoppingCart> shoppingCarts;
	private Map<String, Object> session;

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	@Override
	public ShoppingCart getModel() {
		this.shoppingCart = new ShoppingCart();
		return this.shoppingCart;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String shoppingCarts() {
		this.shoppingCarts = shoppingCartService.getBooks((String) session
				.get("username"));
		return SUCCESS;
	}

	public String buy() {
		Object userId = session.get("userId");
		if (userId != null) {
			shoppingCart.setUserId((int) userId);
			boolean b = shoppingCartService.getBook(shoppingCart.getUserId(),
					shoppingCart.getBookId());
			if (b) {
				shoppingCartService.alterNumber(shoppingCart);
			} else {
				shoppingCartService.addBook(shoppingCart);
			}
		} else {
			boolean add = false;
			List<ShoppingCart> list;
			Object shoppingCarts = session.get("shoppingCarts");
			if (shoppingCarts != null) {
				list = (List<ShoppingCart>) shoppingCarts;
				for (ShoppingCart shoppingCart : list) {
					if (shoppingCart.getBookId() == this.shoppingCart
							.getBookId()) {
						shoppingCart.setNumber(shoppingCart.getNumber() + 1);
						add = true;
						break;
					}
				}
			} else {
				list = new ArrayList<ShoppingCart>();
			}
			if (add == false) {
				list.add(shoppingCart);
			}
			session.put("shoppingCarts", list);
		}
		return SUCCESS;
	}

	public String delete() {
		Object userId = session.get("userId");
		if (userId != null) {
			shoppingCart.setUserId((int) userId);
			shoppingCartService.deleteBook(shoppingCart);
		} else {
			Object shoppingCarts = session.get("shoppingCarts");
			if (shoppingCarts != null) {
				List<ShoppingCart> list = (List<ShoppingCart>) shoppingCarts;
				for (ShoppingCart shoppingCart : list) {
					if (shoppingCart.getBookId() == this.shoppingCart
							.getBookId()) {
						list.remove(shoppingCart);
						session.put("shoppingCarts", list);
						break;
					}
				}
			}
		}
		return SUCCESS;
	}

	public String deleteAll() {
		Object userId = session.get("userId");
		if (userId != null) {
			shoppingCart.setUserId((int) userId);
			shoppingCartService.deleteBooks(shoppingCart);
		} else {
			session.remove("shoppingCarts");
		}
		return SUCCESS;
	}
}
