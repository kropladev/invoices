package invoice.model.service;

import invoice.model.dao.InvoiceDao;
import invoice.model.enties.Invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void delete(final int invId) {
		invoiceD.delete(invId);
	}

	@Transactional
	public final Invoice getInvoice(final int invId) {
		return invoiceD.getInvoice(invId);
	}

	@Transactional
	public List getAllInvoices() {
		return invoiceD.getAllInvoices();
	}

}
