package invoice.model.service;

import invoice.model.enties.Counter;

import java.util.List;

public interface CounterService {
	void add(Counter counter);
	void edit(Counter counter);
	void delete(int counterId);
	Counter getCounter(int counterId);
	List getAllCounters();
}
