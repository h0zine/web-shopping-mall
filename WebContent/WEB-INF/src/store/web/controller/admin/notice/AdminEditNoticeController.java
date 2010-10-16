package store.web.controller.admin.notice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import store.logic.Shop;
import store.logic.Notice;
import store.web.WebConstants;

public class AdminEditNoticeController extends SimpleFormController 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
	    if(!isFormSubmission(request)) {
	    	
	    	Notice notice = null;
	        
	        try {
	        	notice = shopService.getNotice(Integer.parseInt(request.getParameter("nid")));
	        } catch (Exception e) { e.printStackTrace(System.err); }
	        
	        return notice;
	    }
	    else {
	        return super.formBackingObject(request);
	    }
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		Notice notice = (Notice) cmd;

		try {
			shopService.updateNotice(notice);
			
			Map model = new HashMap();
			model.put(WebConstants.NOTICE_LIST, shopService.getAllNotice());
			
			// Have to return ModelAndView object... don't forget this!
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			modelAndView.addAllObjects(model);
			
			return modelAndView;
		}
		catch (Exception e) {
			exception.reject("error.update");
			e.printStackTrace(System.err);
			return showForm(req, res, exception);
		}
	}
}
