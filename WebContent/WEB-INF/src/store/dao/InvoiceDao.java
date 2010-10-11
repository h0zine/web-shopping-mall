package store.dao;

import java.util.List;
import store.logic.Invoice;

public interface InvoiceDao {
	List getPage(int pagenum);
	Invoice getInvoice(int invoiceId);
	void updateInvoice(Invoice invoice);
}
