package com.shubham.bbps.dto;

import java.math.BigInteger;

public class CustomerDetails {
	private String name;

	private BigInteger phoneNumber;

	private String emailId;

	private String loanaccountnumber;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLoanaccountnumber() {
		return loanaccountnumber;
	}

	public void setLoanaccountnumber(String loanaccountnumber) {
		this.loanaccountnumber = loanaccountnumber;
	}

}
