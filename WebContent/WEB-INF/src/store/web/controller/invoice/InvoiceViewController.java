package store.web.controller.invoice;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Shop;
import store.logic.Invoice;
import store.web.WebConstants;

public class InvoiceViewController extends SimpleFormController 
{
	private Shop shopService;
	
	public Shop getShopService() {
		return this.shopService;
	}
	
	public void setShopService(Shop shop) {
		this.shopService = shop;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String email = req.getParameter("email");
		String pinCode = req.getParameter("pin_code");
		
		ModelAndView modelAndView = new ModelAndView();

		if (email == null || pinCode == null) {
			modelAndView.setViewName("invoiceListAuth");
		}
		else {
			List<Invoice> invoices = shopService.getInvoiceList(email, pinCode);
			if (invoices == null || invoices.size() == 0) {
				modelAndView.setViewName("invoiceListAuth");
				System.out.println("invalid Email/Pin number used.");
			}
			else {
				Map model = new HashMap();
				model.put(WebConstants.INVOICE_LIST, invoices);
				modelAndView.setViewName("invoiceList");
				modelAndView.addAllObjects(model);
			}
		}
		// Have to return ModelAndView object... don't forget this!
		return modelAndView;
	}
}
