package invoice.model.service;

import invoice.model.dao.InvoiceDao;
import invoice.model.dao.ReadDao;
import invoice.model.enties.CounterStatusesReads;
import invoice.model.enties.Invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadServiceImpl implements ReadService{

	@Autowired
	private ReadDao readDao;
	
	@Transactional
	public void add(CounterStatusesReads elem) {
		readDao.add(elem);
	}	
	
	@Transactional
	public void edit(CounterStatusesReads elem) {
		readDao.edit(elem);
	}

	@Transactional
	public void delete(final int elemId) {
		readDao.delete(elemId);
	}

	@Transactional
	public final CounterStatusesReads getElem(final int readId) {
		return readDao.getElem(readId);
	}

	@Transactional
	public List getAllElems() {
		return readDao.getAllElems();
	}

}
