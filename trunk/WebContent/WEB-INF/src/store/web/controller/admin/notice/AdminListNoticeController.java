package store.web.controller.admin.notice;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.web.WebConstants;
import store.logic.Shop;

public class AdminListNoticeController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.notice");
		modelAndView.addObject(WebConstants.NOTICE_LIST, this.shopService.getAllNotice());

		return modelAndView;
	}
}
