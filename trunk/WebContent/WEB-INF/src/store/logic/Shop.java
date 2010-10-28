package store.logic;

import java.util.List;

public interface Shop 
{
	// Item related methods
	List getItemList();						// get all item list
	List getEventItemList(int index);		// get all item included in given event
	List getItemsPage(int page);			// get a page of item
	Integer getItemsPages();				// get how many pages of item list
	void entryItem(Item item);				// add an item
	void deleteItem(int id);				// delete an item
	void updateItem(Item item);				// update an item
	Item getItem(int id);					// get an item with item index
	List getItemByCategory(int category);	// get a list of item belong to a category
	
	// Category related methods
	List getChildCategory(int parent);		// get a list of child category
	List getAllCategory();					// get a list of all category
	void entryCategory(Category category);	// add a category
	void deleteCategory(int id);			// delete a category
	Category getCategory(int id);			// get a category by index id
	void updateCategory(Category category);	// update a category
	List findAllDesCategory(int parent);	// get a list of all descendant category
	List getCategoryPath(int category);		// find a path to a category
	
	// Event related methods
	List getAllEvent();						// get a list of all event
	void entryEvent(Event event);			// add an event
	void deleteEvent(int id);				// delete an event with event id
	Event getEvent(int id);					// get a detail of event
	void updateEvent(Event event);			// update an event
	
	// Invoice related method
	List getInvoicePage(int pagenum);		// get a page of invoice list
	Invoice getInvoice(int invoiceId);		// get a detail of invoice
	void updateInvoice(Invoice invoice);	// update a invoice
	
	// Order method
	List getOrderByInvoiceId(int invoiceId);// get a list of order which are included in a invoice
	Order getOrder(int orderId);			// get a detail of order
	void updateOrder(Order order);			// update an order
	
	// Feedback methods
	List getFeedbackPage(int page);			// get a page of all feedback
	void addFeedback(Feedback feedback);	// add a feedback
	void deleteFeedback(int feedbackId);	// delete a feedback
	List getItemFeedback(int itemId);		// get a list of feedback for an item
	
	// User method
	void entryUser(User user);				// add an user
	List getUserListPage(int page);			// get a page of user list
	User getUserById(String id);			// get details for a user
	void updateUser(User user);				// update user details
	
	// notice method
	void addNotice(Notice notice);			// add a notice
	void deleteNotice(int noticeId);		// delete a notice
	void updateNotice(Notice notice);		// update a notice
	Notice getNotice(int noticeId);			// get details of notice
	List getAllNotice();					// get a list of all notice
	
}
