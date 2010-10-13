package store.logic;

import java.util.List;

import store.dao.UserDao;

public class UserCatalogImpl implements UserCatalog {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void entryUser(User user) {
		this.userDao.create(user);
	}

	public List getListPage(int page) {
		return this.userDao.getPageList(page);
	}
}
