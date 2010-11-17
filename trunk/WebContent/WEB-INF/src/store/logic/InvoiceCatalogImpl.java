package store.logic;

import java.util.List;
import store.dao.InvoiceDao;

public class InvoiceCatalogImpl implements InvoiceCatalog {

	private InvoiceDao invoiceDao;
	
	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}
	
	public List<Invoice> getPage(int pagenum) {
		return invoiceDao.getPage(pagenum);
	}

	public Invoice getInvoice(int invoiceId) {
		return invoiceDao.getInvoice(invoiceId);
	}
	
	public void updateInvoice(Invoice invoice) {
		invoiceDao.updateInvoice(invoice);
	}
	
	public Invoice createInovice() {
		return invoiceDao.createInvoice();
	}
	
	public List<Invoice> getInvoiceList(String email, String id) {
		return invoiceDao.findAll(email, id);
	}
}
