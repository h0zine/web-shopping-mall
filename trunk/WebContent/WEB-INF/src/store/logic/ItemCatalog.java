package store.logic;

import java.util.List;

public interface ItemCatalog {
	List getItemList();
	List getEventItemList(int index);
	List getPage(int page);
	Integer getNumPages();
	void entry(Item item);
	void delete(int id);
	void update(Item item);
	Item getItem(int id);
	List getItemByCategory(int category);
}
