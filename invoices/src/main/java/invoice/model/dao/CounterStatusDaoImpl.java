package invoice.model.dao;

import invoice.model.enties.CounterStatus;
import invoice.model.enties.Invoice;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterStatusDaoImpl implements CounterStatusDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(CounterStatus status) {
		sessionFactory.getCurrentSession().save(status);
	}

	@Override
	public void edit(CounterStatus status) {
		sessionFactory.getCurrentSession().update(status);
	}

	@Override
	public void delete(int statusId) {
		sessionFactory.getCurrentSession().delete(getStatus(statusId));
	}

	@Override
	public CounterStatus getStatus(int statusId) {
		return (CounterStatus)sessionFactory.getCurrentSession().get(CounterStatus.class, statusId);
	}

	@Override
	public List getAllStatuses() {
		return sessionFactory.getCurrentSession().createQuery("from CounterStatus").list();
	}

}
