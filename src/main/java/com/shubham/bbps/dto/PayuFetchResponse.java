package com.shubham.bbps.dto;

public class PayuFetchResponse {
  private String status;
  
  private PayuFetch payuFetch;
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public PayuFetch getPayuFetch() {
    return this.payuFetch;
  }
  
  public void setPayuFetch(PayuFetch payuFetch) {
    this.payuFetch = payuFetch;
  }
}
