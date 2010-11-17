package store.web.controller.admin.invoice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.logic.Shop;
import store.web.WebConstants;

public class AdminInvoiceListController extends SimpleFormController 
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
		int pagenum;
		try {
			pagenum = Integer.getInteger(req.getParameter("pn")).intValue();
		} 
		catch (Exception e) {
			pagenum = 0;
		}
		
		Map model = new HashMap();
		model.put(WebConstants.INVOICE_LIST, shopService.getInvoicePage(pagenum));
		
		// Have to return ModelAndView object... don't forget this!
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin.invoiceList");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
}
