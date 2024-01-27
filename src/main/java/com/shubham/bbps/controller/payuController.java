package com.shubham.bbps.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.bbps.dto.CustomerDetails;
import com.shubham.bbps.dto.EmiAmountDetails;
import com.shubham.bbps.dto.Error;
import com.shubham.bbps.dto.ErrorBean;
import com.shubham.bbps.dto.HDFCFetchResponse;
import com.shubham.bbps.dto.InvoiceBean;
import com.shubham.bbps.dto.Payu;
import com.shubham.bbps.dto.PayuFetch;
import com.shubham.bbps.dto.PayuFetchResponse;
import com.shubham.bbps.dto.PayuPayment;
import com.shubham.bbps.dto.ReceiptBean;
import com.shubham.bbps.dto.Response;
import com.shubham.bbps.dto.ResponsePayment;
import com.shubham.bbps.dto.ResponseReceipt;
import com.shubham.bbps.dto.TotalAmountDetails;
import com.shubham.bbps.model.PayuModal;
import com.shubham.bbps.repository.PayuRepository;
import com.shubham.bbps.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "This is BBPS PayU API Documentation", description = "This API provides the capability to search Payu Payment from a Payu Repository", produces = "application/json")
public class payuController {
	private static final Logger LOGGER = LoggerFactory.getLogger(com.shubham.bbps.controller.payuController.class);

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired(required = true)
	PayuRepository payuRepository;

	@Autowired
	@Qualifier("jdbcTemplate2")
	private JdbcTemplate osourceTemplate;

