package com.bs.serviceImpl;

import java.util.List;
import com.bs.bean.Appraise;
import com.bs.dao.AppraiseDao;
import com.bs.service.AppraiseService;

/**
 * 评价（AppraiseService）模块接口实现
 * 
 * @author 若水
 *
 */
public class AppraiseServiceImpl implements AppraiseService {

	private AppraiseDao appraiseDao;

	public AppraiseDao getAppraiseDao() {
		return appraiseDao;
	}

	public void setAppraiseDao(AppraiseDao appraiseDao) {
		this.appraiseDao = appraiseDao;
	}

	@Override
	public boolean appraise(Appraise appraise) {
		// TODO Auto-generated method stub
		if (appraise != null)
			return appraiseDao.insert(appraise);
		return false;
	}

	@Override
	public boolean mallAnswerAppraise(int orderId, int bookId, String mallanswer) {
		// TODO Auto-generated method stub
		if (mallanswer != null)
			return appraiseDao.update(orderId, bookId, mallanswer);
		return false;
	}

	@Override
	public boolean deleteMallAnswerAppraise(int orderId, int bookId) {
		// TODO Auto-generated method stub
		return appraiseDao.update(orderId, bookId, "");
	}

	@Override
	public boolean deleteAppraise(int orderId, int bookId) {
		// TODO Auto-generated method stub
		return appraiseDao.delete(orderId, bookId);
	}

	@Override
	public Appraise get(int orderId, int bookId) {
		// TODO Auto-generated method stub
		return appraiseDao.select(orderId, bookId);
	}

	@Override
	public List<Appraise> getAppraises(int bookId, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return appraiseDao.select(bookId, (pageNow - 1) * pageSize + 1,
				pageSize);
	}

	@Override
	public List<Appraise> getAppraises(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return appraiseDao.selectAll((pageNow - 1) * pageSize, pageSize);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return appraiseDao.selectCount();
	}

}
