package invoice.model.enties;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="counter_statuses_reads")
public class CounterStatusesReads {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CSR_GEN")
	@SequenceGenerator(name="SEQ_CSR_GEN", sequenceName="SEQ_CSR", allocationSize=1)
	@Column(name="csr_id")
	private int id;
	
	@Column(name="csr_date")
	private Date readDate ;
	
	@OneToMany (mappedBy = "counterStatsReads")
	private List<CounterStatus> counterStatusesList;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
}
