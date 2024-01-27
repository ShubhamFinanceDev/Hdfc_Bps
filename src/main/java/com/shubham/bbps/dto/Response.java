package com.shubham.bbps.dto;

public class Response {
  private String code;
  
  private String status;
  
  private HDFCFetchResponse payload;
  
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
  
  public HDFCFetchResponse getPayload() {
    return this.payload;
  }
  
  public void setPayload(HDFCFetchResponse payload) {
    this.payload = payload;
  }
}
