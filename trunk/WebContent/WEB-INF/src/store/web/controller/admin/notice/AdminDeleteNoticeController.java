package store.web.controller.admin.notice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminDeleteNoticeController implements Controller 
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
			shopService.deleteNotice(Integer.parseInt(req.getParameter("nid")));
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
		Map model = new HashMap();
		model.put(WebConstants.NOTICE_LIST, shopService.getAllNotice());
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.noticeDelSucc");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
