package store.logic;

import java.util.List;

public interface Shop 
{
	// Item related methods
	List getItemList();
	List getEventItemList(int index);
	List getItemsPage(int page);
	Integer getItemsPages();
	
	// Category related methods
	List getChildCategory(int parent);
	List getAllCategory();
	void entryCategory(Category category);
	void deleteCategory(int id);
	Category getCategory(int id);
	void updateCategory(Category category);
	
	// Event related methods
	List getAllEvent();
	
	void entryUser(User user);
}
