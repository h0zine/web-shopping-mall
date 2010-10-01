package store.logic;

import java.util.List;

public interface CategoryCatalog {
	List getList(int parent);
	List getAllList();
	void entry(Category category);
	void delete(int id);
	Category get(int id);
	void update(Category category);
}
