package invoice.model.enties;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="counter_status")
public class CounterStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CS_GEN")
	@SequenceGenerator(name="SEQ_CS_GEN", sequenceName="SEQ_INV", allocationSize=1)
	@Column(name="cs_id")
	private int id;
	
	@Column(name="cs_amount")
	private double amount;
	
	@Column(name="cs_read_date")
	private Date readDate;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	//@Column(name = "cs_counter_id" )
	private Counter counter;

	@ManyToOne
	@JoinColumn(name = "csr_id")
	//@Column(name = "cs_counter_id" )
	private CounterStatusesReads counterStatsReads;

	
	public CounterStatusesReads getCounterStatsReads() {
		return counterStatsReads;
	}

	public void setCounterStatsReads(CounterStatusesReads counterStatsReads) {
		this.counterStatsReads = counterStatsReads;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
/*
	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}*/

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}
	
}
