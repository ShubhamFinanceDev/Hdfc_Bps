package com.shubham.bbps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "hdfc_payment")
@EntityListeners({ AuditingEntityListener.class })
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class PayuModal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "rfid")
	private String rfid;

	@Column(name = "pendingInstallment")
	private Double pendingInstallment;
	@Column(name = "loanaccountppnumber")
	private String loanaccountppnumber;
	@Column(name = "name")
	private String name;
	@Column(name = "phoneNumber")
	private BigInteger phoneNumber;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "emiOverdue")
	private Double emiOverdue;
	@Column(name = "totalCharges")
	private Double totalCharges;
	@Column(name = "chargesOverdue")
	private Double chargesOverdue;
	@Column(name = "totalOverdue")
	private Double totalOverdue;
	@Column(name = "totalAmount")
	private Double totalAmount;
	@Column(name = "dueDate")
	private String dueDate;
	@Column(name = "billNumber")
	private String billNumber;
	@Column(name = "billDate")
	private String billDate;
	@Column(name = "amountpaid")
	private Double amountpaid;
	@Column(name = "closingamount")
	private Double closingamount;
	@Column(name = "openingamount")
	private Double openingamount;
	@Column(name = "planId")
	private String planId;
	@Column(name = "paymentName")
	private String paymentName;
	@Column(name = "txnId")
	private String txnId;
	@Column(name = "billerTxnNumber")
	private String billerTxnNumber;
	@Column(name = "status")
	private String status;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	@Column(name = "transactiontimestamp")
	private String transactiontimestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public Double getPendingInstallment() {
		return pendingInstallment;
	}

	public void setPendingInstallment(Double pendingInstallment) {
		this.pendingInstallment = pendingInstallment;
	}

	public String getLoanaccountppnumber() {
		return loanaccountppnumber;
	}

	public void setLoanaccountppnumber(String loanaccountppnumber) {
		this.loanaccountppnumber = loanaccountppnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getEmiOverdue() {
		return emiOverdue;
	}

	public void setEmiOverdue(Double emiOverdue) {
		this.emiOverdue = emiOverdue;
	}

	public Double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(Double totalCharges) {
		this.totalCharges = totalCharges;
	}

	public Double getChargesOverdue() {
		return chargesOverdue;
	}

	public void setChargesOverdue(Double chargesOverdue) {
		this.chargesOverdue = chargesOverdue;
	}

	public Double getTotalOverdue() {
		return totalOverdue;
	}

	public void setTotalOverdue(Double totalOverdue) {
		this.totalOverdue = totalOverdue;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Double getAmountpaid() {
		return amountpaid;
	}

	public void setAmountpaid(Double amountpaid) {
		this.amountpaid = amountpaid;
	}

	public Double getClosingamount() {
		return closingamount;
	}

	public void setClosingamount(Double closingamount) {
		this.closingamount = closingamount;
	}

	public Double getOpeningamount() {
		return openingamount;
	}

	public void setOpeningamount(Double openingamount) {
		this.openingamount = openingamount;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getBillerTxnNumber() {
		return billerTxnNumber;
	}

	public void setBillerTxnNumber(String billerTxnNumber) {
		this.billerTxnNumber = billerTxnNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(String transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
	}

}
