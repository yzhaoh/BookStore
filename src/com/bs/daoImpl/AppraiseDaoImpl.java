package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.Appraise;
import com.bs.dao.AppraiseDao;

/**
 * AppraiseDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class AppraiseDaoImpl extends SqlMapClientDaoSupport implements
		AppraiseDao {

	@Override
	public boolean insert(Appraise appraise) {
		this.getSqlMapClientTemplate().insert("appraise.insert", appraise);
		return true;
	}

	@Override
	public boolean update(int orderId, int bookId, String mallanswer) {
		Map map = new HashMap();
		map.put("orderId", orderId);
		map.put("bookId", bookId);
		map.put("mallanswer", mallanswer);
		int i = 0;
		i = this.getSqlMapClientTemplate().update("appraise.update", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean delete(int orderId, int bookId) {
		Map map = new HashMap();
		map.put("orderId", orderId);
		map.put("bookId", bookId);
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("appraise.delete", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public Appraise select(int orderId, int bookId) {
		Map map = new HashMap();
		map.put("orderId", orderId);
		map.put("bookId", bookId);
		Appraise appraise = (Appraise) this.getSqlMapClientTemplate()
				.queryForObject("appraise.select", map);
		return appraise;
	}

	@Override
	public List<Appraise> select(int bookId, int start, int number) {
		Map map = new HashMap();
		map.put("bookId", bookId);
		map.put("start", start - 1);
		map.put("number", number);
		List<Appraise> list = this.getSqlMapClientTemplate().queryForList(
				"appraise.selectByBookId", map);
		return list;
	}

	@Override
	public List<Appraise> selectAll(int start, int number) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("number", number);
		List<Appraise> list = this.getSqlMapClientTemplate().queryForList(
				"appraise.selectAll", map);
		return list;
	}

	@Override
	public int selectCount() {
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"appraise.selectCount");
	}

}
