package store.dao;

import java.util.List;
import store.logic.Notice;

public interface NoticeDao 
{
	void add(Notice notice);
	Notice get(int noticeId);
	void delete(int noticeId);
	void update(Notice notice);
	List getAll();
}
