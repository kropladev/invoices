package invoice.model.enties;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="counters")
public class Counter {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COUNT_GEN")
	@SequenceGenerator(name="SEQ_COUNT_GEN", sequenceName="SEQ_COUNT", allocationSize=1)
	@Column(name="c_id")
	private int id;
	
	@Column(name="c_serial")
	private int serial;
	
	@Column(name="c_active")
	private boolean active;
	
	@Column(name="i_description")
	private String description;

/*	public Set<CounterStatus> getCounterStatuses() {
		return counterStatuses;
	}

	public void setCounterStatuses(Set<CounterStatus> counterStatuses) {
		this.counterStatuses = counterStatuses;
	}

	@OneToMany(mappedBy="counter")
	private Set<CounterStatus> counterStatuses;
	*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
