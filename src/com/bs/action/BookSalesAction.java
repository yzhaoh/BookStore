package com.bs.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bs.bean.BookSales;
import com.bs.service.BookSalesService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理与图书销售模块相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class BookSalesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * 图书编号
	 */
	private int bookId;
	/**
	 * 已售数量
	 */
	private int soldNumber;
	/**
	 * 现存数量
	 */
	private int nowNumber;
	/**
	 * 上架时间
	 */
	private Date salesTime;
	private BookSalesService bookSalesService;
	private Map<String, Object> status;
	private List<BookSales> bookSales;
	/**
	 * 当前第几页
	 */
	private int page;
	/**
	 * 每页多少条记录
	 */
	private int limit;
	/**
	 * 图书销售总记录数
	 */
	private int total;
	private String keyword;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSoldNumber() {
		return soldNumber;
	}

	public void setSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}

	public int getNowNumber() {
		return nowNumber;
	}

	public void setNowNumber(int nowNumber) {
		this.nowNumber = nowNumber;
	}

	public Date getSalesTime() {
		return salesTime;
	}

	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}

	public BookSalesService getBookSalesService() {
		return bookSalesService;
	}

	public void setBookSalesService(BookSalesService bookSalesService) {
		this.bookSalesService = bookSalesService;
	}

	public Map<String, Object> getStatus() {
		return status;
	}

	public void setStatus(Map<String, Object> status) {
		this.status = status;
	}

	public List<BookSales> getBookSales() {
		return bookSales;
	}

	public void setBookSales(List<BookSales> bookSales) {
		this.bookSales = bookSales;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAllSales() {
		this.total = bookSalesService.getTotal();
		this.bookSales = bookSalesService.getBookSales(page, limit);
		return SUCCESS;
	}

	public String search() {
		this.total = bookSalesService.getKeyTotal(keyword);
		this.bookSales = bookSalesService.getBookSales(keyword, page, limit);
		return SUCCESS;
	}

	public String alterNumber() {
		this.status = new HashMap<String, Object>();
		boolean b = bookSalesService.alterInventory(bookId, nowNumber);
		if (b) {
			status.put("success", true);
		} else {
			status.put("failure", false);
		}
		return SUCCESS;
	}
}
