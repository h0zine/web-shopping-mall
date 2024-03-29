package store.logic;

import java.util.List;
import store.dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog 
{
	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao)
	{
		this.itemDao = itemDao;
	}
	
	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}
	
	public List<Item> getEventItemList(int index) {
		return this.itemDao.findEvent(index);
	}
	
	public List<Item> getPage(int page) {
		return this.itemDao.getPage(page);
	}
	
	public Integer getNumPages() {
		return this.itemDao.getNumPage();
	}

	public void entry(Item item) {
		this.itemDao.entry(item);
	}
	public void delete(int id) {
		this.itemDao.delete(id);
	}
	public void update(Item item) {
		this.itemDao.update(item);
	}
	public Item getItem(int id) {
		return this.itemDao.get(id);
	}
	public List<Item> getItemByCategory(int category) {
		return this.itemDao.getByCategory(category);
	}
}
