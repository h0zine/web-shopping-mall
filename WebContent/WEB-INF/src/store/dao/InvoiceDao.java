package store.dao;

import java.util.List;
import store.logic.Invoice;

public interface InvoiceDao {
	List<Invoice> getPage(int pagenum);
	Invoice getInvoice(int invoiceId);
	void updateInvoice(Invoice invoice);
	Invoice createInvoice();
	List<Invoice> findAll(String email, String id);
}
