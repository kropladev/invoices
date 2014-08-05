package invoice.model.dao;

import invoice.model.enties.Counter;

import java.util.List;

public interface CounterDao {
	void add(Counter counter);
	void edit(Counter counter);
	void delete(int invId);
	Counter getCounter(int invId);
	List getAllCounters();
}
