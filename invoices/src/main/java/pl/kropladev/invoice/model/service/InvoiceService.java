package pl.kropladev.invoice.model.service;

import java.util.List;

import pl.kropladev.invoice.model.enties.Invoice;

public interface InvoiceService {
	void add(Invoice invoice);
	void edit(Invoice invoice);
	void delete(int invId);
	Invoice getInvoice(int invId);
	List getAllInvoices();
}
