package invoice.model.dao;

import invoice.model.enties.Invoice;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
	
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
