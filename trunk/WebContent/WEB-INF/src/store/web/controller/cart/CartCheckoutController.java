package store.web.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import store.web.WebConstants;
import store.logic.Order;
import store.logic.Shop;
import store.logic.Invoice;

public class CartCheckoutController extends SimpleFormController 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	protected Object formBackingObject(HttpServletRequest req) throws Exception
	{
	    if(!isFormSubmission(req)) {
			Invoice invoice = new Invoice();
			
			@SuppressWarnings("unchecked")
			List<Order> cart = (List<Order>) req.getSession(true).getAttribute(WebConstants.CART);

			int deliveryCost = 100, productCost = 0;
			for (int i = 0; i < cart.size(); i++) {
				productCost += Integer.parseInt(cart.get(i).getPrice()) * cart.get(i).getAmount();
			}

			invoice.setDeliveryCost("" + deliveryCost);
			invoice.setProductCost("" + productCost);

			return invoice;
	    }
	    else {
	        return super.formBackingObject(req);
	    }
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException exception) throws Exception
	{

		@SuppressWarnings("unchecked")
		List<Order> cart = (List<Order>) req.getSession(true).getAttribute(WebConstants.CART);
		Invoice invoice = (Invoice) cmd;
		invoice.setId(shopService.createInvoice(cart).getId());
		invoice.setIssueDate(new java.util.Date());
		invoice.setLastUpdate(new java.util.Date());

		int deliveryCost = 100, productCost = 0;
		for (int i = 0; i < cart.size(); i++) {
			productCost += Integer.parseInt(cart.get(i).getPrice()) * cart.get(i).getAmount();
		}

		invoice.setDeliveryCost("" + deliveryCost);
		invoice.setProductCost("" + productCost);

		shopService.updateInvoice(invoice);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("checkoutSucc");
		
		return modelAndView;
	}
}
