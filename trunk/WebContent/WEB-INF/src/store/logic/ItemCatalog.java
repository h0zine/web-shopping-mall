package store.logic;

import java.util.List;

public interface ItemCatalog {
	List getItemList();
	List getEventItemList(int index);
	List getPage(int page);
	Integer getNumPages();
}
