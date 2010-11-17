package store.logic;

import java.util.List;

public interface EventCatalog {
	List<Event> findAllEvent();

	void entry(Event event);
	void delete(int id);
	Event get(int id);
	void update(Event event);
}
