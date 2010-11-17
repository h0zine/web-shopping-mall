package store.logic;

import java.util.List;
import store.logic.Invoice;

public interface InvoiceCatalog {
	List<Invoice> getPage(int pagenum);
	Invoice getInvoice(int invoiceId);
	void updateInvoice(Invoice invoice);
	Invoice createInovice();		// this method create an invoice and return it
	List<Invoice> getInvoiceList(String email, String id);
}
