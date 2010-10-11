package store.logic;

import java.util.List;
import store.dao.OrderDao;
import store.dao.OptionDao;

public class OrderCatalogImpl implements OrderCatalog
{
	OrderDao orderDao;
	OptionDao optDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setOptDao(OptionDao optDao) {
		this.optDao = optDao;
	}
	
	public List findAll() {
		return orderDao.selectAll();
	}
	
	public List findAll(int invoiceId) {
		return orderDao.selectByInvoice(invoiceId);
	}
	
	public Order find(int orderId) {
		return orderDao.selectOrder(orderId);
	}
	
	public void add(Order order) {
		orderDao.insert(order);
		optDao.insert(order.getOptions());
	}
	
	public void remove(int orderId) {
		optDao.delete(find(orderId).getOptions());
		orderDao.delete(orderId);
	}
	
	public void update(Order order) {
		orderDao.update(order);
		optDao.update(order.getOptions());
	}
}
