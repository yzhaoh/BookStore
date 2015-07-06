package com.bs.daoImpl;

import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.BookCategory;
import com.bs.dao.BookCategoryDao;

/**
 * BookCategoryDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class BookCategoryDaoImpl extends SqlMapClientDaoSupport implements
		BookCategoryDao {

	@Override
	public boolean insert(BookCategory bookCategory) {
		this.getSqlMapClientTemplate().insert("bookCategory.insert",
				bookCategory);
		return true;
	}

	@Override
	public boolean update(BookCategory bookCategory) {
		int i = 0;
		i = this.getSqlMapClientTemplate().update("bookCategory.update",
				bookCategory);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<BookCategory> select() {
		return this.getSqlMapClientTemplate().queryForList(
				"bookCategory.selectAllCategory");
	}

	@Override
	public boolean delete(int categoryId) {
		this.getSqlMapClientTemplate()
				.delete("bookCategory.delete", categoryId);
		return true;
	}

	@Override
	public int selectCount(int categoryId) {
		return (int) this.getSqlMapClientTemplate().queryForObject(
				"bookCategory.selectCount", categoryId);
	}

}
