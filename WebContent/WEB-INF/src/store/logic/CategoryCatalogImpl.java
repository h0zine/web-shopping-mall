package store.logic;

import java.util.List;
import store.dao.CategoryDao;

public class CategoryCatalogImpl implements CategoryCatalog 
{
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao)
	{
		this.categoryDao = categoryDao;
	}
	
	public List<Category> getList(int parent)
	{
		return this.categoryDao.findAllCategory(parent);
	}
	
	public List<Category> getAllList()
	{
		return this.categoryDao.findAllCategory();
	}
	
	public void entry(Category category)
	{
		this.categoryDao.entry(category);
	}
	
	public void delete(int id)
	{
		this.categoryDao.delete(id);
	}
	
	public Category get(int id)
	{
		return this.categoryDao.get(id);
	}
	
	public void update(Category category) 
	{
		this.categoryDao.update(category);
	}
	
	public List<Category> findAllDescendant(int parent) {
		return this.categoryDao.findAllDescendant(parent);
	}
	
	public List<Category> getPath(int category) {
		return this.categoryDao.getPath(category);
	}
}
