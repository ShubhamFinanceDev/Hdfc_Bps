package com.shubham.bbps.dto;

import java.math.BigInteger;

public class HDFCFetchResponse {
	private String status;
	private String refId;
	private String billerTxnNumber;
	private String name;
	private BigInteger phoneNumber;
	private String loanaccountnumber;
	private Double totalAmount;
	private String dueDate;
	private String billNumber;
	private String billDate;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getBillerTxnNumber() {
		return billerTxnNumber;
	}

	public void setBillerTxnNumber(String billerTxnNumber) {
		this.billerTxnNumber = billerTxnNumber;
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

	public String getLoanaccountnumber() {
		return loanaccountnumber;
	}

	public void setLoanaccountnumber(String loanaccountnumber) {
		this.loanaccountnumber = loanaccountnumber;
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

}
