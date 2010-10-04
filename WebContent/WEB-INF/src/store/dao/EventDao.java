package store.dao;

import java.util.List;
import store.logic.Event;

public interface EventDao {
	List findAllEvent();
	void add(Event event);
	void delete(int id);
	Event get(int id);
	void update(Event event);
}
