package store.logic;

import java.util.List;

public interface CategoryCatalog {
	List<Category> getList(int parent);
	List<Category> getAllList();
	List<Category> findAllDescendant(int parent);
	List<Category> getPath(int category);
	
	void entry(Category category);
	void delete(int id);
	Category get(int id);
	void update(Category category);
}
