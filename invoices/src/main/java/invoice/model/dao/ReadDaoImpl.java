package invoice.model.dao;

import invoice.model.enties.Counter;
import invoice.model.enties.CounterStatusesReads;
import invoice.model.enties.Invoice;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReadDaoImpl implements ReadDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(CounterStatusesReads elem) {
		sessionFactory.getCurrentSession().save(elem);
	}

	@Override
	public void edit(CounterStatusesReads elem) {
		sessionFactory.getCurrentSession().update(elem);
	}

	@Override
	public void delete(int elemId) {
		sessionFactory.getCurrentSession().delete(getElem(elemId));
	}

	@Override
	public CounterStatusesReads getElem(int elemId) {
		return (CounterStatusesReads)sessionFactory.getCurrentSession().get(CounterStatusesReads.class, elemId);
	}

	@Override
	public List getAllElems() {
		return sessionFactory.getCurrentSession().createQuery("from CounterStatusesReads").list();
	}

}
