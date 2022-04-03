package com.ips.gateway.api.processor;

import org.springframework.http.ResponseEntity;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.ips.gateway.api.processor.validator.EmptyVariableException;
import com.ips.gateway.api.processor.validator.WrongDataLenghtException;

/**
 * 
 * @author Erik
 * This interface receive payout requests from client side.
 * It also parse and validate requests,
 *  	and send it to internal controller which is redirect it to one of the microservices.
 */


@JsonRpcService("/payment/payout")
public interface ExternalRequestControllerForPayout {
	/**
	 * This method receive requests for creating payout operation
	 * @return ResponseEntity<String>
	 * Return status of current operation
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 * @throws EmptyVariableException 
	 * Exception is thrown if UUID is empty.
	 */
	public ResponseEntity<String> create(String UUID) throws EmptyVariableException, WrongDataLenghtException;
	
	/**
	 * This method receive requests for updating payout operation
	 * @return ResponseEntity<String>
	 * Return status of current operation
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 * @throws EmptyVariableException 
	 * Exception is thrown if UUID is empty.
	 */
	public ResponseEntity<String> update(String UUID) throws EmptyVariableException, WrongDataLenghtException;
	
	/**
	 * This method receive requests for getting information about payout operation
	 * @return ResponseEntity<String>
	 * Return status of current operation
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 * @throws EmptyVariableException 
	 * Exception is thrown if UUID is empty.
	 */
	public ResponseEntity<String> get(String UUID) throws EmptyVariableException, WrongDataLenghtException;
}
