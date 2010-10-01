package store.web.controller.admin.item;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminItemController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int page = 0;
		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {}
		
		Map model = new HashMap();
		model.put(WebConstants.ITEM_LIST, shopService.getItemsPage(page));
		model.put(WebConstants.ITEM_PAGE, shopService.getItemsPages());
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.category");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
