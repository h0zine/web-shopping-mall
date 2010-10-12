package store.logic;

import java.util.List;

public class ShopImpl implements Shop {

	private ItemCatalog itemCatalog;
	private UserCatalog userCatalog;
	private CategoryCatalog categoryCatalog;
	private EventCatalog eventCatalog;
	private InvoiceCatalog invoiceCatalog;
	private OrderCatalog orderCatalog;
	
	
	// item
	public void setItemCatalog(ItemCatalog itemCatalog)
	{
		this.itemCatalog = itemCatalog;
	}
	
	public List getItemList() 
	{
		return this.itemCatalog.getItemList();
	}
	
	public List getItemsPage(int page)
	{
		return this.itemCatalog.getPage(page);
	}
	
	public Integer getItemsPages()
	{
		return this.itemCatalog.getNumPages();
	}

	public void entryItem(Item item) {
		this.itemCatalog.entry(item);
	}
	
	public void deleteItem(int id) {
		this.itemCatalog.delete(id);
	}
	
	public void updateItem(Item item) {
		this.itemCatalog.update(item);
	}
	
	public Item getItem(int id) {
		return this.itemCatalog.getItem(id);
	}

	// event item
	public List getEventItemList(int index)
	{
		return this.itemCatalog.getEventItemList(index);
	}
	
	// Category
	public void setCategoryCatalog(CategoryCatalog categoryCatalog)
	{
		this.categoryCatalog = categoryCatalog;
	}
	
	public List getChildCategory(int parent)
	{
		return this.categoryCatalog.getList(parent);
	}
	
	public List getAllCategory()
	{
		return this.categoryCatalog.getAllList();
	}
	
	public void entryCategory(Category category)
	{
		this.categoryCatalog.entry(category);
	}
	
	public void deleteCategory(int id)
	{
		this.categoryCatalog.delete(id);
	}
	
	public Category getCategory(int id)
	{
		return this.categoryCatalog.get(id);
	}
	
	public void updateCategory(Category category)
	{
		this.categoryCatalog.update(category);
	}
	
	// Events
	public void setEventCatalog(EventCatalog eventCatalog)
	{
		this.eventCatalog = eventCatalog;
	}
	
	public List getAllEvent()
	{
		return this.eventCatalog.findAllEvent();
	}
	
	public void entryEvent(Event event) {
		this.eventCatalog.entry(event);
	}
	
	public void deleteEvent(int id) {
		this.eventCatalog.delete(id);
	}
	
	public Event getEvent(int id) {
		return this.eventCatalog.get(id);
	}
	
	public void updateEvent(Event event) {
		this.eventCatalog.update(event);
	}
	
	
	// Invoice
	public void setInvoiceCatalog(InvoiceCatalog invoiceCatalog) {
		this.invoiceCatalog = invoiceCatalog;
	}
	
	public List getInvoicePage(int pagenum) {
		return this.invoiceCatalog.getPage(pagenum);
	}
	
	public Invoice getInvoice(int invoiceId) {
		return this.invoiceCatalog.getInvoice(invoiceId);
	}
	public void updateInvoice(Invoice invoice) {
		this.invoiceCatalog.updateInvoice(invoice);
	}
	
	// Order
	
	public void setOrderCatalog(OrderCatalog orderCatalog) {
		this.orderCatalog = orderCatalog;
	}
	
	public List getOrderByInvoiceId(int invoiceId) {
		return this.orderCatalog.findAll(invoiceId);
	}
	
	public Order getOrder(int orderId) {
		return this.orderCatalog.find(orderId);
	}
	
	public void updateOrder(Order order) {
		this.orderCatalog.update(order);
	}

	// user 
	public void setUserCatalog(UserCatalog userCatalog)
	{
		this.userCatalog = userCatalog;
	}
	
	public void entryUser(User user) 
	{
		this.userCatalog.entryUser(user);
	}
}
