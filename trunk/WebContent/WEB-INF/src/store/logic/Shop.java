package store.logic;

import java.util.List;

public interface Shop 
{
	// Item related methods
	List getItemList();
	List getEventItemList(int index);
	List getItemsPage(int page);
	Integer getItemsPages();
	void entryItem(Item item);
	void deleteItem(int id);
	void updateItem(Item item);
	Item getItem(int id);
	
	// Category related methods
	List getChildCategory(int parent);
	List getAllCategory();
	void entryCategory(Category category);
	void deleteCategory(int id);
	Category getCategory(int id);
	void updateCategory(Category category);
	
	// Event related methods
	List getAllEvent();
	void entryEvent(Event event);
	void deleteEvent(int id);
	Event getEvent(int id);
	void updateEvent(Event event);
	
	// Invoice related method
	List getInvoicePage(int pagenum);
	Invoice getInvoice(int invoiceId);
	void updateInvoice(Invoice invoice);
	
	// Order method
	List getOrderByInvoiceId(int invoiceId);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	
	// Feedback methods
	List getFeedbackPage(int page);
	void addFeedback(Feedback feedback);
	void deleteFeedback(int feedbackId);
	List getItemFeedback(int itemId);
	
	// User method
	void entryUser(User user);
	List getUserListPage(int page);
	User getUserById(String id);
	void updateUser(User user);
}
