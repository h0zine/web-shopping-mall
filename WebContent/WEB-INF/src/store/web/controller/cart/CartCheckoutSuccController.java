package store.web.controller.cart;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import store.web.WebConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartCheckoutSuccController implements Controller 
{
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		req.getSession().removeAttribute(WebConstants.CART);
		ModelAndView modelAndView = new ModelAndView("checkoutSuccJsp");
		return modelAndView;
	}
}
