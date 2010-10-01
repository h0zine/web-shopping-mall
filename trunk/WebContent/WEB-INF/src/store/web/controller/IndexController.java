package store.web.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Shop;
import store.logic.Event;
import store.web.WebConstants;

public class IndexController implements Controller {
	
	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		Map model = new HashMap();
		
		model.put("categoryList", this.shopService.getCategory(WebConstants.TOP_CATEGORY));
		model.put("itemList", this.shopService.getItemList());
		
		List events = (List) this.shopService.getAllEvent();
		for (int i = 0; i < events.size(); i++ )
			((List)events.get(i)).add((this.shopService.getEventItemList(((Event) events.get(i)).getEventId().intValue())));

		model.put("eventList", events);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
	
	

}
