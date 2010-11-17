package store.web.controller.admin.item;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminDelItemController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int page;
		try {
			shopService.deleteItem(Integer.parseInt(req.getParameter("id")));
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		
		Map model = new HashMap();
		model.put(WebConstants.ITEM_LIST, shopService.getItemsPage(page));
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.item");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