	@ApiOperation(value = "Return Fetch Bill Receipt Data", produces = "application/json")
	@PostMapping({ "/billfetchreceipt" })
	public ResponseEntity<Payu> billfetchreceipt(@Valid @RequestBody Payu payu, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat tranddmmyy = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfdb = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(request.getHeader("Authorization"));
		try {
			if (request.getHeader("Authorization") == null) {
				Error error = new Error();
				error.setCode("600");
				error.setStatus("FAILURE");
				ErrorBean payload = new ErrorBean();
				payload.setErrorCode("401");
				payload.setReason("Unauthorised access!");
				error.setPayload(payload);
				LOGGER.error(error.toString());
				return new ResponseEntity(error, HttpStatus.OK);
			}
			String matchwith = payu.getRefId() + Constants.KEY + Constants.SALT + "0.0";
			System.out.println("matchwith------------" + matchwith);
			if (!this.bCryptPasswordEncoder.matches(matchwith, request.getHeader("Authorization"))) {
				Error error = new Error();
				error.setCode("600");
				error.setStatus("FAILURE");
				ErrorBean payload = new ErrorBean();
				payload.setErrorCode("401");
				payload.setReason("Unauthorised access!");
				error.setPayload(payload);
				LOGGER.error(error.toString());
				return new ResponseEntity(error, HttpStatus.OK);
			}
			String query = "select * from MGATE_LOAN_DETAILS a where a.loan_account_number=?";
			Map<String, Object> loginMap = null;
			try {
				System.out.println("Loan Account Number:-" + payu.getLoanaccountnumber());
				loginMap = this.osourceTemplate.queryForMap(query,
						new Object[] { payu.getLoanaccountnumber() });
			} catch (EmptyResultDataAccessException ex) {
				System.out.println("Exception.......");
				loginMap = null;
			}
			HDFCFetchResponse actor = new HDFCFetchResponse();
			if (loginMap == null || loginMap.isEmpty()) {
				actor = null;
				Error error = new Error();
				error.setCode("600");
				error.setStatus("FAILURE");
				ErrorBean payload = new ErrorBean();
				payload.setErrorCode("BFR001");
				payload.setReason("Incorrect / invalid customer account");
				error.setPayload(payload);
				LOGGER.error(error.toString());
				return new ResponseEntity(error, HttpStatus.OK);
			} else {

				actor.setStatus("success");
				actor.setRefId(payu.getRefId());
				actor.setName((String) loginMap.get("CUSTOMER_NAME"));
				actor.setLoanaccountnumber((String) loginMap.get("LOAN_ACCOUNT_NUMBER"));
				BigInteger result = new BigInteger((String) loginMap.get("PHONE_NUMBER"));
				actor.setPhoneNumber(result);
				actor.setDueDate((String) loginMap.get("DUE_DATE"));
				actor.setBillDate((String) loginMap.get("BILL_DATE"));
				actor.setTotalAmount((Double) loginMap.get("EMI_OVERDUE"));
				actor.setBillNumber(tranddmmyy.format(new Date()) + getAlphaNumericString(6));
				actor.setBillerTxnNumber(payu.getBillNumber());


				if (actor.getTotalAmount() == null) {
					if (actor.getStatus().equalsIgnoreCase("BFR009")) {
						Error error1 = new Error();
						error1.setCode("600");
						error1.setStatus("FAILURE");
						ErrorBean errorBean = new ErrorBean();
						errorBean.setErrorCode("BFR009");
						errorBean.setReason("Communication failure");
						error1.setPayload(errorBean);
						LOGGER.error(actor.getStatus());
						return new ResponseEntity(error1, HttpStatus.OK);
					}

				}
				if (actor.getTotalAmount().doubleValue() <= 0.0D) {
					Error error = new Error();
					error.setCode("600");
					error.setStatus("FAILURE");
					ErrorBean payload = new ErrorBean();
					payload.setErrorCode("BFR004");
					payload.setReason("Payment received for the billing period-no bill due");
					error.setPayload(payload);
					LOGGER.error(error.toString());
					return new ResponseEntity(error, HttpStatus.OK);
				}
			}
			PayuModal payuModal = new PayuModal();
			payuModal.setRfid(actor.getRefId());
			payuModal.setLoanaccountppnumber(payu.getLoanaccountnumber());
			payuModal.setPhoneNumber(actor.getPhoneNumber());
			payuModal.setName(actor.getName());
			payuModal.setDueDate(actor.getDueDate());

			payuModal.setTotalAmount(actor.getTotalAmount());
			payuModal.setBillerTxnNumber(actor.getBillerTxnNumber());
			payuModal.setBillDate(actor.getBillDate());
			payuModal.setCreatedAt(new Date());
			this.payuRepository.save(payuModal);
			Response response = new Response();
			response.setCode("200");
			response.setStatus("SUCCESS");
			response.setPayload(actor);
			LOGGER.info(actor.toString());
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("BFR009");
			payload.setReason("Communication failure");
			error.setPayload(payload);
			LOGGER.error(e.getMessage() + error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Submit Payment Bill Receipt Data", produces = "application/json")
	@PostMapping({ "/billpaymentreceipt" })
	public ResponseEntity<Payu> billpaymentreceipt(@Valid @RequestBody Payu payu, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(request.getHeader("Authorization"));
		if (request.getHeader("Authorization") == null) {
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("401");
			payload.setReason("Unauthorised access!");
			error.setPayload(payload);
			LOGGER.error(error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
		String matchwith = payu.getRefId() + Constants.KEY + Constants.SALT + payu.getAmount();
		System.out.println("matchwith------------" + matchwith);
		if (!this.bCryptPasswordEncoder.matches(matchwith, request.getHeader("Authorization"))) {
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("401");
			payload.setReason("Unauthorised access!");
			error.setPayload(payload);
			LOGGER.error(error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
		try {
			PayuModal payuModal = this.payuRepository.fetchReceiptbyRfid(payu.getRefId());
			if (payuModal != null && payu.getLoanaccountnumber()
					.equalsIgnoreCase(payuModal.getLoanaccountppnumber())) {
				if (payu.getAmount().doubleValue() >= Constants.MIN_AMOUNT_PAID.doubleValue()) {
					payuModal.setTxnId(payu.getTxnId());
					payuModal.setAmountpaid(payu.getAmount());
					payuModal.setPlanId(payu.getPlanId());
					payuModal.setBillNumber(payu.getBillerTxnNumber());
					payuModal.setPaymentName(payu.getPaymentName());
					payuModal.setUpdatedAt(new Date());
					payuModal.setStatus(payu.getStatus());
					payuModal.setTransactiontimestamp(payu.getTransactiontimestamp());
					payuModal.setOpeningamount(payuModal.getTotalAmount());
					payuModal.setClosingamount(Double.valueOf(
							payuModal.getTotalAmount().doubleValue() - payuModal.getAmountpaid().doubleValue()));
					this.payuRepository.save(payuModal);
					ResponsePayment response = new ResponsePayment();
					response.setCode("200");
					response.setStatus("SUCCESS");
					PayuPayment paylod = new PayuPayment();
					paylod.setRefId(payuModal.getRfid());
					paylod.setBillerTxnNumber(payuModal.getBillNumber());
					paylod.setTransactiontimestamp(payuModal.getTransactiontimestamp());
					paylod.setTransactionStatus(payuModal.getStatus());
					paylod.setTxnId(payuModal.getTxnId());
					response.setPayload(paylod);
					LOGGER.info(response.toString());
					return new ResponseEntity(response, HttpStatus.OK);
				}
				Error error1 = new Error();
				error1.setCode("600");
				error1.setStatus("FAILURE");
				ErrorBean errorBean = new ErrorBean();
				errorBean.setErrorCode("BPR013");
				errorBean.setReason("Payment amount is invalid");
				error1.setPayload(errorBean);
				LOGGER.error(error1.toString());
				return new ResponseEntity(error1, HttpStatus.OK);
			}
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("BPR001");
			payload.setReason("Incorrect / invalid customer account");
			error.setPayload(payload);
			LOGGER.error(error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("BPR009");
			payload.setReason("Communication failure");
			error.setPayload(payload);
			LOGGER.error(e.getMessage() + error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Return Fetch Receipt Payment Status", produces = "application/json")
	@PostMapping({ "/paymentstatus" })
	public ResponseEntity<Payu> paymentstatus(@Valid @RequestBody Payu payu, HttpServletRequest request) {
		System.out.println(request.getHeader("Authorization"));
		if (request.getHeader("Authorization") == null) {
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("401");
			payload.setReason("Unauthorised access!");
			error.setPayload(payload);
			LOGGER.error(error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
		String matchwith = payu.getRefId() + Constants.KEY + Constants.SALT + "0.0";
		System.out.println("matchwith------------" + matchwith);
		if (!this.bCryptPasswordEncoder.matches(matchwith, request.getHeader("Authorization"))) {
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("401");
			payload.setReason("Unauthorised access!");
			error.setPayload(payload);
			LOGGER.error(error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
		try {
			PayuModal payuModal = this.payuRepository.fetchPaymentstatus(payu.getRefId(), payu.getBillerTxnId());
			ResponseReceipt receipt = new ResponseReceipt();
			if (payuModal != null) {
				if (payuModal.getAmountpaid() == null) {
					receipt.setCode("200");
					receipt.setStatus("SUCCESS");

					receipt.setRefId(payuModal.getRfid());
					receipt.setBillerTxnNumber(payuModal.getBillNumber());
					receipt.setTransactiontimestamp(payuModal.getTransactiontimestamp());
					receipt.setStatus("PAYMENT_PENDING");

				} else {
					receipt.setCode("200");
					receipt.setStatus("SUCCESS");

					receipt.setRefId(payuModal.getRfid());
					receipt.setBillerTxnNumber(payuModal.getBillNumber());
					receipt.setTransactiontimestamp(payuModal.getTransactiontimestamp());
					receipt.setStatus("PAYMENT_SUCCESS");

				}
			} else {
				receipt.setCode("200");
				receipt.setStatus("SUCCESS");
				receipt.setRefId(payu.getRefId());
				receipt.setStatus("RECORD_NOT_FOUND");

			}
			LOGGER.info(receipt.toString());
			return new ResponseEntity(receipt, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCode("600");
			error.setStatus("FAILURE");
			ErrorBean payload = new ErrorBean();
			payload.setErrorCode("BPR009");
			payload.setReason("Communication failure");
			error.setPayload(payload);
			LOGGER.error(e.getMessage() + error.toString());
			return new ResponseEntity(error, HttpStatus.OK);
		}
	}

	public String getAlphaNumericString(int n) {
		String AlphaNumericString = "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
}
