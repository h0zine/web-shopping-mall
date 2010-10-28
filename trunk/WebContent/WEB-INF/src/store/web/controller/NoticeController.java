package store.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.logic.Notice;

public class NoticeController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int id;
		ModelAndView modelAndView = new ModelAndView();

		try {
			id = Integer.parseInt(req.getParameter("nid"));
		} 
		catch (Exception e) {
			e.printStackTrace(System.err);
			modelAndView.setViewName("redirect.index");
			return modelAndView;
		}

		try {
			Notice notice = shopService.getNotice(id);
		
			Map model = new HashMap();
			model.put("notice", notice);
			modelAndView.setViewName("notice");
			
			// Have to return ModelAndView object... don't forget this!
			modelAndView.addAllObjects(model);
			
			return modelAndView;
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
			modelAndView.setViewName("redirect.index");
			return modelAndView;
		}
	}
}
