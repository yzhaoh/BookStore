package com.bs.action;

import java.util.Date;
import java.util.List;

import com.bs.bean.Appraise;
import com.bs.service.AppraiseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 处理与评价模块相关的接收页面数据，跳转控制。
 * 
 * @author 若水
 *
 */
public class AppraiseAction extends ActionSupport implements
		ModelDriven<Appraise> {
	private static final long serialVersionUID = 1L;
	private AppraiseService appraiseService;
	private Appraise appraise;
	private List<Appraise> appraises;
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

	@Override
	public Appraise getModel() {
		this.appraise = new Appraise();
		return this.appraise;
	}

	public AppraiseService getAppraiseService() {
		return appraiseService;
	}

	public void setAppraiseService(AppraiseService appraiseService) {
		this.appraiseService = appraiseService;
	}

	public Appraise getAppraise() {
		return appraise;
	}

	public void setAppraise(Appraise appraise) {
		this.appraise = appraise;
	}

	public List<Appraise> getAppraises() {
		return appraises;
	}

	public void setAppraises(List<Appraise> appraises) {
		this.appraises = appraises;
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

	public String appraise() {
		appraise.setStarLevel("5");
		appraise.setAppraiseTime(new Date());
		this.appraiseService.appraise(appraise);
		return SUCCESS;
	}

	public String allAppraise() {
		this.total = appraiseService.getCount();
		this.setAppraises(appraiseService.getAppraises(page, limit));
		return SUCCESS;
	}
}
