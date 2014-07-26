package invoice.model.enties;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="counter_status")
public class CounterStatuses {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CS_GEN")
	@SequenceGenerator(name="SEQ_CS_GEN", sequenceName="SEQ_INV", allocationSize=1)
	@Column(name="cs_id")
	private int id;
	
	@Column(name="cs_amount")
	private double amount;
	
	@Column(name="cs_read_date")
	private Date readDate;
	
}
