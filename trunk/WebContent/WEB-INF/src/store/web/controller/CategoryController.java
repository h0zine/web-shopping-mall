package store.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Category;
import store.logic.Shop;
import store.web.WebConstants;

public class CategoryController implements Controller {
	
	private Shop shopService;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int categoryId;
		try {
			categoryId = Integer.parseInt(req.getParameter("cid"));
		}
		catch (Exception e) {
			categoryId = 0;
			
			//ModelAndView modelAndView = new ModelAndView();
			//modelAndView.setViewName("redirect.index");
			//return modelAndView;
		}
		
		Map model = new HashMap();
		List categories = null;

		if (categoryId == 0) {
			categories = this.shopService.getAllCategory();
		}
		else {
			categories = this.shopService.findAllDesCategory(categoryId);
		}
		ArrayList allItems = new ArrayList();
		
		Category ca = null;
		for (int i = 0; i < categories.size(); i++) {
			ca = (Category) categories.get(i);
			List items = this.shopService.getItemByCategory(ca.getId().intValue());
			allItems.addAll(items);
		}
		
		model.put("topCategoryList", this.shopService.getChildCategory(WebConstants.TOP_CATEGORY));
		if (categoryId != 0)
			model.put("categoryList", this.shopService.findAllDesCategory(ca.getThread().intValue()));
		else
			model.put("categoryList", this.shopService.getAllCategory());
		
		model.put("itemList", allItems);
		model.put("categoryId", new Integer(categoryId));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("category");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
}
