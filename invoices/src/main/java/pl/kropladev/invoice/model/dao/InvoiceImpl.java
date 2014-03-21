package pl.kropladev.invoice.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.kropladev.invoice.model.enties.Invoice;

@Repository
public class InvoiceImpl implements InvoiceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Invoice invoice) {
		sessionFactory.getCurrentSession().save(invoice);
	}

	@Override
	public void edit(Invoice invoice) {
		sessionFactory.getCurrentSession().update(invoice);
	}

	@Override
	public void delete(int invId) {
		sessionFactory.getCurrentSession().delete(getInvoice(invId));
	}

	@Override
	public Invoice getInvoice(int invId) {
		return (Invoice)sessionFactory.getCurrentSession().get(Invoice.class, invId);
	}

	@Override
	public List getAllInvoices() {
		return sessionFactory.getCurrentSession().createQuery("from Invoice").list();
	}

}
