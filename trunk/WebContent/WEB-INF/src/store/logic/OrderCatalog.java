package store.logic;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface OrderCatalog {
	public List findAll();
	public List findAll(int invoiceId);
	public Order find(int orderId);
	public void add(Order order);
	public void remove(int orderId);	
	public void update(Order order);
}
