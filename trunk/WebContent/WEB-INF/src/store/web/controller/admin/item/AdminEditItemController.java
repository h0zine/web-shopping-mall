package store.web.controller.admin.item;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
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
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
	    if(!isFormSubmission(request)) {
	    	
	        Item item = null;
	        
	        try {
	        	item = shopService.getItem(Integer.parseInt(request.getParameter("id")));
	        	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+item);
	        } catch (Exception e) {}
	        
	        return item;
	    }
	    else {
	        return super.formBackingObject(request);
	    }
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		Item item = (Item) cmd;

		try {
			this.shopService.updateItem(item);
			
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			return modelAndView;
		}
		catch (DataIntegrityViolationException e) 
		{
			exception.reject("error.duplicate");
			return showForm(req, res, exception);
		}
	}
}
