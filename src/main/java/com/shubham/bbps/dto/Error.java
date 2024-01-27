package com.shubham.bbps.dto;

public class Error {
  private String code;
  
  private String status;
  
  private ErrorBean payload;
  
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
  
  public ErrorBean getPayload() {
    return this.payload;
  }
  
  public void setPayload(ErrorBean payload) {
    this.payload = payload;
  }
}

