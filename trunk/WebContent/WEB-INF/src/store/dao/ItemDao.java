package store.dao;

import java.util.List;

import store.logic.Item;

public interface ItemDao 
{
	List<Item> findAll();
	List<Item> findEvent(int index);
	List<Item> getPage(int page);
	Integer getNumPage();
	void entry(Item item);
	void delete(int id);
	void update(Item item);
	Item get(int id);
	List<Item> getByCategory(int category);
}
