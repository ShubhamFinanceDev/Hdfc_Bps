package com.shubham.bbps.dto;


public class Params {
  private String dataType;
  
  private String optional;
  
  private String paramName;
  
  public String getDataType() {
    return this.dataType;
  }
  
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }
  
  public String getOptional() {
    return this.optional;
  }
  
  public void setOptional(String optional) {
    this.optional = optional;
  }
  
  public String getParamName() {
    return this.paramName;
  }
  
  public void setParamName(String paramName) {
    this.paramName = paramName;
  }
}
