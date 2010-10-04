package store.dao;

import java.util.List;

import store.logic.Item;

public interface ItemDao 
{
	List findAll();
	List findEvent(int index);
	List getPage(int page);
	Integer getNumPage();
	void entry(Item item);
	void delete(int id);
	void update(Item item);
}
