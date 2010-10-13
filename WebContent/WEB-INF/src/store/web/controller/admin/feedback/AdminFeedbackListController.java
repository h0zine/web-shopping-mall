package store.web.controller.admin.feedback;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.web.WebConstants;
import store.logic.Shop;

public class AdminFeedbackListController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int page;
		try {
			page = Integer.parseInt(req.getParameter("pn"));
			if (page <= 0) page = 1;
		}
		catch (Exception e) {
			page = 1;
		}
		
		Map model = new HashMap();
		model.put(WebConstants.FEEDBACK_LIST, shopService.getFeedbackPage(page));
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.feedback");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
