package store.logic;

import java.util.List;
import store.logic.Notice;

public interface NoticeCatalog {
	void add(Notice notice);
	void delete(int noticeId);
	void update(Notice notice);
	Notice get(int noticeId);
	List getAll();
}
