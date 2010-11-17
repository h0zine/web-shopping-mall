package store.web.controller.admin.item;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import store.logic.Shop;
import store.logic.Item;
import store.web.WebConstants;

public class AdminEditItemController extends SimpleFormController 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Map referenceData(HttpServletRequest request) throws Exception 
	{
		//System.out.println("referenceData()");
		Map map = new HashMap();
		map.put(WebConstants.CATEGORY_LIST, this.shopService.getAllCategory());
		map.put(WebConstants.EVENT_LIST, this.shopService.getAllEvent());
		return map;
	}

	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
	    if(!isFormSubmission(request)) 
	    {
	        Item item = null;
	        
	        try 
	        {
	        	item = shopService.getItem(Integer.parseInt(request.getParameter("id")));
	        } 
	        catch (Exception e) {}
	        
	        return item;
	    }
	    else 
	    {
	        return super.formBackingObject(request);
	    }
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		Item item = (Item) cmd;

		try {
			Item origItem = this.shopService.getItem(item.getItemId().intValue());
			
			origItem.setItemName(item.getItemName());
			origItem.setPrice(item.getPrice());
			origItem.setPictureUrl(item.getPictureUrl());
			origItem.setAmount(item.getAmount());
			origItem.setCategoryId1(item.getCategoryId1());
			origItem.setCategoryId2(item.getCategoryId2());
			origItem.setCategoryId3(item.getCategoryId3());
			origItem.setEventId1(item.getEventId1());
			origItem.setEventId2(item.getEventId2());
			origItem.setEventId3(item.getEventId3());
			origItem.setDescription(item.getDescription());
			
			this.shopService.updateItem(origItem);
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			return modelAndView;
		}
		catch (Exception e) 
		{
			e.printStackTrace(System.err);
			exception.reject("error.duplicate");
			return showForm(req, res, exception);
		}
	}
}
