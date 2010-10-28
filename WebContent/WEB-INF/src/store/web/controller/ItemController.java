package store.web.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Shop;

public class ItemController implements Controller {
	
	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int itemId;
		int categoryId;
		try {
			itemId = Integer.parseInt(req.getParameter("id"));
			categoryId = Integer.parseInt(req.getParameter("cid"));
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect.index");
			return modelAndView;
		}
		
		Map model = new HashMap();
		
		model.put("item", this.shopService.getItem(itemId));
		model.put("path", this.shopService.getCategoryPath(categoryId));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("itemDetail");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
	
	

}
