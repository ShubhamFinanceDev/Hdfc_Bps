package com.shubham.bbps.dto;


public class ResponsePayment {
  private String code;
  
  private String status;
  
  private PayuPayment payload;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public PayuPayment getPayload() {
    return this.payload;
  }
  
  public void setPayload(PayuPayment payload) {
    this.payload = payload;
  }
}
