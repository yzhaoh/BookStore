package com.bs.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.bs.bean.BookCollection;
import com.bs.dao.BookCollectionDao;

/**
 * BookCollectionDao接口实现
 * 
 * @author zhao
 *
 */
@SuppressWarnings("deprecation")
public class BookCollectionDaoImpl extends SqlMapClientDaoSupport implements
		BookCollectionDao {

	@Override
	public boolean add(BookCollection bookCollection) {
		this.getSqlMapClientTemplate().insert("bookCollection.add",
				bookCollection);
		return true;
	}

	@Override
	public boolean delete(int userId, int bookId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("bookId", bookId);
		int i = 0;
		i = this.getSqlMapClientTemplate().delete("bookCollection.delete", map);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<BookCollection> select(int userId) {
		List<BookCollection> list = this.getSqlMapClientTemplate()
				.queryForList("bookCollection.select", userId);
		return list;
	}

}
