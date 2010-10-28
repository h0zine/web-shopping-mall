package store.web.controller.cart;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Shop;
import store.logic.Item;
import store.logic.Order;
import store.web.WebConstants;

public class CartAddController implements Controller 
{
	private Shop shopService;
	
	public Shop getShopService() {
		return this.shopService;
	}
	
	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		int itemId, amount;
		ModelAndView modelAndView = null;
		
		try {
			itemId = Integer.parseInt(req.getParameter("item"));
			amount = Integer.parseInt(req.getParameter("amount"));
		} 
		catch (Exception e) {
			e.printStackTrace(System.err);
			modelAndView = new ModelAndView("redirect.category");
			return modelAndView;
		}

		modelAndView = new ModelAndView();
		modelAndView.setViewName("cartAdded");
		
		Order order = new Order();
		Item item = shopService.getItem(itemId);
		
		order.setAmount(amount);
		order.setCreateDate(new java.util.Date());
		order.setItemId(itemId);
		order.setLastUpdate(new java.util.Date());
		order.setPrice(item.getPrice().toString());
		order.setProductName(item.getItemName());
		order.setStatus(WebConstants.ORDER_STATUS[0]);
		
		List cart = (List) req.getSession(true).getAttribute(WebConstants.CART);
		
		if (cart == null) {
			cart = new ArrayList();
			cart.add(order);
			//modelAndView.addObject(WebConstants.CART, cart);
			req.getSession(true).setAttribute(WebConstants.CART, cart);		
		}
		else {
			cart.add(order);
		}
		
		return modelAndView;
	}
}
