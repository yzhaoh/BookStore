package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.Book;
import com.bs.bean.BookSales;
import com.bs.dao.BookSalesDao;

/**
 * BookSalesDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class BookSalesDaoImpl extends SqlMapClientDaoSupport implements
		BookSalesDao {

	@Override
	public List<Book> selectSalesTop(int number) {
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectSalesTop", number);
		return list;
	}

	@Override
	public List<Book> selectSalesTimeTop(int number) {
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectSalesTimeTop", number);
		return list;
	}

	@Override
	public boolean update(int bookId, int nowNumber) {
		Map map = new HashMap();
		map.put("bookId", bookId);
		map.put("nowNumber", nowNumber);
		int i = 0;
		i = this.getSqlMapClientTemplate().update("bookSales.updateNowNumber",
				map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean update(int bookId, String date) {
		Map map = new HashMap();
		map.put("bookId", bookId);
		map.put("date", date);
		int i = 0;
		i = this.getSqlMapClientTemplate().update("bookSales.updateDate", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int select(int bookId) {
		Object ob = this.getSqlMapClientTemplate().queryForObject(
				"bookSales.selectNowNumber", bookId);
		if (ob != null) {
			return (int) ob;
		} else {
			return 0;
		}
	}

	@Override
	public boolean insert(BookSales bookSales) {
		this.getSqlMapClientTemplate().insert("bookSales.insert", bookSales);
		return true;
	}

	@Override
	public List<BookSales> select(int start, int number) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", Integer.valueOf(start));
		map.put("number", Integer.valueOf(number));
		return this.getSqlMapClientTemplate().queryForList("bookSales.select",
				map);
	}

	@Override
	public int selectCount() {
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"bookSales.selectCount");
	}

	@Override
	public int selectKeyCount(String keyword) {
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"bookSales.selectKeyCount", keyword);
	}

	@Override
	public List<BookSales> select(String salesKeywords, int start, int number) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("salesKeywords", salesKeywords);
		map.put("start", Integer.valueOf(start));
		map.put("number", Integer.valueOf(number));
		return this.getSqlMapClientTemplate().queryForList(
				"bookSales.selectKey", map);
	}

}
