package invoice.model.dao;

import invoice.model.enties.Counter;
import invoice.model.enties.Invoice;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDaoImpl implements CounterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Counter counter) {
		sessionFactory.getCurrentSession().save(counter);
	}

	@Override
	public void edit(Counter counter) {
		sessionFactory.getCurrentSession().update(counter);
	}

	@Override
	public void delete(int counterId) {
		sessionFactory.getCurrentSession().delete(getCounter(counterId));
	}

	@Override
	public Counter getCounter(int counterId) {
		return (Counter)sessionFactory.getCurrentSession().get(Counter.class, counterId);
	}

	@Override
	public List getAllCounters() {
		return sessionFactory.getCurrentSession().createQuery("from Counter").list();
	}

}
