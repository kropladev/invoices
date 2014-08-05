package invoice.model.dao;

import invoice.model.enties.Counter;
import invoice.model.enties.CounterStatusesReads;

import java.util.List;

public interface ReadDao {
	void add(CounterStatusesReads counter);
	void edit(CounterStatusesReads counter);
	void delete(int elemId);
	CounterStatusesReads getElem(int elemId);
	List getAllElems();
}
