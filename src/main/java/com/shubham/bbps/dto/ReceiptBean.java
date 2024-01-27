package com.shubham.bbps.dto;

public class ReceiptBean {
	private String refId;

	private String billerTxnNumber;

	private String status;

	public String getRefId() {
		return this.refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getBillerTxnNumber() {
		return this.billerTxnNumber;
	}

	public void setBillerTxnNumber(String billerTxnNumber) {
		this.billerTxnNumber = billerTxnNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}