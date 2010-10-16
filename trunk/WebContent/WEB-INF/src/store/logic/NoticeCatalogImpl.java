package store.logic;

import java.util.List;
import store.dao.NoticeDao;

public class NoticeCatalogImpl implements NoticeCatalog {
	
	NoticeDao dao;
	
	public void setNoticeDao(NoticeDao dao) {
		this.dao = dao;
	}

	public void add(Notice notice) {
		dao.add(notice);
	}

	public void delete(int noticeId) {
		dao.delete(noticeId);
	}

	public void update(Notice notice) {
		dao.update(notice);
	}

	public Notice get(int noticeId) {
		return dao.get(noticeId);
	}

	public List getAll() {
		return dao.getAll();
	}

}
