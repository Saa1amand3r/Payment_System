package com.ips.gateway.api.processor;
import org.springframework.http.ResponseEntity;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.ips.gateway.api.processor.validator.EmptyVariableException;
import com.ips.gateway.api.processor.validator.WrongDataLenghtException;

/**
 * 
 * @author Erik
 * This interface receive payin requests from client side.
 * It also parse and validate requests,
 *  	and send it to internal controller which is redirect it to one of the microservices.
 */

@JsonRpcService("/payment/payin")
public interface ExternalRequestControllerForPayin {
	/**
	 * This method receive requests for creating payin operation
	 * @return ResponseEntity<String>
	 * Return status of current operation
	 * @throws WrongDataLenghtException 
	 * Exception is thrown if UUID is too big or too short
	 * @throws EmptyVariableException 
	 * Exception is thrown if UUID is empty.
	 */
	public ResponseEntity<String> create(String UUID) throws EmptyVariableException, WrongDataLenghtException;
	
	/**
	 * This method receive requests for updating payin operation
	 * @return ResponseEntity<String>
	 * Return status of current operation
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 * @throws EmptyVariableException 
	 * Exception is thrown if UUID is empty.
	 */
	public ResponseEntity<String> update(String UUID) throws EmptyVariableException, WrongDataLenghtException;
	
	/**
	 * This method receive requests for getting information about payin operation
	 * @return ResponseEntity<String>
	 * Return status of current operation
	 * @throws WrongDataLenghtException
	 * Exception is thrown if UUID is too big or too short
	 * @throws EmptyVariableException 
	 * Exception is thrown if UUID is empty.
	 */
	public ResponseEntity<String> get(String UUID) throws EmptyVariableException, WrongDataLenghtException;
}
