package store.dao;

import java.util.List;

public interface OptionDao {
	void insert(List options);
	void delete(List options);
	void update(List options);
}
