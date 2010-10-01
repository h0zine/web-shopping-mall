package store.logic;

import java.util.List;

public class ShopImpl implements Shop {

	private ItemCatalog itemCatalog;
	private UserCatalog userCatalog;
	private CategoryCatalog categoryCatalog;
	private EventCatalog eventCatalog;
	
	
	// item
	public void setItemCatalog(ItemCatalog itemCatalog)
	{
		this.itemCatalog = itemCatalog;
	}
	
	public List getItemList() 
	{
		return this.itemCatalog.getItemList();
	}
	
	public List getItemsPage(int page)
	{
		return this.itemCatalog.getPage(page);
	}
	
	public Integer getItemsPages()
	{
		return this.itemCatalog.getNumPages();
	}

	// event item
	public List getEventItemList(int index)
	{
		return this.itemCatalog.getEventItemList(index);
	}
	
	// Category
	public void setCategoryCatalog(CategoryCatalog categoryCatalog)
	{
		this.categoryCatalog = categoryCatalog;
	}
	
	public List getChildCategory(int parent)
	{
		return this.categoryCatalog.getList(parent);
	}
	
	public List getAllCategory()
	{
		return this.categoryCatalog.getAllList();
	}
	
	public void entryCategory(Category category)
	{
		this.categoryCatalog.entry(category);
	}
	
	public void deleteCategory(int id)
	{
		this.categoryCatalog.delete(id);
	}
	
	public Category getCategory(int id)
	{
		return this.categoryCatalog.get(id);
	}
	
	public void updateCategory(Category category)
	{
		this.categoryCatalog.update(category);
	}
	
	// Events
	public void setEventCatalog(EventCatalog eventCatalog)
	{
		this.eventCatalog = eventCatalog;
	}
	
	public List getAllEvent()
	{
		return this.eventCatalog.findAllEvent();
	}

	// user 
	public void setUserCatalog(UserCatalog userCatalog)
	{
		this.userCatalog = userCatalog;
	}
	
	public void entryUser(User user) 
	{
		this.userCatalog.entryUser(user);
	}
}
