package invoice.model.dao;

import invoice.model.enties.CounterStatus;

import java.util.List;

public interface CounterStatusDao {
	void add(CounterStatus status);
	void edit(CounterStatus status);
	void delete(int statusId);
	CounterStatus getStatus(int statusId);
	List getAllStatuses();
}
