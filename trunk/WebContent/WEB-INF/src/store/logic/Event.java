package store.logic;

import java.util.List;

public class Event 
{
	private Integer event_id;
	private String  event_name;
	private Integer event_order;
	private List<Item> items;
	
	public Integer getEventId() {
		return event_id;
	}
	public void setEventId(Integer event_id) {
		this.event_id = event_id;
	}
	public String getEventName() {
		return event_name;
	}
	public void setEventName(String event_name) {
		this.event_name = event_name;
	}
	public Integer getEventOrder() {
		return event_order == null ? new Integer(0) : event_order;
	}
	public void setEventOrder(Integer event_order) {
		this.event_order = event_order;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
