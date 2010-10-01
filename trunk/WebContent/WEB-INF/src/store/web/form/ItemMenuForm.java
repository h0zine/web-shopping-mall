package store.web.form;

import java.util.List;
import org.apache.struts.action.ActionForm;

public class ItemMenuForm extends ActionForm 
{
	private static final long serialVersionUID = -6763302049401887931L;

	private List itemList;
	
	public List getItemList()
	{
		return this.itemList;
	}
	
	public void setItemList(List itemList)
	{
		this.itemList = itemList;
	}
}
