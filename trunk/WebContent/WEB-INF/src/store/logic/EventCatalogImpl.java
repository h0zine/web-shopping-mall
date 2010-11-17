package store.logic;

import java.util.List;

import store.dao.EventDao;

public class EventCatalogImpl implements EventCatalog {

	private EventDao eventDao;
	
	public void setEventDao(EventDao eventDao)
	{
		this.eventDao = eventDao;
	}
	
	public List<Event> findAllEvent() {
		return this.eventDao.findAllEvent();
	}

	public void entry(Event event) {
		this.eventDao.add(event);
	}
	
	public void delete(int id) {
		this.eventDao.delete(id);
	}
	
	public Event get(int id) {
		return this.eventDao.get(id);
	}
	
	public void update(Event event) {
		this.eventDao.update(event);
	}
}
