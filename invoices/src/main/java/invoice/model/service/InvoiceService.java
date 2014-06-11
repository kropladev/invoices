package invoice.model.service;

import invoice.model.enties.Invoice;

import java.util.List;

public interface InvoiceService {
	void add(Invoice invoice);
	void edit(Invoice invoice);
	void delete(int invId);
	Invoice getInvoice(int invId);
	List getAllInvoices();
}
