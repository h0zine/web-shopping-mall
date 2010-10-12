package store.web.controller.admin.invoice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import store.logic.Shop;
import store.logic.Invoice;

public class AdminInvoiceDetailController extends SimpleFormController 
{
	Shop shopService;
	
	public void setShopService(Shop shopService)
	{
		this.shopService = shopService;
	}
	
	protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "issueDate", new CustomDateEditor(dateFormat,false));
		binder.registerCustomEditor(Date.class, "lastUpdate", new CustomDateEditor(dateFormat,false));
	}
	
	protected Map referenceData(HttpServletRequest request) throws Exception 
	{
		return null;
	}
	
	protected Object formBackingObject(HttpServletRequest req) throws Exception
	{
	    if(!isFormSubmission(req)) {
			int invoiceId;
			try {
				invoiceId = Integer.parseInt(req.getParameter("id"));
			} 
			catch (Exception e) {
				invoiceId = -1;
			}
			
			Invoice invoice = shopService.getInvoice(invoiceId);
			invoice.setOrder(shopService.getOrderByInvoiceId(invoiceId));
			return invoice;
	    }
	    else {
	        return super.formBackingObject(req);
	    }
	}
	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, 
									Object cmd, BindException exception) throws Exception
	{
		Invoice invoice = (Invoice) cmd;
		try {
			shopService.updateInvoice(invoice);
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			return modelAndView;
		}
		catch (Exception e) {
			exception.reject("error.updatefailed");
			return showForm(req, res, exception);
		}
	}
}
