package com.bs.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.bs.bean.Book;
import com.bs.bean.DeliveryAddress;
import com.bs.bean.Order;
import com.bs.service.BookService;
import com.bs.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理与订单模块相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class OrderAction extends ActionSupport implements SessionAware,
		RequestAware {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单编号
	 */
	private int orderId;
	/**
	 * 用户编号
	 */
	private int userId;
	/**
	 * 收货地址编号
	 */
	private int addressId;
	/**
	 * 订单日期
	 */
	private Date orderDate;
	/**
	 * 是否付款
	 */
	private String ispayed;
	/**
	 * 付款方式
	 */
	private String paymode;
	/**
	 * 总价
	 */
	private float totalprice;
	/**
	 * 当前第几页
	 */
	private int page;
	/**
	 * 每页多少条记录
	 */
	private int limit;
	/**
	 * 图书总数
	 */
	private int total;
	/**
	 * 收货地址
	 */
	private String address;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 收货人
	 */
	private String deliveryPerson;
	/**
	 * 邮编
	 */
	private String postcode;
	private OrderService orderService;
	private BookService bookService;
	private List<Order> order;
	private Map<String, Object> status;
	private String keyword;
	private List<Book> books;
	private Map<String, Object> session;
	private Map<String, Object> request;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getIspayed() {
		return ispayed;
	}

	public void setIspayed(String ispayed) {
		this.ispayed = ispayed;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Map<String, Object> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Object> status) {
		this.status = status;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String getAllOrder() {
		this.total = orderService.getTotal();
		this.order = orderService.getOrders(page, limit);
		return SUCCESS;
	}

	public String search() {
		this.total = orderService.getKeyTotal(keyword);
		this.order = orderService.getOrders(keyword, page, limit);
		return SUCCESS;
	}

	public String getBooksByOrderId() {
		this.setBooks(orderService.getBooks(orderId));
		return SUCCESS;
	}

	public String alterOrder() {
		this.status = new HashMap<String, Object>();
		DeliveryAddress deliveryAddress = new DeliveryAddress();
		deliveryAddress.setUserId(userId);
		deliveryAddress.setAddress(address);
		deliveryAddress.setPhone(phone);
		deliveryAddress.setDeliveryPerson(deliveryPerson);
		deliveryAddress.setPostcode(postcode);
		deliveryAddress.setDefaultaddress("1");
		deliveryAddress.setDeleteOrUpdate("1");
		boolean b = orderService
				.updateDeliveryAddress(orderId, deliveryAddress);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String delete() {
		this.status = new HashMap<String, Object>();
		boolean b = orderService.deleteOrder(orderId);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}

	public String userOrders() {
		Object userId = session.get("userId");
		if (userId != null) {
			this.order = orderService.getAll((int) userId);
			request.put("order", this.order);
			return SUCCESS;
		}
		return ERROR;
	}

	public String pay() {
		orderService.pay(orderId);
		return SUCCESS;
	}

	public String submitOrder() {
		Object userId = this.getSession().get("userId");
		if (userId != null) {
			Order order = new Order();
			order.setUserId((int) userId);
			order.setAddressId(addressId);
			order.setIspayed("1");
			order.setOrderDate(new Date());
			order.setPaymode("在线付款");
			List<Map<String, Integer>> listBook = new ArrayList<Map<String, Integer>>();
			float totalPrice = 0.00f;
			for (Book book : books) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				int bookId = book.getBookId();
				int number = book.getNumber();
				map.put("bookId", bookId);
				map.put("number", number);
				float currentPrice = bookService.get(bookId).getCurrentPrice();
				float price = currentPrice * number;
				totalPrice += price;
				listBook.add(map);
			}
			order.setTotalprice(totalPrice);
			order.setBook(listBook);
			orderService.submitOrder(order);
			return SUCCESS;
		}
		return ERROR;
	}

}
