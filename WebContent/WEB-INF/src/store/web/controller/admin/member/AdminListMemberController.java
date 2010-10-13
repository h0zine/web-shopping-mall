package store.web.controller.admin.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminListMemberController implements Controller 
{
	private Shop shopService;
	
	public void setShopService(Shop shopService) 
	{
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int page;
		try {
			page = Integer.parseInt(req.getParameter("pn"));
		}
		catch (Exception e) {
			page = 1;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.userList");
		mv.addObject(WebConstants.USER_LIST, shopService.getUserListPage(page));

		return mv;
	}
}
