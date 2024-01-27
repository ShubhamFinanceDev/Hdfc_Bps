package com.shubham.bbps.dto;


import java.util.List;

public class Payu {
  private String refId;
  private String loanaccountnumber;
  private String billerTxnNumber;
  
  private String billerTxnId;
  
  private Double totalAmount;
  
  private Double amount;
  
  private String dueDate;
  
  private String billNumber;
  
  private String billDate;
  
  private Double pendingInstallment;
  
  private Double emiOverdue;
  
  private Double totalCharges;
  
  private Double chargesOverdue;
  
  private Double amountpaid;
  
  private Double closingamount;
  
  private Double openingamount;
  
  private String planId;
  
  private String paymentName;
  
  private String txnId;
  private String status;
  private String transactiontimestamp;
  
  public String getRefId() {
    return this.refId;
  }
  
  public void setRefId(String refId) {
    this.refId = refId;
  }
  
  
  
  public Double getPendingInstallment() {
    return this.pendingInstallment;
  }
  
  public void setPendingInstallment(Double pendingInstallment) {
    this.pendingInstallment = pendingInstallment;
  }
  
  public Double getEmiOverdue() {
    return this.emiOverdue;
  }
  
  public void setEmiOverdue(Double emiOverdue) {
    this.emiOverdue = emiOverdue;
  }
  
  public Double getTotalCharges() {
    return this.totalCharges;
  }
  
  public void setTotalCharges(Double totalCharges) {
    this.totalCharges = totalCharges;
  }
  
  public Double getChargesOverdue() {
    return this.chargesOverdue;
  }
  
  public void setChargesOverdue(Double chargesOverdue) {
    this.chargesOverdue = chargesOverdue;
  }
  
  public Double getTotalAmount() {
    return this.totalAmount;
  }
  
  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }
  
  public String getDueDate() {
    return this.dueDate;
  }
  
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }
  
  public String getBillNumber() {
    return this.billNumber;
  }
  
  public void setBillNumber(String billNumber) {
    this.billNumber = billNumber;
  }
  
  public String getBillDate() {
    return this.billDate;
  }
  
  public void setBillDate(String billDate) {
    this.billDate = billDate;
  }
  
  public Double getAmountpaid() {
    return this.amountpaid;
  }
  
  public void setAmountpaid(Double amountpaid) {
    this.amountpaid = amountpaid;
  }
  
  public Double getClosingamount() {
    return this.closingamount;
  }
  
  public void setClosingamount(Double closingamount) {
    this.closingamount = closingamount;
  }
  
  public Double getOpeningamount() {
    return this.openingamount;
  }
  
  public void setOpeningamount(Double openingamount) {
    this.openingamount = openingamount;
  }
  
  public String getPlanId() {
    return this.planId;
  }
  
  public void setPlanId(String planId) {
    this.planId = planId;
  }
  
  public String getPaymentName() {
    return this.paymentName;
  }
  
  public void setPaymentName(String paymentName) {
    this.paymentName = paymentName;
  }
  
  public String getTxnId() {
    return this.txnId;
  }
  
  public void setTxnId(String txnId) {
    this.txnId = txnId;
  }
  
  public String getBillerTxnNumber() {
    return this.billerTxnNumber;
  }
  
  public void setBillerTxnNumber(String billerTxnNumber) {
    this.billerTxnNumber = billerTxnNumber;
  }
  
  public String getBillerTxnId() {
    return this.billerTxnId;
  }
  
  public void setBillerTxnId(String billerTxnId) {
    this.billerTxnId = billerTxnId;
  }
  
  public Double getAmount() {
    return this.amount;
  }
  
  public void setAmount(Double amount) {
    this.amount = amount;
  }

public String getLoanaccountnumber() {
	return loanaccountnumber;
}

public void setLoanaccountnumber(String loanaccountnumber) {
	this.loanaccountnumber = loanaccountnumber;
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