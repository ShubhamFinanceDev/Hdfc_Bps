package com.shubham.bbps.dto;

public class ResponseReceipt {
	private String code;

	private String refId;

	private String billerTxnNumber;
	private String transactiontimestamp;
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactiontimestamp() {
		return transactiontimestamp;
	}

	public void setTransactiontimestamp(String transactiontimestamp) {
		this.transactiontimestamp = transactiontimestamp;
	}

}
