package invoice.model.service;

import invoice.model.dao.CounterDao;
import invoice.model.dao.InvoiceDao;
import invoice.model.enties.Counter;
import invoice.model.enties.Invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterServiceImpl implements CounterService{

	@Autowired
	private CounterDao counterDao;
	
	@Transactional
	public void add(Counter counter) {
		counterDao.add(counter);
	}	
	
	@Transactional
	public void edit(Counter counter) {
		counterDao.edit(counter);
	}

	@Transactional
	public void delete(final int counterId) {
		counterDao.delete(counterId);
	}

	@Transactional
	public final Counter getCounter(final int counterId) {
		return counterDao.getCounter(counterId);
	}

	@Transactional
	public List getAllCounters() {
		return counterDao.getAllCounters();
	}

}
