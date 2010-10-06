package store.dao;

import java.util.List;
import store.logic.User;

public interface UserDao {
	void create(User user);
	User getById(String id);
	User getByEmail(String email);
	void deleteById(String id);
	void deleteByEmail(String email);
	List getAllList();
	List getPageList(int page);
	void updateById(User user);
	void updateByEmail(User user);
}
