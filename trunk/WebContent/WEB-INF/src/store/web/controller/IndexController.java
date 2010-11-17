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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		Map model = new HashMap();
		
		model.put("categoryList", this.shopService.getChildCategory(WebConstants.TOP_CATEGORY));
		model.put("itemList", this.shopService.getItemList());
		model.put("noticeList", this.shopService.getAllNotice());
		
		// get a list of special event.
		List events = (List) this.shopService.getAllEvent();
		
		// get lists of event products
		for (int i = 0; i < events.size(); i++ ) {
			Event event = (Event) events.get(i);
			int eventId = event.getEventId().intValue();
			
			List items = this.shopService.getEventItemList(eventId);
			event.setItems(items);
		}
		model.put("eventList", events);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
	
	

}
