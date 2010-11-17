package store.web.form;

import java.util.List;
import org.apache.struts.action.ActionForm;

import store.logic.Item;

public class ItemMenuForm extends ActionForm 
{
	private static final long serialVersionUID = -6763302049401887931L;

	private List<Item> itemList;
	
	public List<Item> getItemList()
	{
		return this.itemList;
	}
	
	public void setItemList(List<Item> itemList)
	{
		this.itemList = itemList;
	}
}
