package com.shubham.bbps.dto;

public class PayuPayment {
  private String refId;
  
  private String billerTxnNumber;
  private String transactiontimestamp;
  private String transactionStatus;
  private String txnId;
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
public String getTransactiontimestamp() {
	return transactiontimestamp;
}
public void setTransactiontimestamp(String transactiontimestamp) {
	this.transactiontimestamp = transactiontimestamp;
}
public String getTransactionStatus() {
	return transactionStatus;
}
public void setTransactionStatus(String transactionStatus) {
	this.transactionStatus = transactionStatus;
}
public String getTxnId() {
	return txnId;
}
public void setTxnId(String txnId) {
	this.txnId = txnId;
}
  
  
}
