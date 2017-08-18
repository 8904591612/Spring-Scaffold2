package com.example.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.Integer; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 


@Entity
@Table(name = "payment_reg")
public class Payment_reg implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;

	

   
    @Column(name = "organisers")
    private String organisers;

  /*  @Column(name = "transaction_id")
    private String transaction_id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "sbi_ref_no")
    private String sbi_ref_no;

    @Column(name = "payment_date")
    private String payment_date;

    @Column(name = "status")
    private String status;

    @Column(name = "status_desc")
    private String status_desc;

    @Column(name = "user_desc")
    private String user_desc;

    @Column(name = "enc_data_received")
    private String enc_data_received;

    @Column(name = "currency")
    private String currency;*/

	public void setId(Integer id) {this.id = id;}
	public Integer getId() {return id;}
	public void setOrganisers(String organisers) {this.organisers = organisers;}
	public String getOrganisers() {return organisers;}
	/*public void setTransaction_id(String transaction_id) {this.transaction_id = transaction_id;}
	public String getTransaction_id() {return transaction_id;}*/
	/*public void setAmount(String amount) {this.amount = amount;}
	public String getAmount() {return amount;}
	public void setSbi_ref_no(String sbi_ref_no) {this.sbi_ref_no = sbi_ref_no;}
	public String getSbi_ref_no() {return sbi_ref_no;}
	public void setPayment_date(String payment_date) {this.payment_date = payment_date;}
	public String getPayment_date() {return payment_date;}
	public void setStatus(String status) {this.status = status;}
	public String getStatus() {return status;}
	public void setStatus_desc(String status_desc) {this.status_desc = status_desc;}
	public String getStatus_desc() {return status_desc;}
	public void setUser_desc(String user_desc) {this.user_desc = user_desc;}
	public String getUser_desc() {return user_desc;}
	public void setEnc_data_received(String enc_data_received) {this.enc_data_received = enc_data_received;}
	public String getEnc_data_received() {return enc_data_received;}
	public void setCurrency(String currency) {this.currency = currency;}
	public String getCurrency() {return currency;}*/

	
	
}