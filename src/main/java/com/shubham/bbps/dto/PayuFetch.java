package com.shubham.bbps.dto;


import java.util.List;

public class PayuFetch {
  private String refId;
  
  private String billerTxnNumber;
  
  private CustomerDetails customerDetails;
  
  private List<Object> amountDetails;
  
  private List<Params> blrAdditionalInfo;
  
  private Double totalAmount;
  
  private String dueDate;
  
  private String billNumber;
  
  private String billDate;
  
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
  
  public CustomerDetails getCustomerDetails() {
    return this.customerDetails;
  }
  
  public void setCustomerDetails(CustomerDetails customerDetails) {
    this.customerDetails = customerDetails;
  }
  
  public List<Object> getAmountDetails() {
    return this.amountDetails;
  }
  
  public void setAmountDetails(List<Object> amountDetails) {
    this.amountDetails = amountDetails;
  }
  
  public List<Params> getBlrAdditionalInfo() {
    return this.blrAdditionalInfo;
  }
  
  public void setBlrAdditionalInfo(List<Params> blrAdditionalInfo) {
    this.blrAdditionalInfo = blrAdditionalInfo;
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
}
