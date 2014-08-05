package invoice.model.service;

import invoice.model.enties.CounterStatusesReads;

import java.util.List;

public interface ReadService {
	void add(CounterStatusesReads elem);
	void edit(CounterStatusesReads elem);
	void delete(int elemId);
	CounterStatusesReads getElem(int elemId);
	List getAllElems();
}
