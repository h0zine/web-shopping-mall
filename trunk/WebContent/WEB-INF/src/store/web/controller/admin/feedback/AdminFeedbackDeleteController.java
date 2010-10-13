package store.web.controller.admin.feedback;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminFeedbackDeleteController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		int feedbackId;
		try {
			feedbackId = Integer.parseInt(req.getParameter("fid"));
			shopService.deleteFeedback(feedbackId);
		}
		catch (Exception e) {}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.feedback");
		modelAndView.addObject(WebConstants.FEEDBACK_LIST, shopService.getFeedbackPage(1));
		
		return modelAndView;
	}
}
