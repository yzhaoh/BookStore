package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.Book;
import com.bs.dao.BookDao;

/**
 * BookDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class BookDaoImpl extends SqlMapClientDaoSupport implements BookDao {

	@Override
	public int insert(Book book) {
		return (int) this.getSqlMapClientTemplate().insert("book.insert", book);
	}

	@Override
	public boolean delete(int bookId) {
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("book.delete", bookId);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete() {
		this.getSqlMapClientTemplate().delete("book.deleteAll");
		return true;
	}

	@Override
	public List<Book> select() {
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectAll");
		return list;
	}

	@Override
	public List<Book> select(int start, int number) {
		Map map = new HashMap();
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectStart", map);
		return list;
	}

	@Override
	public Book select(String bookId) {
		Book book = (Book) this.getSqlMapClientTemplate().queryForObject(
				"book.selectByBookId", bookId);
		return book;
	}

	@Override
	public List<Book> selectBookByBookName(String bookName, int start,
			int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectBookByAuthor(String author, int start, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectBookByPublisherr(String publisher, int start,
			int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectBookByISBN(String ISBN, int start, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Book book) {
		int i = 0;
		i = this.getSqlMapClientTemplate().update("book.update", book);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Book> selectBookBySalesASC(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBookBySalesASC", map);
		return list;
	}

	@Override
	public List<Book> selectBookBySalesDESC(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBookBySalesDESC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByPriceASC(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBookByPriceASC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByPriceDESC(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBookByPriceDESC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByAppraiseASC(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBookByAppraiseASC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByAppraiseDESC(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBookByAppraiseDESC", map);
		return list;
	}

	@Override
	public List<Book> selectBookBySalesASC(int categoryid, int start, int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBySalesASC", map);
		return list;
	}

	@Override
	public List<Book> selectBookBySalesDESC(int categoryid, int start,
			int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectBySalesDESC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByPriceASC(int categoryid, int start, int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectByPriceASC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByPriceDESC(int categoryid, int start,
			int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectByPriceDESC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByAppraiseASC(int categoryid, int start,
			int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectByAppraiseASC", map);
		return list;
	}

	@Override
	public List<Book> selectBookByAppraiseDESC(int categoryid, int start,
			int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectByAppraiseDESC", map);
		return list;
	}

	@Override
	public List<Book> select(int categoryid, int start, int number) {
		Map map = new HashMap();
		map.put("categoryid", categoryid);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectById", map);
		return list;
	}

	@Override
	public List<Book> select(String str, int start, int number) {
		Map map = new HashMap();
		map.put("str", str);
		map.put("start", start - 1);
		map.put("number", number);
		List<Book> list = this.getSqlMapClientTemplate().queryForList(
				"book.selectByStr", map);
		return list;
	}

	@Override
	public int selectCount() {
		String count = this.getSqlMapClientTemplate()
				.queryForObject("book.selectCount").toString();
		return Integer.parseInt(count);
	}

	@Override
	public boolean update(int bookId, String image) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("bookId", String.valueOf(bookId));
		map.put("image", image);
		int i = this.getSqlMapClientTemplate().update("book.updateImage", map);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int selectKeyCount(String keyword) {
		// TODO Auto-generated method stub
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"book.selectKeyCount", keyword);
	}

}
