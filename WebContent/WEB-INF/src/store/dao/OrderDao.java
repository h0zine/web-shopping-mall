package store.dao;

import java.util.List;
import store.logic.Order;

@SuppressWarnings("rawtypes")
public interface OrderDao 
{
	List  selectAll();
	List  selectByInvoice(int invoiceId);
	Order selectOrder(int orderId);
	void  insert(Order order);
	void  delete(int orderId);
	void  deleteByInvoice(int invoiceId);
	void  update(Order order);
}
