package pl.kropladev.invoice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.kropladev.invoice.model.dao.InvoiceDao;
import pl.kropladev.invoice.model.enties.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceDao invoiceD;
	
	@Transactional
	public void add(Invoice invoice) {
		invoiceD.add(invoice);
	}	
	

	@Transactional
	public void edit(Invoice invoice) {
		invoiceD.edit(invoice);
	}

	@Transactional
	public void delete(int invId) {
		invoiceD.delete(invId);
	}

	@Transactional
	public Invoice getInvoice(int invId) {
		return invoiceD.getInvoice(invId);
	}

	@Transactional
	public List getAllInvoices() {
		return invoiceD.getAllInvoices();
	}

}
