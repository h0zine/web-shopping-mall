package store.web.controller.admin.member;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.validation.BindException;
import org.springframework.dao.DataIntegrityViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Shop;
import store.logic.User;

public class AdminAddMemberController extends SimpleFormController 
{
	private Shop shopService;
	
	public Shop getShopService() 
	{
		return this.shopService;
	}
	
	public void setShopService(Shop shop) 
	{
		this.shopService = shop;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{
		// Casting command
		Item item = (Item) cmd;

		item.setVisit(new Integer(0));
		item.setSold(new Integer(0));
		item.setLastSold(new java.util.Date());
		item.setLastVisit(new java.util.Date());
		item.setLastUpdate(new java.util.Date());

		try {
			this.shopService.entryItem(item);
			
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			return modelAndView;
		}
		catch (DataIntegrityViolationException e) 
		{
			exception.reject("error.duplicate");
			return showForm(req, res, exception);
		}
	}
}
