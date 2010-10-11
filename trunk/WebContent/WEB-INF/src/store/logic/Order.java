package store.logic;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
	private int orderId;
	private int invoiceId;
	private int itemId;
	private String productName;
	private int amount;
	private String price;
	private String status;   // waiting pay, payed, preparing, waiting pickup, sent, returned, withdrawn
	private Date createDate;
	private Date lastUpdate;
	private List options;
	
	
	public Order() {
		options = new ArrayList();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List getOptions() {
		return this.options;
	}
	public int numOptions() {
		return this.options.size();
	}
	public void remove(int i) {
		this.options.remove(i);
	}
	public void addOption(Option option) {
		this.options.add(option);
	}
}
