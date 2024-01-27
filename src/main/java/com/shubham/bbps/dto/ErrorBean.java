package com.shubham.bbps.dto;


public class ErrorBean {
  private String errorCode;
  
  private String reason;
  
  public String getErrorCode() {
    return this.errorCode;
  }
  
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public void setReason(String reason) {
    this.reason = reason;
  }
}