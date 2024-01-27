package com.shubham.bbps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerParams {
	@JsonProperty("Account Number")
	private String accountNumber;

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
