package store.dao;

import java.util.List;

import store.logic.Category;

public interface CategoryDao {
	List findAllCategory();
	List findAllCategory(int parent);
	void entry(Category category);
	void delete(int id);
	Category get(int id);
	void update(Category category);
}
