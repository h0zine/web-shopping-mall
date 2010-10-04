package store.web.controller.admin.event;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminDelEventController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		try {
			shopService.deleteEvent(Integer.parseInt(req.getParameter("id")));
		} catch (Exception e) {}
		
		Map model = new HashMap();
		model.put(WebConstants.EVENT_LIST, shopService.getAllEvent());
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.event");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
