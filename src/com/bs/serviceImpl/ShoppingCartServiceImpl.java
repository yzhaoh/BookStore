package com.bs.serviceImpl;

import java.util.List;
import com.bs.bean.ShoppingCart;
import com.bs.dao.ShoppingCartDao;
import com.bs.service.ShoppingCartService;

/**
 * 购物车(ShoppingCartService)模块接口实现
 * 
 * @author 若水
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartDao shoppingCartDao;

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	@Override
	public boolean addBook(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		if (shoppingCart != null)
			return shoppingCartDao.insert(shoppingCart);
		return false;
	}

	@Override
	public boolean deleteBook(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		if (shoppingCart != null)
			return shoppingCartDao.delete(shoppingCart.getUserId(),
					shoppingCart.getBookId());
		return false;
	}

	@Override
	public boolean deleteBooks(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		if (shoppingCart != null)
			return shoppingCartDao.delete(shoppingCart.getUserId());
		return false;
	}

	@Override
	public boolean alterNumber(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		if (shoppingCart != null)
			return shoppingCartDao.update(shoppingCart);
		return false;
	}

	@Override
	public List<ShoppingCart> getBooks(int userId) {
		// TODO Auto-generated method stub
		return shoppingCartDao.select(userId);
	}

	@Override
	public List<ShoppingCart> getBooks(String username) {
		// TODO Auto-generated method stub
		return shoppingCartDao.select(username);
	}

	@Override
	public boolean getBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		if (shoppingCartDao.select(userId, bookId) > 0) {
			return true;
		}
		return false;
	}

}
