package store.web.controller.admin.category;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import store.logic.Shop;
import store.logic.Category;
import store.web.WebConstants;

public class AdminEditCategoryController extends SimpleFormController 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
	    if(!isFormSubmission(request)) {
	    	
	        Category category = null;
	        
	        try {
	        	category = shopService.getCategory(Integer.parseInt(request.getParameter("id")));
	        } catch (Exception e) {}
	        
	        return category;
	    }
	    else {
	        return super.formBackingObject(request);
	    }
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		Category category = (Category) cmd;

		shopService.updateCategory(category);
		
		Map model = new HashMap();
		model.put(WebConstants.CATEGORY_LIST, shopService.getAllCategory());
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.category");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}
}
