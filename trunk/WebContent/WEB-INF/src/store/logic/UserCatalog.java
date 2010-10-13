package store.logic;

import java.util.List;

public interface UserCatalog {
	void entryUser(User user);
	List getListPage(int page);
	User getUserById(String id);
	void updateUser(User user);
}
