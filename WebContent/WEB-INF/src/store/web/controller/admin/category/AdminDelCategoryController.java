package store.web.controller.admin.category;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminDelCategoryController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		try {
			shopService.deleteCategory(Integer.parseInt(req.getParameter("id")));
		} catch (Exception e) {}
		
		Map model = new HashMap();
		model.put(WebConstants.CATEGORY_LIST, shopService.getAllCategory());
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.category");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
