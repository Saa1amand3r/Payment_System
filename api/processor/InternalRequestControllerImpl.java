package com.ips.gateway.api.processor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class InternalRequestControllerImpl implements InternalRequestController {
	RestTemplate rest = new RestTemplate(); // initializing RestTemplate for requesting
	/*
	 * Static string with url for every method: create, update and get. 
	 */
	private static final String PayinCreateUrl ="http://localhost:8303/payment/payin/create";
	private static final String PayinGetUrl ="http://localhost:8303/payment/payin/get";
	private static final String PayinUpdateUrl ="http://localhost:8303/payment/payin/update";
	private static final String PayoutCreateUrl ="http://localhost:8303/payment/payout/create";
	private static final String PayoutUpdateUrl ="http://localhost:8303/payment/payout/update";
	private static final String PayoutGetUrl ="http://localhost:8303/payment/payout/get";
	
	@Override
	public ResponseEntity<String> createPayin() {
		ResponseEntity<String> status; // we need a string variable with status for response
		status = rest.getForEntity(PayinCreateUrl, String.class); //sending payin create request to processor
		return status; // returning status of request
	}

	@Override
	public ResponseEntity<String> getPayin() {
		ResponseEntity<String> status; // we need a string variable with status for response
		status = rest.getForEntity(PayinGetUrl, String.class); //sending payin get request to processor
		return status; // returning status of request
	}

	@Override
	public ResponseEntity<String> updatePayin() {
		ResponseEntity<String> status;
		status = rest.getForEntity(PayinUpdateUrl, String.class); //sending payin update request to processor
		return status;
	}

	@Override
	public ResponseEntity<String> createPayout() {
		ResponseEntity<String> status;
		status = rest.getForEntity(PayoutCreateUrl, String.class); //sending payout create request to processor
		return status;
	}

	@Override
	public ResponseEntity<String> getPayout() {
		ResponseEntity<String> status;
		status = rest.getForEntity(PayoutGetUrl, String.class); //sending payout get request to processor
		return status;
	}

	@Override
	public ResponseEntity<String> updatePayout() {
		ResponseEntity<String> status;
		status = rest.getForEntity(PayoutUpdateUrl, String.class); //sending payout update request to processor
		return status;
	}
	
}
