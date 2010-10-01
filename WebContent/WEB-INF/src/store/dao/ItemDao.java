package store.dao;

import java.util.List;

public interface ItemDao 
{
	List findAll();
	List findEvent(int index);
	List getPage(int page);
	Integer getNumPage();
}
