package store.logic;

import java.util.List;

import store.dao.EventDao;

public class EventCatalogImpl implements EventCatalog {

	private EventDao eventDao;
	
	public void setEventDao(EventDao eventDao)
	{
		this.eventDao = eventDao;
	}
	
	public List findAllEvent() {
		return this.eventDao.findAllEvent();
	}

}
