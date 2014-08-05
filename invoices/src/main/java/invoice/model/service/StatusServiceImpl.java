package invoice.model.service;

import invoice.model.dao.CounterDao;
import invoice.model.dao.CounterStatusDao;
import invoice.model.dao.InvoiceDao;
import invoice.model.enties.Counter;
import invoice.model.enties.CounterStatus;
import invoice.model.enties.Invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private CounterStatusDao statusDao;
	
	@Transactional
	public void add(CounterStatus status) {
		statusDao.add(status);
	}	
	
	@Transactional
	public void edit(CounterStatus status) {
		statusDao.edit(status);
	}

	@Transactional
	public void delete(final int statusId) {
		statusDao.delete(statusId);
	}

	@Transactional
	public final CounterStatus getStatus(final int statusId) {
		return statusDao.getStatus(statusId);
	}

	@Transactional
	public List getAllStatuses() {
		return statusDao.getAllStatuses();
	}

}
