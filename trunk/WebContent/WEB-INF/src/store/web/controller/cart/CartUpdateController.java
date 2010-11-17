package store.web.controller.cart;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.logic.Order;
import store.logic.Shop;
import store.web.WebConstants;

public class CartUpdateController implements Controller 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	@SuppressWarnings({ "unchecked" })
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect.cart");

		int id = 0, amount = 0;
		String cmd = null;
		
		try {
			id = Integer.parseInt(req.getParameter("id"));
			amount = Integer.parseInt(req.getParameter("amount"));
			cmd = req.getParameter("cmd").trim();

			List<Order> cart = (List<Order>) req.getSession(true).getAttribute(WebConstants.CART);
			if (cart == null || cart.size() < id) {
				modelAndView.setViewName("redirect.cart");
			}
			else {
				if (cmd.equalsIgnoreCase("delete")) {
					cart.remove(id - 1);
				}
				else if (cmd.equalsIgnoreCase("update")) {
					if (amount <= 0) {
						cart.remove(id - 1);
					}
					else {
						cart.get(id-1).setAmount(amount);
					}
				}
				else 
					throw new Exception("Item id is invalid.");
				
				if (cart.size() == 0)
						req.getSession().removeAttribute(WebConstants.CART);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return modelAndView;
	}
}
