package pl.kropladev.invoice.model.enties;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_INV_GEN")
	@SequenceGenerator(name="SEQ_INV_GEN", sequenceName="SEQ_INV", allocationSize=1)
	@Column(name="i_id")
	private int id;
	
	@Column(name="i_name")
	private String name;
	
	@Column(name="i_desc")
	private String description;
	
	@Column(name="i_invId")
	private String invoiceId;
	
	@Column(name="i_amount")
	private double amount;

	@Column(name="i_invDate")
   private Date invoiceDate;
   
	@Column(name="i_payDate")
	private Date payDate;
	
	@Column(name="i_motime")
	private Calendar moTime;
   
	@Column(name="i_categ")
	private String  category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payTime) {
		this.payDate = payTime;
	}
	public Calendar getMoTime() {
		return moTime;
	}
	public void setMoTime(Calendar moTime) {
		this.moTime = moTime;
	}
}
