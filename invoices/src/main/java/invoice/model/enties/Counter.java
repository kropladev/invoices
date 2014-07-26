package invoice.model.enties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
