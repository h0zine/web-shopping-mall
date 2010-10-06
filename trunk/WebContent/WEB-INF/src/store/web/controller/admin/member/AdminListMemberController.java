package store.web.controller.admin.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;

public class AdminListMemberController implements Controller 
{
	private Shop shopService;
	
	public Shop getShopService() 
	{
		return this.shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		return null;
	}
}
