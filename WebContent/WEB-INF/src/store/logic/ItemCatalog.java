package store.logic;

import java.util.List;

public interface ItemCatalog {
	List<Item> getItemList();
	List<Item> getEventItemList(int index);
	List<Item> getPage(int page);
	Integer getNumPages();
	void entry(Item item);
	void delete(int id);
	void update(Item item);
	Item getItem(int id);
	List<Item> getItemByCategory(int category);
}
