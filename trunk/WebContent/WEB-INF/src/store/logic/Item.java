package store.logic;

import java.util.Date;

public class Item 
{
	private Integer itemId;
	private String  itemName;
	private Integer price;
	private String  description;
	private String  pictureUrl;
	private Integer visit;
	private Integer sold;
	private Integer amount; // amount in stock
	private Date    lastSold;
	private Date    lastVisit;
	private Date    lastUpdate;
	private Integer categoryId1;
	private Integer categoryId2;
	private Integer categoryId3;
	private Integer eventId1;
	private Integer eventId2;
	private Integer eventId3;

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Integer getVisit() {
		return visit;
	}
	public void setVisit(Integer visit) {
		this.visit = visit;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getLastSold() {
		return lastSold;
	}
	public void setLastSold(Date lastSold) {
		this.lastSold = lastSold;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Integer getCategoryId1() {
		return categoryId1;
	}
	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}
	public Integer getCategoryId2() {
		return categoryId2;
	}
	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}
	public Integer getCategoryId3() {
		return categoryId3;
	}
	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}
	public Integer getEventId1() {
		return eventId1;
	}
	public void setEventId1(Integer eventId1) {
		this.eventId1 = eventId1;
	}
	public Integer getEventId2() {
		return eventId2;
	}
	public void setEventId2(Integer eventId2) {
		this.eventId2 = eventId2;
	}
	public Integer getEventId3() {
		return eventId3;
	}
	public void setEventId3(Integer eventId3) {
		this.eventId3 = eventId3;
	}
}
