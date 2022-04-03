package com.ips.gateway.api.processor;

import org.springframework.http.ResponseEntity;

/**
 * 
 * @author Erik
 * This interface is for sending requests to processor API.
 */

public interface InternalRequestController {
	// TODO need to add parameters
	/**
	 * This method send request to processor to create new payin operation
	 * @return ResponseEntity<String>
	 * It is status which we get from request.
	 */
	public ResponseEntity<String> createPayin(); 
	
	
	/**
	 * This method send request to processor to get information about payin operation
	 * @return ResponseEntity<String>
	 * It is status which we get from request.
	 */
	public ResponseEntity<String> getPayin();
	
	
	/**
	 * This method send request to processor to update payin operation
	 * @return ResponseEntity<String>
	 * It is status which we get from request.
	 */
	public ResponseEntity<String> updatePayin();
	
	
	/**
	 * This method send request to processor to create payout operation
	 * @return ResponseEntity<String>
	 * It is status which we get from request.
	 */
	public ResponseEntity<String> createPayout();
	
	
	/**
	 * This method send request to processor to get information about payout operation
	 * @return ResponseEntity<String>
	 * It is status which we get from request.
	 */
	public ResponseEntity<String> getPayout();
	
	
	/**
	 * This method send request to processor to update payout operation
	 * @return ResponseEntity<String>
	 * It is status which we get from request.
	 */
	public ResponseEntity<String> updatePayout();
}
