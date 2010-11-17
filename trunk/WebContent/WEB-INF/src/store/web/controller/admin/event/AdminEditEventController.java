package store.web.controller.admin.event;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import store.logic.Shop;
import store.logic.Event;
import store.web.WebConstants;

public class AdminEditEventController extends SimpleFormController 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
	    if(!isFormSubmission(request)) {
	    	
	        Event event = null;
	        
	        try {
	        	event = shopService.getEvent(Integer.parseInt(request.getParameter("id")));
	        } catch (Exception e) {}
	        
	        return event;
	    }
	    else {
	        return super.formBackingObject(request);
	    }
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		Event event = (Event) cmd;

		shopService.updateEvent(event);
		
		Map model = new HashMap();
		model.put(WebConstants.EVENT_LIST, shopService.getAllEvent());
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
}
